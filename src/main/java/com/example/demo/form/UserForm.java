/*
 * created on Jul 14, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 14, 2021 $
 */
package com.example.demo.form;

import org.springframework.beans.BeanUtils;

import com.example.demo.domain.User;

public class UserForm {

    private String username;
    private String password;
    private int phone;
    private String email;
    private String confirmPassword;

    public UserForm() {
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public User converToUser() {
        return new UserFormConvert().convert(UserForm.this);
    }
    
    
}
