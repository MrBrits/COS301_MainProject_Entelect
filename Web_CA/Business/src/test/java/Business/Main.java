package Business;

/**
 * Created by Christo on 2014/07/04.
 */
public class Main {
    public static void main(String[] args) {
        UserEntityManager userEntityManager = new UserEntityManager();
        userEntityManager.createUser("John", "Doe", "john@gmial.com", "123", "Admin");
    }
}
