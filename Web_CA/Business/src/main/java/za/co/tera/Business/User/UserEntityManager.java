package za.co.tera.Business.User;

import za.co.tera.data_access.impl.UserDOA;

/**
 * Created by Christo on 2014/07/04.
 */
public class UserEntityManager {

    private UserDOA user = new UserDOA();
    public void CreateUser( String userFirstName,String userLastName,String userEmail,String userPassword,String userRole)
    {
        user.insertUser(userFirstName, userLastName, userEmail, userPassword, userRole);
    }
}
