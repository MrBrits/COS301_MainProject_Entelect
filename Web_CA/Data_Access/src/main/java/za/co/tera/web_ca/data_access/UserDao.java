package za.co.tera.web_ca.data_access;

import za.co.tera.web_ca.data_access.base.AbstractDao;
import za.co.tera.web_ca.domain.impl.User;

/**
 * Created by Laptop on 7/14/2014.
 */
public interface UserDao extends AbstractDao<User> {
    public boolean validateRegistrarEmail(User user);
    public String getUserEmail(int id);
    public String getFullName(int id);
    public User loginUser(String userEmail,String userPassword);

}
