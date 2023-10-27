package hotelbookingsystem.gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class LogInManagerTest {
    
    public static LogInManager liManager;
    
    public LogInManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        liManager = new LogInManager();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkLogin method, of class LogInManager. With correct details.
     */
    @Test
    public void testCheckLoginWithCorrectPassword() {
        System.out.println("testCheckLoginWithCorrectPassword");
        Staff staff = ObjectFactory.createStaff("User", "Susan", "password");
        String password = "password";
        String username = "Susan";
        
        boolean result = liManager.checkLogin(staff, password, username);
        assertTrue(result);
    }
    
    /**
     * Test of checkLogin method, of class LogInManager.
     */
    @Test
    public void testCheckLoginWithIncorrectPassword() {
        System.out.println("testCheckLoginWithIncorrectPassword");
        Staff staff = ObjectFactory.createStaff("User", "Susan", "password");
        String password = "notthepassword";
        String username = "Susan";
        
        boolean result = liManager.checkLogin(staff, password, username);
        assertFalse(result);
    }

    /**
     * Test of checkAdmin method, of class LogInManager. Checking with User so should be false.
     */
    @Test
    public void testCheckAdminWithUserAccount() {
        System.out.println("testCheckAdminWithUserAccount");
        Staff user = ObjectFactory.createStaff("User", "Susan", "password");
        
        boolean result = liManager.checkAdmin(user);
        assertFalse(result);
    }
    
    /**
     * Test of checkAdmin method, of class LogInManager. Checking with Admin so should be true.
     */
    @Test
    public void testCheckAdminWithAdminAccount() {
        System.out.println("testCheckAdminWithAdminAccount");
        Staff user = ObjectFactory.createStaff("Admin", "Susan", "password");
        
        boolean result = liManager.checkAdmin(user);
        assertTrue(result);
    }
}
