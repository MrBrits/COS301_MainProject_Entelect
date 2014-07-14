package Business;

import za.co.tera.web_ca.business.User.base.UserService;
import za.co.tera.web_ca.business.User.impl.UserServiceImpl;
import za.co.tera.web_ca.domain.impl.User;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class Main {
    public static void main(String[] args) {
        UserService userEntityManager = new UserServiceImpl();
        List<User> temp=userEntityManager.findAllUsers();
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i).getUserFirstName());
        }
    }
}
