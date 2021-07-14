/*
 * created on Jul 14, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 14, 2021 $
 */
package com.example.demo.form;

public interface FormConvert<S, T>{
    T convert(S s);
}
