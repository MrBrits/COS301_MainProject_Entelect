package za.co.tera.presentation.controller;

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

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/getAllStates", method = RequestMethod.GET)
    public @ResponseBody
    List<State> getAllStates( ModelMap model ) {
        return stateService.findAllStates();
    }

    /**
     *
     * @param state
     */
    @RequestMapping(value = "/postState", method = RequestMethod.POST)
    public @ResponseBody void postState(@RequestBody State state) {
        stateService.createState(state);
    }

    /**
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getStateByUserId/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    List<State> getUserById( @PathVariable(value = "userId") int userId) {
        return stateService.findStateByUserId(userId);
    }

    /**
     *
     * @param state
     * @return
     */
    @RequestMapping(value = "/AddState", method = RequestMethod.POST)
    public @ResponseBody
    String createState(@RequestBody State state) {
        stateService.createState(state);
        return "State Added";
    }

    /**
     *
     * @param stateId
     * @return
     */
    @RequestMapping(value = "/deleteState/{stateId}", method = RequestMethod.GET)
    public @ResponseBody
    String deleteState( @PathVariable(value = "stateId") int stateId) {
        stateService.deleteState(stateService.findState(stateId));
        return "State has been deleted";
    }

    /**
     *
     * @param stateId
     * @return
     */
    @RequestMapping(value = "/getStateById/{stateId}", method = RequestMethod.GET)
    public @ResponseBody
    State getStateById( @PathVariable(value = "stateId") int stateId) {
        return stateService.findState(stateId);
    }
}


