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
import za.co.tera.web_ca.business.Rule.base.RuleService;
import za.co.tera.web_ca.business.Rule.impl.RuleServiceImpl;
import za.co.tera.web_ca.domain.impl.Rule;

import java.util.List;

@Controller
public class RuleController {
    RuleService ruleService = new RuleServiceImpl();
    @RequestMapping(value = "/getAllRules", method = RequestMethod.GET)
    public @ResponseBody List<Rule> getAllRules( ModelMap model ) {
        return ruleService.findAllRules();
    }
    /*@RequestMapping(value = "/postRule/{postId}/{username}", method = RequestMethod.GET)
    public @ResponseBody void upVote(
            @PathVariable(value = "postId") int postId,
            @PathVariable(value = "username") String username) {

        postRatingService.upVote(postId, username);
    }*/
    @RequestMapping(value = "/postRule", method = RequestMethod.POST)
    public @ResponseBody void postRule(@RequestBody Rule rule) {

        /*try {
            ObjectMapper mapper = new ObjectMapper();
            User user1 = mapper.readValue(user, User.class);
            ruleService.createRule(rule);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }*/
        ruleService.createRule(rule);
    }
   }

