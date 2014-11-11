/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

//import com.model.Member;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Project;
import com.model.User;
import javax.servlet.http.HttpSession;

@Repository
public class ProjectDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addProject(Project project, HttpSession session) {
        
        User user = (User)session.getAttribute("loggedInUser");
        
        project.setAssignedManager(user);
        getCurrentSession().save(project);
    }

    public void updateProject(Project project) {
        Project projectToUpdate = getProject(project.getProjectId());
        projectToUpdate.setProjectName(project.getProjectName());
        projectToUpdate.setEndDate(project.getEndDate());
//        projectToUpdate.setAssignedManager(project.getAssignedManager());
        
        
        getCurrentSession().update(projectToUpdate);

    }


    public Project getProject(int id) {
        Project project = (Project) getCurrentSession().get(Project.class, id);
        return project;
    }

    public void deleteProject(int id) {
        Project project = getProject(id);
        if (project != null) {
            getCurrentSession().delete(project);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Project> getProjects() {
        return getCurrentSession().createQuery("from Project").list();
    }

    public void storeAllProjects(List<Project> projects) {

        for (Project project : projects) {
            getCurrentSession().save(project);
        }

    }
}
