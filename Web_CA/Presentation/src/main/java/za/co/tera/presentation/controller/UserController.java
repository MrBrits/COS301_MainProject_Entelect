package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import za.co.tera.web_ca.business.User.base.UserService;
import za.co.tera.web_ca.business.User.impl.UserServiceImpl;
import za.co.tera.web_ca.domain.impl.User;

@Controller
public class UserController {
    UserService userService = new UserServiceImpl();
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public @ResponseBody
    String getAllUsers( ModelMap model ) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString;
        try {
            jsonString = mapper.writeValueAsString(userService.findAllUsers());

        } catch (Exception e) {
            jsonString = "";
            System.out.println("Cannot be done");
        }
        return jsonString;
    }
    @RequestMapping(value = "/UserSet", method = RequestMethod.POST)
    public @ResponseBody
    void createUser(@RequestBody User user) {
        System.out.println("reached");
        userService.createUser(user);
    }
}
