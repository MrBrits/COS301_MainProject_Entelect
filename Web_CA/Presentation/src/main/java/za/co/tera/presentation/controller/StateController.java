package za.co.tera.presentation.controller;

/**
 * Created by Laptop on 7/4/2014.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import za.co.tera.web_ca.business.State.base.StateService;
import za.co.tera.web_ca.business.State.impl.StateServiceImpl;
import za.co.tera.web_ca.domain.impl.State;

import java.util.List;

@Controller
public class StateController {
    StateService stateService=new StateServiceImpl();

    @RequestMapping(value = "/getAllStates", method = RequestMethod.GET)
    public @ResponseBody
    List<State> getAllStates( ModelMap model ) {
        return stateService.findAllStates();
    }

    @RequestMapping(value = "/postState", method = RequestMethod.POST)
    public @ResponseBody void postState(@RequestBody State state) {
        stateService.createState(state);
    }


    @RequestMapping(value = "/getStateByUserId/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    List<State> getUserById( @PathVariable(value = "userId") int userId) {
        return stateService.findStateByUserId(userId);
    }

    @RequestMapping(value = "/AddState", method = RequestMethod.POST)
    public @ResponseBody
    String createState(@RequestBody State state) {
        stateService.createState(state);
        return "State Added";
    }
    @RequestMapping(value = "/stateState/{stateId}", method = RequestMethod.GET)
    public @ResponseBody
    String deleteState( @PathVariable(value = "stateId") int stateId) {
        stateService.deleteState(stateService.findState(stateId));
        return "done";
    }
}


