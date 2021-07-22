/*
 * created on May 26, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 26, 2021 $
 */
package com.example.demo.web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.form.UserForm;

@Controller
public class LoginController {
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        //空白頁需初始化一個新的物件
        model.addAttribute("userForm", new UserForm());
        return "register";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @PostMapping("/login")
    public String loginPost(@RequestParam String username, 
            @RequestParam String password, 
            HttpSession session) {
        
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user !=null) {
            session.setAttribute("user", user);
            return "index";
        }
        return "login";
        
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }
    
    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult validResult) {
        if(!userForm.confirmPassword()) {
            validResult.rejectValue("confirmPassword", "confirmError", "confirm password inconsistently");
        }
        
        if(validResult.hasErrors()) {
            return "register";
        }
        
        User user = userForm.converToUser();
        userRepository.save(user);
        return "redirect:/login";
    }
    
    @GetMapping("/exception")
    public String testException() {
        throw new RuntimeException("測試異常");
    }
}
