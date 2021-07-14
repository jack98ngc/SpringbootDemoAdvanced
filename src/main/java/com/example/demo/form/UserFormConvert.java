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

public class UserFormConvert implements FormConvert<UserForm, User>{

    @Override
    public User convert(UserForm s) {
        User user = new User();
        BeanUtils.copyProperties(s, user);
        return user;
    }
}
