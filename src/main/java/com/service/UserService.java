/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.UserDAO;
import com.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author David
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void addUser(User user) {
        userDAO.addUser(user);
    }
    
    public void udpateUserPassword(User user) {
        userDAO.updateUserPassword(user);
    }
    
    public void updateUserActive(User user) {
        userDAO.updateUserActive(user);
    }
    
    public void updateUserPicture(User user, String fileName) {
        userDAO.updateUserPicture(user, fileName);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }
    
    public List<User> searchUsers(String name){
        return userDAO.searchUsers(name);
    }
    
    public void storeAllUsers(List<User> users) {
        userDAO.storeAllUsers(users);
    }
}
