package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import za.co.tera.Business.User.UserEntityManager;

@Controller
public class IndexController {
       /* @RequestMapping(method = RequestMethod.GET)
        public String printWelcome(ModelMap model) {

            return "test";
        }*/


        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView httpServiceGetExample( ModelMap model ) {

            return  new ModelAndView("index");
        }
        @RequestMapping(value = "/op",  method = RequestMethod.POST)
        public String methodWithRequestParams(@RequestParam("userFirstName") String firstname,@RequestParam("userLastName") String userLastName,@RequestParam("userEmail") String userEmail,@RequestParam("userPassword") String userPassword)
        {
            return " ";
        }

        // do something with params

        @RequestMapping(value = "/getAllProfiles", method = RequestMethod.GET)
        public @ResponseBody
        String getAllProfiles( ModelMap model ) {
            UserEntityManager userEntityManagers = new UserEntityManager();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString;
            try {
                jsonString = mapper.writeValueAsString(userEntityManagers.findAllUsers());

            } catch (Exception e) {
                jsonString = "fail";
            }
            return jsonString;
        }
    @RequestMapping(value = "/getAllProfiles", method = RequestMethod.POST)
    public @ResponseBody
    String getlProfiles( ) {

        return "hello";
       //return user.getUserLastName();
    }

}
