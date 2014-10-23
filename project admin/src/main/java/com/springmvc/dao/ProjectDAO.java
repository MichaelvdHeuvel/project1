package com.springmvc.dao;

import com.springmvc.model.Project;
import com.springmvc.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProjectDAO {
     @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

  

    public void addProject(Project project) {
      getCurrentSession().save(project);
    }

    public void updateProject(Project project) {
        Project projectToUpdate = getProject(project.getProjectID());
        projectToUpdate.setProjectName(project.getProjectName());
        
        
        
        getCurrentSession().update(projectToUpdate);

    }
    

    public Project getProject(int id) {
         Project project = (Project) getCurrentSession().get(Project.class, id);
        return project;
                
                
    }
    @SuppressWarnings("unchecked")
    public List<Project> getProjects() {
        return getCurrentSession().createQuery("from project").list();
    }
    
    public void storeAllProjects(List<Project> project) {
        for (Project Projects : project) {
            getCurrentSession().save(project);
    }
        
        
        
        
}
     public User getUser(int id) {
        User user = (User) getCurrentSession().get(User.class, id);
        return user;
    }
     
     @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        return getCurrentSession().createQuery("from User").list();
    }
}