package com.controller;

import com.editor.CategoryEditor;
import com.model.Category;
import com.model.Skill;
import com.model.User;
import com.service.CategoryService;
import com.service.SkillService;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryEditor categoryEditor;

    private static String titelNieuw = "Nieuwe skill";
    private static String titelWijzig = "Wijzigen skill";

   @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class, this.categoryEditor);
    }
    
    @RequestMapping(value = "/list")
    public ModelAndView skillList() throws IOException {
        ModelAndView skillListView = new ModelAndView("skill/skillList");
        skillListView.addObject("skillList", skillService.getSkills());

        return skillListView;
    }
    
        @RequestMapping(value = "/listProfile")
    public ModelAndView skillListProfile() throws IOException {
        ModelAndView skillListView = new ModelAndView("skill/skillListProfile");
        skillListView.addObject("skillList", skillService.getSkills());

        return skillListView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView skillAddPage() throws IOException {

        ModelAndView skillAddView = new ModelAndView("skill/addSkill");
        skillAddView.addObject("paginaTitel", titelNieuw);
        skillAddView.addObject("skill", new Skill());
        skillAddView.addObject("categoryList", categoryService.getCategories());
        return skillAddView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView skillAdd(@ModelAttribute Skill skill)  {

        ModelAndView skillListView = new ModelAndView("skill/skillList");
        skillService.addSkill(skill);
        skillListView.addObject("skillList", skillService.getSkills());
        String message = "Skill was successfully added.";
        skillListView.addObject("message", message);

        return skillListView;

    }

   @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editSkillPage(@PathVariable int id) {
		ModelAndView skillEditView = new ModelAndView("skill/editSkill");
		skillEditView.addObject("paginaTitel", titelWijzig);
		skillEditView.addObject("skill",skillService.getSkill(id));
                skillEditView.addObject("categoryList", categoryService.getCategories());
		return skillEditView;
	}
        
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView skillEdit(@ModelAttribute("skill") Skill skill)  {

        ModelAndView skillListView = new ModelAndView("skill/skillList");
        skillService.updateSkill(skill);

        skillListView.addObject("skillList", skillService.getSkills());

        String message = "Skill was successfully edited.";
        skillListView.addObject("message", message);

        return skillListView;

    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public ModelAndView removeSkill(@PathVariable int id) {
         ModelAndView skillListView = new ModelAndView("skill/skillList");
        skillService.deleteSkill(id);
        skillListView.addObject("skillList", skillService.getSkills());
        
        String message = "Skill was successfully deleted.";
        skillListView.addObject("message", message);
        return skillListView;
    }
    
    
    @RequestMapping(value = "/skillList/visibility/{id}", method = RequestMethod.GET)
    public ModelAndView deactivateSkill(@PathVariable int id, HttpSession session){
        User loggedInUser = (User)session.getAttribute("loggedInUser");
        if(loggedInUser != null) {
            //Checks if user is admin
            if(loggedInUser.getRole() != 33){
                ModelAndView skillListView = new ModelAndView("skill/skillList");
                
                skillService.updateSkill(skillService.getSkill(id));
                
                skillListView.addObject("skillList", skillService.getSkills());
                skillListView.addObject("skillListSize", skillService.getSkills().size());

                return skillListView;
            }else{
                ModelAndView homeView = new ModelAndView("index/index");
                User activeUser = (User)session.getAttribute("loggedInUser");

                homeView.addObject("loggedInUser", activeUser);
                return homeView;
            }
        }else{
            ModelAndView loginView = new ModelAndView("/login/login");

                loginView.addObject("user", new User());

                return loginView; 
        }
    }
}
