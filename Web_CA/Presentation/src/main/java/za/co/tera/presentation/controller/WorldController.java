package za.co.tera.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.business.World.impl.WorldServiceImpl;
import za.co.tera.web_ca.domain.impl.Coordinate;
import za.co.tera.web_ca.domain.impl.World;

import java.io.IOException;
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

    @RequestMapping(value = "/getWorldNotByUserId", method = RequestMethod.POST)
    public @ResponseBody
    List<World> getWorldNotByUserId(@RequestBody int userId) {
        return worldService.findWorldNotByUserId(userId);
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
        int id = worldService.createWorld(world);
        if (id != 0)
            return "World Added";
        else
            return "No new World has been added";
    }
    @RequestMapping(value = "/importWorld", method = RequestMethod.POST)
    public @ResponseBody
    void importWorld(@RequestBody String Ownerworld) throws IOException {
        String [] objects = Ownerworld.split(";");

        worldService.ImportWorld(Integer.parseInt(objects[0]),Integer.parseInt(objects[1]));
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

    @RequestMapping(value = "/saveCoordinates", method = RequestMethod.POST)
    public @ResponseBody
    String saveCoordinates(@RequestBody List<Coordinate> coordinates) {

       // System.out.println(coordinates.get(0).getWorldId());
       //
        worldService.updateCoordinates(coordinates);
        return String.valueOf("Success");
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