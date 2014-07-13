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
import za.co.tera.Business.State.StateEntityManager;
import za.co.tera.Business.User.UserEntityManager;
import za.co.tera.Domain.impl.User;

@Controller
public class StateController {

    @RequestMapping(value = "/getAllStates", method = RequestMethod.GET)
    public @ResponseBody
    String getAllStates( ModelMap model ) {

        StateEntityManager stateEntityManager = new StateEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString;
        try {
            jsonString = mapper.writeValueAsString(stateEntityManager.findAllStates());

        } catch (Exception e) {
            jsonString = "";
            System.out.println("Cannot be done");
        }
        return jsonString;
    }
    @RequestMapping(value = "/createState", method = RequestMethod.POST)
    public @ResponseBody
    void createUser(@RequestBody String user) {

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
