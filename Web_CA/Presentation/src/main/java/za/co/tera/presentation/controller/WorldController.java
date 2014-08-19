package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.business.World.impl.WorldServiceImpl;
import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

@Controller
public class WorldController {

    WorldService worldService =new WorldServiceImpl();

    @RequestMapping(value = "/getAllWorlds", method = RequestMethod.GET)
    public @ResponseBody
    List<World> getAllWorlds( ModelMap model ) {
        return worldService.findAllWorlds();
    }

    @RequestMapping(value = "/postWorld", method = RequestMethod.POST)
    public @ResponseBody void postState(@RequestBody World world) {
        worldService.createWorld(world);
    }

    @RequestMapping(value = "/getWorldByUserId/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    List<World> getUserById( @PathVariable(value = "userId") int userId) {
        return worldService.findWorldByUserId(userId);
    }
    @RequestMapping(value = "/deleteWorld/{worlId}", method = RequestMethod.GET)
    public @ResponseBody
    String deleteWorld( @PathVariable(value = "worlId") int worlId) {
        worldService.deleteWorld(worldService.findWorld(worlId));
        return "done";
    }

    @RequestMapping(value = "/AddWorld", method = RequestMethod.POST)
    public @ResponseBody
    String createState(@RequestBody World world) {
        worldService.createWorld(world);
        return "World Added";
    }
}