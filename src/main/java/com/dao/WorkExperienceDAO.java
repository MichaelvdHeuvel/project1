package com.dao;

import com.model.User;
import com.model.WorkExperience;
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
public class WorkExperienceDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void addWorkExperience(WorkExperience exp){
        getCurrentSession().save(exp);
    }
    
    public WorkExperience getWorkExperience(int id){
        WorkExperience experience = (WorkExperience) getCurrentSession()
                .get(WorkExperience.class, id);
        
        return experience;
    }
    
    public void updateWorkExperience(WorkExperience exp){
        WorkExperience expToUpdate = getWorkExperience(exp.getId());
        
        expToUpdate.setCompany(exp.getCompany());
        expToUpdate.setDescription(exp.getDescription());
        expToUpdate.setFunction(exp.getFunction());
        expToUpdate.setStartDate(exp.getStartDate());
        expToUpdate.setEndDate(exp.getEndDate());
        
        getCurrentSession().update(expToUpdate);
    }
    
    public void setActive(WorkExperience exp){
        WorkExperience expToUpdate = getWorkExperience(exp.getId());
        
        expToUpdate.setActive(exp.getActive());
        
        getCurrentSession().update(expToUpdate);
    }
    
    @SuppressWarnings("unchecked")
    public List<WorkExperience> getWorkExperience(HttpSession session) {
        User user = (User)session.getAttribute("loggedInUser");
        
        return getCurrentSession().createQuery("from WorkExperience we join we.user user where user.emailAddress=?")
                .setParameter(0, user.getEmailAddress())
                .list();
    }
}
