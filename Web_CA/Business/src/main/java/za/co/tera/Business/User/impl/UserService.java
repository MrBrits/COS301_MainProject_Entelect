package za.co.tera.Business.User.impl;

import za.co.tera.Data_Access.impl.UserDAO;
import za.co.tera.Domain.impl.User;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public class UserService {
    //@AutoWired
    private UserDAO userDAO = new UserDAO();

    public void createUser(User newUser)
    {
        userDAO.insertUser(newUser);
    }

    public void deleteUser(User delUser)
    {
        userDAO.delete(delUser);
    }

    public void updateUser(User updateUser)
    {
        userDAO.saveOrUpdate(updateUser);
    }

    public User findUser(int ID)
    {
        return userDAO.find(ID);
    }

    public List<User> findAllUsers()
    {
        List<User> userList = userDAO.findAllObject();
        return  userList;
    }
}
