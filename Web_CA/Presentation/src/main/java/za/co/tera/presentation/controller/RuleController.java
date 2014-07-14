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

@Controller
public class RuleController {

    @RequestMapping(value = "/getAllRules", method = RequestMethod.GET)
    public @ResponseBody
    String getAllRules( ModelMap model ) {

        RuleEntityManager ruleEntityManager = new RuleEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString;
        try {
            jsonString = mapper.writeValueAsString(ruleEntityManager.findAllRules());

        } catch (Exception e) {
            jsonString = "";
            System.out.println("Cannot be done");
        }
        return jsonString;
    }
    @RequestMapping(value = "/createRule", method = RequestMethod.POST)
    public @ResponseBody
    void createRule(@RequestBody String user) {

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