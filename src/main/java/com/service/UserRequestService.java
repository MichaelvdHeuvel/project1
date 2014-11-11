/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.UserRequestDAO;
import com.model.UserRequest;
import java.util.List;
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
public class UserRequestService {
    @Autowired
    private UserRequestDAO userRequestDAO;

    public void addUserRequest(UserRequest request, HttpSession session) {
        userRequestDAO.addUserRequest(request, session);
    }

    public UserRequest getUserRequest(int id) {
        return userRequestDAO.getUserRequest(id);
    }

    public void deleteUserRequest(int id) {
        userRequestDAO.deleteUserRequest(id);
    }

    public List<UserRequest> getUserRequests() {
        return userRequestDAO.getUserRequests();
    }
    
//    public void storeAllUsers(List<User> users) {
//        userRequestDAO.storeAllUsers(users);
//    }
}
