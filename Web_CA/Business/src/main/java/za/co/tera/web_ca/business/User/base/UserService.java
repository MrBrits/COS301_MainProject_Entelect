package za.co.tera.web_ca.business.User.base;

import za.co.tera.web_ca.domain.impl.User;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public interface UserService {

    public boolean createUser(User newUser);
    public void deleteUser(User delUser);
    public void updateUser(User updateUser);
    public User findUser(int ID);
    public List<User> findAllUsers();
}
