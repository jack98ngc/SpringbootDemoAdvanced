/*
 * created on May 26, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 26, 2021 $
 */
package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsernameAndPassword(String username, String password);
}
