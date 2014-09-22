package za.co.tera.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.business.World.impl.WorldServiceImpl;
import za.co.tera.web_ca.domain.impl.Coordinate;
import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

@Controller
public class WorldController {

    WorldService worldService = new WorldServiceImpl();

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAllWorlds", method = RequestMethod.POST)
    public @ResponseBody
    List<World> getAllWorlds(@RequestBody ModelMap model ) {
        return worldService.findAllWorlds();
    }

    /**
     *
     * @param world
     */
    @RequestMapping(value = "/postWorld", method = RequestMethod.POST)
    public @ResponseBody void postState(@RequestBody World world) {
        worldService.createWorld(world);
    }

    /**
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getWorldByUserId", method = RequestMethod.POST)
    public @ResponseBody
    List<World> getUserById(@RequestBody int userId) {
        return worldService.findWorldByUserId(userId);
    }

    /**
     *
     * @param worldId
     * @return
     */
    @RequestMapping(value = "/deleteWorld", method = RequestMethod.POST)
    public @ResponseBody
    String deleteWorld(@RequestBody int worldId) {
        worldService.deleteWorld(worldService.findWorld(worldId));
        return "World deleted";
    }

    /**
     *
     * @param world
     * @return
     */
    @RequestMapping(value = "/AddWorld", method = RequestMethod.POST)
    public @ResponseBody
    String createState(@RequestBody World world) {
        System.out.println("WORLD CONTROLLER");
        int id = worldService.createWorld(world);
        if (id != 0)
            return "World Added";
        else
            return "No new World has been added";
    }

    /**
     *
     * @param worldId
     * @return
     */
    @RequestMapping(value = "/getCoordinatesByWorldId", method = RequestMethod.POST)
    public @ResponseBody
    List<Coordinate> getCoordinatesByWorldId(@RequestBody int worldId) {
        return worldService.findCoordinateByWorldId(worldId);
    }
    @RequestMapping(value = "/getByWorldId/{worldId}", method = RequestMethod.GET)
    public @ResponseBody
    World getByWorldId( @PathVariable(value = "worldId") int worldId) {
        return worldService.findWorld(worldId);
    }

    @RequestMapping(value = "/getWorldById", method = RequestMethod.POST)
    public @ResponseBody
    World getWorldById( @RequestBody int worldId) {
        return worldService.findWorld(worldId);
    }

    @RequestMapping(value = "/editWorld", method = RequestMethod.POST)
    public @ResponseBody
    String editWorld(@RequestBody World world) {
        worldService.updateWorld(world);
        return "World has been edited";
    }

}