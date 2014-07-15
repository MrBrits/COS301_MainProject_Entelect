package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

}