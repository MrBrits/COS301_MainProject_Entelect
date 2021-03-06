package za.co.tera.web_ca.business.User.impl;

import za.co.tera.web_ca.business.User.base.UserService;
import za.co.tera.web_ca.data_access.UserDao;
import za.co.tera.web_ca.data_access.impl.UserDaoImpl;
import za.co.tera.web_ca.domain.impl.User;

import java.util.List;

public class UserServiceImpl implements UserService{

   private UserDao userDAO = new UserDaoImpl();

    public boolean createUser(User newUser)
    {
        if (userDAO.validateRegistrarEmail(newUser)) {
            userDAO.save(newUser);
            return true;
        }
        else return false;
    }

    public void deleteUser(User delUser)
    {
        userDAO.delete(delUser);
    }

    public void updateUser(User updateUser)
    {
        int ID = (updateUser.getUserId() + 321)/369;
        updateUser.setUserId(ID);
        userDAO.save(updateUser);
    }

    public User findUserById(int ID)
    {
        ID = (ID + 321)/369;
        return userDAO.findById(ID);
    }

    public User loginUser(User loginUser)   {
         return userDAO.loginUser(loginUser.getUserEmail(), loginUser.getUserPassword());
    }

    public List<User> findAllUsers()    {
        List<User> userList = userDAO.findAll();
        return  userList;
    }
}
