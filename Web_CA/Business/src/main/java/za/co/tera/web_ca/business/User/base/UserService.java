package za.co.tera.web_ca.business.User.base;

import za.co.tera.web_ca.domain.impl.User;

import java.util.List;


public interface UserService {

    public boolean createUser(User newUser);
    public void deleteUser(User delUser);
    public void updateUser(User updateUser);
    public User findUserById(int ID);
    public User loginUser(User loginUser);
    public List<User> findAllUsers();
}
