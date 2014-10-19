package za.co.tera.web_ca.domain.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class UserTest extends TestCase {

    private User userTest;
    @Before
    public void setUp() throws Exception{
        userTest = new User();
        userTest.setUserId(1);
        userTest.setUserFirstName("First Name");
        userTest.setUserLastName("Last Name");
        userTest.setUserEmail("Email");
        userTest.setUserPassword("Password");
        userTest.setUserRole("Role");
    }

    @Test
    public void testUser() throws Exception{
        assertEquals(1, userTest.getUserId());
        assertEquals("First Name", userTest.getUserFirstName());
        assertEquals("Last Name", userTest.getUserLastName());
        assertEquals("Email", userTest.getUserEmail());
        assertEquals("Password", userTest.getUserPassword());
        assertEquals("Role", userTest.getUserRole());
        assertEquals(324245092, userTest.hashCode());
    }

}