package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    /**
     * Returns the main page
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
     public ModelAndView getIndex(ModelMap model) {

        return new ModelAndView("main");
    }

   /* @RequestMapping(value = "/index/{userId}", method = RequestMethod.GET)
    public @ResponseBody ModelAndView  getIndex2(@PathVariable(value = "ID") int ID) {


        ModelAndView model = new ModelAndView("index");
        model.setViewName("index");
        return model;

    }*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex2(ModelMap model) {

        return new ModelAndView("index");
    }
}