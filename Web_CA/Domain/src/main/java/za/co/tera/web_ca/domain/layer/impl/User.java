package za.co.tera.web_ca.domain.layer.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Laptop on 7/1/2014.
 */
@Entity
public class User {
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private int userPassword;

    @Id
    @Column(name = "UserID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserFirstName")
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    @Basic
    @Column(name = "UserLastName")
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Basic
    @Column(name = "UserEmail")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "UserPassword")
    public int getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(int userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (userPassword != user.userPassword) return false;
        if (userEmail != null ? !userEmail.equals(user.userEmail) : user.userEmail != null) return false;
        if (userFirstName != null ? !userFirstName.equals(user.userFirstName) : user.userFirstName != null)
            return false;
        if (userLastName != null ? !userLastName.equals(user.userLastName) : user.userLastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + userPassword;
        return result;
    }
}
