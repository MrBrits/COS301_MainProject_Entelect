package za.co.tera.web_ca.data_access.impl;

import za.co.tera.web_ca.data_access.UserDao;
import za.co.tera.web_ca.data_access.base.impl.AbstractDaoImpl;
import za.co.tera.web_ca.domain.impl.User;

/**
 * Created by Laptop on 7/14/2014.
 */
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public String getUserEmail(int id) {
        return "jkjjk";
    }

    @Override
    public String getFullName(int id) {
        return null;
    }

    @Override
    public Boolean emailAvailability(int id) {
        return null;
    }
}