package za.co.tera.web_ca.business.User.impl;

import za.co.tera.web_ca.business.User.base.UserService;
import za.co.tera.web_ca.data_access.UserDao;
import za.co.tera.web_ca.data_access.impl.UserDaoImpl;
import za.co.tera.web_ca.domain.impl.User;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class UserServiceImpl implements UserService{

   private UserDao userDAO = new UserDaoImpl();

    public void createUser(User newUser)
    {
        userDAO.save(newUser);
    }

    public void deleteUser(User delUser)
    {
        userDAO.delete(delUser);
    }

    public void updateUser(User updateUser)
    {
        userDAO.save(updateUser);
    }

    public User findUser(int ID)
    {
        return userDAO.findById(ID);
    }

    public List<User> findAllUsers()
    {
        List<User> userList = userDAO.findAll();
        return  userList;
    }
}
