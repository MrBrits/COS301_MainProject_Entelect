package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = "/" )
    public String test()    {
        return "hello";
    }
}