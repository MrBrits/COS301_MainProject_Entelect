package za.co.tera.web_ca.domain.impl;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User  implements Serializable {
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userRole;
    private boolean tutorials;

    public User()
    {}

    public User(String userFirstName, String userLastName, String userEmail, String userPassword, String userRole, boolean tutorials)
    {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.tutorials = tutorials;
    }

    @Id
    @Column(name = "UserID", nullable = false, insertable = true, updatable = true)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "UserFirstName", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    @Basic
    @Column(name = "UserLastName", nullable = false, insertable = true, updatable = true, length = 40)
    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    @Basic
    @Column(name = "UserEmail", nullable = false, insertable = true, updatable = true, length = 50)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "UserPassword", nullable = false, insertable = true, updatable = true, length = 50)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "UserRole", nullable = false, insertable = true, updatable = true, length = 20)
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "Tutorials", nullable = false, insertable = true, updatable = true)
    public boolean getTutorials() {
        return tutorials;
    }

    public void setTutorials(boolean tutorials) {
        this.tutorials = tutorials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (userEmail != null ? !userEmail.equals(user.userEmail) : user.userEmail != null) return false;
        if (userFirstName != null ? !userFirstName.equals(user.userFirstName) : user.userFirstName != null)
            return false;
        if (userLastName != null ? !userLastName.equals(user.userLastName) : user.userLastName != null) return false;
        if (userPassword != null ? !userPassword.equals(user.userPassword) : user.userPassword != null) return false;
        if (userRole != null ? !userRole.equals(user.userRole) : user.userRole != null) return false;
        if (tutorials != user.tutorials) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        result = 31 * result + (tutorials ? 1 : 0);
        return result;
    }

}
