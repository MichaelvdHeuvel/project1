/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.LoginDAO;
import com.model.User;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author David
 */
@Service
@Transactional
public class LoginService {
    @Autowired
    LoginDAO loginDAO;
    
    public boolean isLogginCorrect(String emailAddress, String password){
        return loginDAO.isLogginCorrect(emailAddress, password);
    }
    
    public User getLoggedInUser(String emailAddress){
        return loginDAO.getLoggedInUser(emailAddress);
    }
}
