package com.dao;

import com.lib.BCrypt;
import com.model.User;
import java.util.ArrayList;
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
public class LoginDAO {
    @Autowired
    private SessionFactory sessionFactory;
    private HttpSession session;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public boolean isLogginCorrect(String emailAddress, String password) {
        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession().createQuery("from User where emailAddress=?")
                .setParameter(0, emailAddress)
                .list();

        if (users.size() > 0) {
            
            if(BCrypt.checkpw(password, users.get(0).getPassword()) && users.get(0).getActive() != 0)
                return true;
        } else {
            return false;
        }
        
        return false;
    }
    
    public User getLoggedInUser(String emailAddress) {
        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession().createQuery("from User where emailAddress=?")
            .setParameter(0, emailAddress)
            .list();
            
        if (users.size() > 0) {
            return users.get(0);
        }else{
            return null;
        }
    }
}
