/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.model.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addCategory(Category category) {
        getCurrentSession().save(category);
    }

    public void updateCategory(Category category) {
        Category categoryToUpdate = getCategory(category.getCategoryId());
        categoryToUpdate.setName(category.getName());
                
        getCurrentSession().update(categoryToUpdate);

    }

    public Category getCategory(int id) {
        Category category = (Category) getCurrentSession().get(Category.class, id);
        return category;
    }

    public void deleteCategory(int id) {
        Category category = getCategory(id);
        if (category != null) {
            getCurrentSession().delete(category);
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Category> getCategories() {
        return getCurrentSession().createQuery("from Category").list();
    }

    public  void storeAllCategories(List<Category> categories) {
             
        for (Category category : categories) {
            getCurrentSession().save(category);
        }
    }
}
