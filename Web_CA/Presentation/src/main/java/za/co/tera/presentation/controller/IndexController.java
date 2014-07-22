package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import za.co.tera.web_ca.business.User.base.UserService;
import za.co.tera.web_ca.business.User.impl.UserServiceImpl;
import za.co.tera.web_ca.domain.impl.User;

@Controller
public class IndexController {

    /**
     * Returns the main page
     */
    UserService userService = new UserServiceImpl();
    @RequestMapping(value = "/", method = RequestMethod.GET)
     public ModelAndView getLoginPage(ModelMap model) {

        return new ModelAndView("login");
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getMainPage(ModelMap model, @PathVariable(value = "userId") int userId) {

        User user=userService.findUserById(userId);
        String userFullName = user.getUserFirstName()+" "+user.getUserLastName();
        model.addAttribute("userFullName", userFullName);
        model.addAttribute("userId", userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(model);
        modelAndView.setViewName("index");
        return modelAndView;

    }
}