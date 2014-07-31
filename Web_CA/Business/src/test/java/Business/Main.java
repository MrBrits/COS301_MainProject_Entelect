package Business;

import za.co.tera.web_ca.business.User.base.UserService;
import za.co.tera.web_ca.business.User.impl.UserServiceImpl;
import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.business.World.impl.WorldServiceImpl;
import za.co.tera.web_ca.domain.impl.World;

/**
 * Created by Christo on 2014/07/04.
 */
public class Main {
    public static void main(String[] args) {
        WorldService stateService = new WorldServiceImpl();
        UserService userServiceer= new UserServiceImpl();

        World world = new World("world","world",2,5,5,5,23);
        stateService.createWorld(world);

    }
}
