/*
 * created on Jul 14, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 14, 2021 $
 */
package com.example.demo.form;

import java.util.Objects;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.example.demo.domain.User;

public class UserForm {

    private static final String PHONE_REG = "^09[0-9]{8}$";
//    private static final String PHONE_REG = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
    @NotBlank
    private String username;
    @Length(min = 6, message = "長度不足6碼")
    private String password;
    @Pattern(regexp= PHONE_REG, message="格式不符")
    private String phone;
    @Email
    private String email;
    @NotBlank
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
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
    
    public boolean confirmPassword() {
        return Objects.equals(password, confirmPassword);
    }
    
    
}
