package Business;

import za.co.tera.web_ca.business.World.base.WorldService;
import za.co.tera.web_ca.business.World.impl.WorldServiceImpl;
import za.co.tera.web_ca.domain.impl.World;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class Main {
    public static void main(String[] args) {
        WorldService stateService = new WorldServiceImpl();
        List<World> statelist =stateService.findWorldByUserId(23);
        for (int i = 0; i < statelist.size(); i++) {
            System.out.println(statelist.get(i).getWorldName());
        }
    }
}
