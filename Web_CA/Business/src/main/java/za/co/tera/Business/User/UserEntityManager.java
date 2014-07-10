package za.co.tera.Business.User;

import za.co.tera.Domain.impl.User;
import za.co.tera.data_access.impl.UserDAO;

import java.util.List;

/**
 * Created by Christo on 2014/07/04.
 */
public class UserEntityManager {

    private UserDAO user = new UserDAO();

    public void createUser(User newUser)
    {
        user.insertUser(newUser.getUserFirstName(), newUser.getUserLastName(), newUser.getUserEmail(), newUser.getUserPassword(), newUser.getUserRole());
    }

    public void createUser(String userFirstName,String userLastName,String userEmail,String userPassword,String userRole)
    {
        user.insertUser(userFirstName, userLastName, userEmail, userPassword, userRole);
    }

    public void deleteUser(User delUser)
    {
        user.delete(delUser);
    }

    public void updateUser(User updateUser)
    {
        user.saveOrUpdate(updateUser);
    }

    public User findUser(int ID)
    {
        return user.find(ID);
    }

    public List<User> findAllUsers()
    {
        List<User> userList = user.findAllObject();
        return  userList;
    }

}
