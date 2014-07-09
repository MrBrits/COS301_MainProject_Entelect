package za.co.tera.Business.User;

import za.co.tera.Domain.impl.User;
import za.co.tera.data_access.impl.UserDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class UserEntityManager {

    private UserDAO user = new UserDAO();
    private String dataSource;

    public void CreateUser( String userFirstName,String userLastName,String userEmail,String userPassword,String userRole)
    {
        user.insertUser(userFirstName, userLastName, userEmail, userPassword, userRole);
    }
    public List<User> getUser()
    {
        return user.findAllObject();
    }
}
