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
}


