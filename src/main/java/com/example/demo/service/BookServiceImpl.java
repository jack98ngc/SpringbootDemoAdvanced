/*
 * created on Jul 16, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 16, 2021 $
 */
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.exception.BookNotFoundException;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    
    
    @Override
    public Book getBookById(long id) {
        
      Book book = bookRepository.findOne(id);
      if(book==null) {
          throw new BookNotFoundException("指定的Book 不存在");
      }
        return book;
    }

//    public List<Book> findAll() {
//        return bookRepository.findAll();
//    }
//    
//    public Page<Book> findAllByPage(Pageable pageable){
//        return bookRepository.findAll(pageable);
//    }
//    
//    public Book save(Book book) {
//        return bookRepository.save(book);
//    }
//
//    public Book findOne(Long id) {
//        Book one = bookRepository.getOne(id);
//        return one;
//    }
//
//    public void deleteOne(long id) {
//        bookRepository.delete(id);
//    }
//    
//    public List<Book> findByAuthor(String author) {
//        return bookRepository.findByAuthor(author);
//    }
//
//    public List<Book> findByAuthorAndStatus(String author, int status) {
//        return bookRepository.findByAuthorAndStatus(author, status);
//    }
//
//    public List<Book> findByDescriptionEndsWith(String desc) {
//        return bookRepository.findByDescriptionEndsWith(desc);
//    }
//
//    public List<Book> findByDescriptionContains(String desc) {
//        return bookRepository.findByDescriptionContains(desc);
//    }
//    
//    public List<Book> findByJPQL(int len){
//        return bookRepository.findByJPQL(len);
//    }
//
//    public List<Book> findBySQL(int len){
//        return bookRepository.findBySQL(len);
//    }
//    
//    @Transactional
//    public int updateByJPQL(int status, long id) {
//        return bookRepository.updateByJPQL(status, id);
//    }
//
//    @Transactional
//    public int deleteByJPQL(long id) {
//        return bookRepository.deleteByJPQL(id);
//    }
//    
//    @Transactional
//    public int deleteAndUpdate(long id, int status, long uid) {
//        int dcount = bookRepository.deleteByJPQL(id);
//        
//        int ucount = bookRepository.updateByJPQL(status, uid);
//        
//        return dcount + ucount;
//    }

}
