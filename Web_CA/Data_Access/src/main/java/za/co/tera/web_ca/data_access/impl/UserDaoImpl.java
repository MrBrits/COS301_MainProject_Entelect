package za.co.tera.web_ca.data_access.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import za.co.tera.web_ca.data_access.UserDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.User;

import java.util.List;

/**
 * Created by Laptop on 7/14/2014.
 */
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    /*
     * Checks the database to see if the user that is trying to
     * register already exists. If the email exists TRUE is
     * returned else FALSE is returned.
     *
     * @param user - a User object containing all information of the user trying to register
     * @return boolean -    TRUE->User doesn't exist
     *                      FALSE->User already exists
     */
    @Override
    public boolean validateRegistrarEmail(User user) {
        boolean valid = true;
        String userEmail = user.getUserEmail();

        Session session= getSession();
        Query query = session.createQuery("From User user where user.userEmail = :userEmail");
        query.setParameter("userEmail", userEmail);
        List<User> userList = query.list();

        if (!userList.isEmpty())
            valid = false;

        return valid;
    }

    @Override
    public String getUserEmail(int id) {
        return null;
    }

    @Override
    public String getFullName(int id) {
        return null;
    }

        /*
     * Checks the database to see if the users email exist
     * and corresponds to the email. If the pair corresponds TRUE
     * returned else FALSE is returned.
     *
     * @param userEmail - a String email is supplied when logging in
     * @param userPassword - a String password is supplied when logging in
     *
     * @return boolean -    TRUE->If validation was successful
     *                      FALSE->If validation was unsuccessful
     */
    @Override
    public Boolean validateLogin(String userEmail, String userPassword) {

        boolean valid = true;
        Session session= getSession();
        Query query = session.createQuery("From User user where user.userEmail = :userEmail and  user.userPassword = :userPassword");
        query.setParameter("userEmail", userEmail);
        query.setParameter("userPassword", userPassword);
        List<User> userList = query.list();
        if (userList.isEmpty())
            valid = false;

        return valid;

    }


}