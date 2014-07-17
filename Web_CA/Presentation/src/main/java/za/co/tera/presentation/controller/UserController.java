package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import za.co.tera.web_ca.business.User.base.UserService;
import za.co.tera.web_ca.business.User.impl.UserServiceImpl;
import za.co.tera.web_ca.domain.impl.User;

import java.util.List;

@Controller
public class UserController {
    UserService userService = new UserServiceImpl();
    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAllUsers( ModelMap model ) {

        return userService.findAllUsers();
    }
    @RequestMapping(value = "/UserSet", method = RequestMethod.POST)
    public @ResponseBody
    String createUser(@RequestBody User user) {
        if (userService.createUser(user))
            return "User: " + user.getUserFirstName() + " successfully registered.";
        else
            return user.getUserEmail() + " already registered.";
    }

    @RequestMapping(value = "/UserLogin", method = RequestMethod.POST)
    public @ResponseBody
    User loginUser(@RequestBody User user)
    {
        return userService.loginUser(user);
    }

    @RequestMapping(value = "/getUserById/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    User getUserById( @PathVariable(value = "userId") int userId) {

        return userService.findUserById(userId);
    }
}
