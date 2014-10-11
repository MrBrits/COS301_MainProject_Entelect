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
    @RequestMapping(value = "/getAllStates", method = RequestMethod.POST)
    public @ResponseBody
    List<State> getAllStates(@RequestBody ModelMap model ) {
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
    @RequestMapping(value = "/getStateByUserId", method = RequestMethod.POST)
    public @ResponseBody
    List<State> getUserById(@RequestBody int userId) {
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

        if (stateService.createState(state)) {
            return "State Added";
        }
        else{
            return "A State with that value already exists";
        }
    }

    /**
     *
     * @param stateId
     * @return
     */
    @RequestMapping(value = "/deleteState", method = RequestMethod.POST)
    public @ResponseBody
    String deleteState(@RequestBody int stateId) {
        stateService.deleteState(stateService.findState(stateId));
        return "State has been deleted";
    }

    /**
     *
     * @param stateId
     * @return
     */
    @RequestMapping(value = "/getStateById", method = RequestMethod.POST)
    public @ResponseBody
    State getStateById(@RequestBody int stateId) {
        return stateService.findState(stateId);
    }

    /**
     *
     * @param state
     * @return
     */
    @RequestMapping(value = "/editState", method = RequestMethod.POST)
    public @ResponseBody
    String editState(@RequestBody State state) {
        stateService.updateState(state);
        return "State has been updated";
    }

}


