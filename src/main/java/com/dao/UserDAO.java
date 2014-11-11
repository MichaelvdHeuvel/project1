package com.dao;

import com.lib.BCrypt;
import com.model.User;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addUser(User user) {
        Date date = new Date();
        Timestamp currentDate = new Timestamp(date.getTime());
        
        //gets string from submitted user and hashes this while replacing the unhashed password
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        
        user.setCreatedAt(currentDate);
        getCurrentSession().save(user);
    }

    public void updateUserPassword(User user) {
        User userToUpdate = getUser(user.getId());
        
        //genereren van een hash voor passwordhashing
        String  originalPassword = user.getPassword();
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        
        userToUpdate.setPassword(generatedSecuredPasswordHash);
    }
    
    public void updateUserPicture(User user, String fileName) {
        User userToUpdate = getUser(user.getId());
        
        userToUpdate.setProfileImage(fileName);
        
        Date date = new Date();
        Timestamp currentDate = new Timestamp(date.getTime());
        
        userToUpdate.setLastModifiedAt(currentDate);
        
        getCurrentSession().update(userToUpdate);
    }
    
    public void updateUserActive(User user){
        User userToUpdate = getUser(user.getId());
        
        if(user.getActive() == 1){
            userToUpdate.setActive(0);
        }else{
            userToUpdate.setActive(1);
        }
        
        Date date = new Date();
        Timestamp currentDate = new Timestamp(date.getTime());
        
        userToUpdate.setLastModifiedAt(currentDate);
        
        getCurrentSession().update(userToUpdate);
    }
    
    public void updateUser(User user) {
        User userToUpdate = getUser(user.getId());
        
        userToUpdate.setRole(user.getRole());
        
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        
        userToUpdate.setEmailAddress(user.getEmailAddress());
        userToUpdate.setPhoneNumber(user.getPhoneNumber());
        
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setAddressNumber(user.getAddressNumber());
        userToUpdate.setCity(user.getCity());
        userToUpdate.setZipcode(user.getZipcode());
        
        Date date = new Date();
        Timestamp currentDate = new Timestamp(date.getTime());
        
        userToUpdate.setLastModifiedAt(currentDate);
        
        getCurrentSession().update(userToUpdate);
    }

    public User getUser(int id) {
        User user = (User) getCurrentSession().get(User.class, id);
        return user;
    }

    public void deleteUser(int id) {
        User user = getUser(id);
        if (user != null) {
            getCurrentSession().delete(user);
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return getCurrentSession().createQuery("from User").list();
    }
    
    @SuppressWarnings("unchecked")
        public List<User> searchUsers(String name)
        {
            return getCurrentSession().createQuery("from User where active=1 and firstName like :search")
                    .setParameter("search", "%" + name + "%")
                    .list();
        }
    
    public  void storeAllUsers(List<User> users) {
             
        for (User user : users) {
            getCurrentSession().save(user);
        }
       
    }
}
