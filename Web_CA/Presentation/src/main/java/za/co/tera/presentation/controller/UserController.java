package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hi")
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC Hello LAM");
                return "hello";
    }
}