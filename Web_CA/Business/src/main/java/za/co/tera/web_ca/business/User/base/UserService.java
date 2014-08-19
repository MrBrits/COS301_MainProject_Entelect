package za.co.tera.web_ca.business.User.base;

import za.co.tera.web_ca.domain.impl.User;

import java.util.List;

/**
 * Created by Christo on 2014/07/14.
 */
public interface UserService {
    /**
     *
     * @param newUser
     * @return
     */
    public boolean createUser(User newUser);

    /**
     *
     * @param delUser
     */
    public void deleteUser(User delUser);

    /**
     *
     * @param updateUser
     */
    public void updateUser(User updateUser);

    /**
     *
     * @param ID
     * @return
     */
    public User findUserById(int ID);

    /**
     *
     * @param loginUser
     * @return
     */
    public User loginUser(User loginUser);

    /**
     *
     * @return
     */
    public List<User> findAllUsers();
}
