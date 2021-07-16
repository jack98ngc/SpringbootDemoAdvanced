/*
 * created on May 23, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 23, 2021 $
 */
package com.example.demo.service;

import com.example.demo.domain.Book;

public interface BookService {

    Book getBookById(long id);
}
