/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.User;
import com.model.UserRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public class UserRequestDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addUserRequest(UserRequest request, HttpSession session) {
        Date date = new Date();
        Timestamp currentDate = new Timestamp(date.getTime());
        
        request.setRequestDate(currentDate);
        
        request.setRequester((User)session.getAttribute("loggedInUser"));
        request.setRequest(request.getRequest());
        
        getCurrentSession().save(request);
    }

    public UserRequest getUserRequest(int id) {
        UserRequest request = (UserRequest) getCurrentSession().get(UserRequest.class, id);
        return request;
    }

    public void deleteUserRequest(int id) {
        UserRequest request = getUserRequest(id);
        if (request != null) {
            getCurrentSession().delete(request);
        }
    }

    @SuppressWarnings("unchecked")
    public List<UserRequest> getUserRequests() {
        return getCurrentSession().createQuery("from UserRequest order by id desc").list();
    }
    
//    public  void storeAllUserRequests(List<UserRequest> requests) {
//             
//        for (UserRequest request : requests) {
//            getCurrentSession().save(request);
//        }
//       
//    }
}
