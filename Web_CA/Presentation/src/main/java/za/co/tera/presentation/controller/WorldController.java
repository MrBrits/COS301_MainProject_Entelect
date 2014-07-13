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
import za.co.tera.Business.World.WorldEntityManager;

@Controller
public class WorldController {

    @RequestMapping(value = "/getAllWorlds", method = RequestMethod.GET)
    public @ResponseBody
    String getAllWorlds( ModelMap model ) {

        WorldEntityManager worldEntityManager = new WorldEntityManager();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString;
        try {
            jsonString = mapper.writeValueAsString(worldEntityManager.findAllWorlds());

        } catch (Exception e) {
            jsonString = "";
            System.out.println("Cannot be done");
        }
        return jsonString;
    }


}