package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import za.co.tera.Business.User.UserEntityManager;
import za.co.tera.Domain.impl.User;

@Controller
public class IndexController {

        @RequestMapping(value = "/index", method = RequestMethod.GET)
        public ModelAndView httpServiceGetExample( ModelMap model ) {

            return  new ModelAndView("test");
        }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView gfhdghdg( ModelMap model ) {

        return  new ModelAndView("index2");
    }

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
        @RequestMapping(value = "/getAll", method = RequestMethod.POST)
        public @ResponseBody
        void getlProfiles(@RequestBody String user) {


            //return serializer.serialize( p );
            try {
                ObjectMapper mapper = new ObjectMapper();
                User user1 = mapper.readValue(user, User.class);
                UserEntityManager userEntityManager = new UserEntityManager();
                userEntityManager.createUser(user1);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }

        }

}
