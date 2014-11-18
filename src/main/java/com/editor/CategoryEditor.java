/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.editor;

import com.model.Category;
import com.service.CategoryService;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryEditor extends PropertyEditorSupport {

    @Autowired
    private CategoryService categoryService;

    // Converts a String team id to a Team (when submitting form)
    @Override
    public void setAsText(String text) {
       Category category = this.categoryService.getCategory(Integer.valueOf(text));

        this.setValue(category);
    }

}

