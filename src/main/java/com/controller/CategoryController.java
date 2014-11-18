package com.controller;

import com.model.Category;
import com.service.CategoryService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private static String titelNieuw = "New category";
    private static String titelWijzig = "Edit category";
    private static String titelVerwijder = "Remove category";

    @RequestMapping(value = "/list")
    public ModelAndView categoryList() throws IOException {
        ModelAndView categoryListView = new ModelAndView("category/categoryList");
        categoryListView.addObject("categoryList", categoryService.getCategories());
        return categoryListView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView categoryAddPage() throws IOException {

        ModelAndView categoryAddView = new ModelAndView("category/categoryAdd");
        categoryAddView.addObject("paginaTitel", titelNieuw);
        categoryAddView.addObject("category", new Category());
        return categoryAddView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView categoryAdd(@ModelAttribute Category category) throws IOException {

        ModelAndView categoryListView = new ModelAndView("category/categoryList");
        categoryService.addCategory(category);

        categoryListView.addObject("categoryList", categoryService.getCategories());

        String message = "Category was successfully added.";
        categoryListView.addObject("message", message);

        return categoryListView;

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCategoryPage(@PathVariable int id) {
        ModelAndView categoryEditView = new ModelAndView("category/categoryEdit");
        categoryEditView.addObject("paginaTitel", titelWijzig);
        categoryEditView.addObject("category", categoryService.getCategory(id));
        return categoryEditView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView categoryEdit(@ModelAttribute("category") Category category) {

        ModelAndView categoryListView = new ModelAndView("category/categoryList");
        categoryService.updateCategory(category);

        categoryListView.addObject("categoryList", categoryService.getCategories());

        String message = "Categorie is scuccesvol aangepast.";
        categoryListView.addObject("message", message);

        return categoryListView;

    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public ModelAndView removeCategory(@PathVariable int id) {
        ModelAndView categoryListView = new ModelAndView("category/categoryList");
        try {
            categoryService.deleteCategory(id);
            categoryListView.addObject("categoryList", categoryService.getCategories());

            String message = "Categorie is scuccesvol verwijderd.";
            categoryListView.addObject("message", message);
                    return categoryListView;
        } catch (Exception e) {
            categoryListView.addObject("categoryList", categoryService.getCategories());
            String message = "Deze categorie heeft skills onder zich en kan niet worden verwijderd. Verwijder eerst de skills .";
            categoryListView.addObject("message", message);
                    return categoryListView;
        }


    }

}
