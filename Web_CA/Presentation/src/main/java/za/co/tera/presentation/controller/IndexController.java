package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

            return  new ModelAndView("test");
        }
        @RequestMapping(value = "/getAllProfiles", method = RequestMethod.GET)
        public @ResponseBody
        String getAllProfiles( ModelMap model ) {
            UserEntityManager userEntityManagers = new UserEntityManager();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString;
            try {
                jsonString = mapper.writeValueAsString(userEntityManagers);

            } catch (Exception e) {
                jsonString = "fail";
            }
            return jsonString.substring(8,jsonString.length()-1);
         // String jsonData = "[{\"firstname\":\"ajitesh\"},{\"firstname\":\"nidhi\"}]";
           //   String jsonData ="[{\"userid\":\"1\",\"userfirstname\":\"rai\",\"userlastname\":\"201,mgstreet\",\"useremail\":\"hyderabad\",\"userpassword\":\"999-876-5432\"},{\"userid\":\"1\",\"userfirstname\":\"rai\",\"userlastname\":\"201,mgstreet\",\"userEmail\":\"hyderabad\",\"userPassword\":\"999-876-5432\"}]";
           // return jsonData;
            //return jsonData;
        }
        /*
        public String getUser(ModelMap model) {
        {
            User user= new User("Name","Surname","email","123","admin");
            JSONPObject jsonpObject = new JSONPObject("",user);
            jsonpObject.getSerializationType();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString;
            try {
                jsonString = mapper.writeValueAsString(user);

            } catch (Exception e) {
                jsonString = "fail";
            }

            return jsonString;


        }

        }*/
}
