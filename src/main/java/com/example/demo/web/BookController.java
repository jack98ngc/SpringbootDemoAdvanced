/*
 * created on May 24, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 24, 2021 $
 */
package com.example.demo.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;
    
    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book";
    }
    
    @ExceptionHandler({Exception.class})//可傳多個{BookNotFoundException.class, SQLException.class}
    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request URL : {}, Exception: {}", request.getRequestURL(), e.getMessage());

        //若是有自行宣告ResponseStatus則不處理，直接再往外拋ex:BookNotFoundException
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null) {
            throw e;
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("url",request.getRequestURL());
        mav.addObject("exception",e);
        mav.setViewName("error/error");
        return mav;
    }

}
