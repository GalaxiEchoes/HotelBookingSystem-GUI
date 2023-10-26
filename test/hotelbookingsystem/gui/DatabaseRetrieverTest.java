package hotelbookingsystem.gui;

import java.util.Date;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class DatabaseRetrieverTest {
    
    private static IDatabaseRetriever dbRetriever;
    
    public DatabaseRetrieverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dbRetriever = ObjectFactory.createDatabaseRetriever();
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
     * Test of getAllRooms method, of class DatabaseRetriever.
     */
    @Test
    public void testGetAllRooms() {
        System.out.println("getAllRooms");
        DatabaseRetriever instance = new DatabaseRetriever();
        HashSet<Room> expResult = null;
        HashSet<Room> result = instance.getAllRooms();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllStaff method, of class DatabaseRetriever.
     */
    @Test
    public void testGetAllStaff() {
        System.out.println("getAllStaff");
        DatabaseRetriever instance = new DatabaseRetriever();
        HashSet<Staff> expResult = null;
        HashSet<Staff> result = instance.getAllStaff();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBookings method, of class DatabaseRetriever.
     */
    @Test
    public void testGetAllBookings() {
        System.out.println("getAllBookings");
        DatabaseRetriever instance = new DatabaseRetriever();
        HashSet<Booking> expResult = null;
        HashSet<Booking> result = instance.getAllBookings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExsistingCustomer method, of class DatabaseRetriever.
     */
    @Test
    public void testGetExsistingCustomer() {
        System.out.println("getExsistingCustomer");
        Booking booking = null;
        DatabaseRetriever instance = new DatabaseRetriever();
        Customer expResult = null;
        Customer result = instance.getExsistingCustomer(booking);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findStaff method, of class DatabaseRetriever.
     */
    @Test
    public void testFindStaff() {
        System.out.println("findStaff");
        String username = "";
        DatabaseRetriever instance = new DatabaseRetriever();
        Staff expResult = null;
        Staff result = instance.findStaff(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBookingBetweenDates method, of class DatabaseRetriever.
     */
    @Test
    public void testFindBookingBetweenDates() {
        System.out.println("findBookingBetweenDates");
        Date startDate = null;
        Date endDate = null;
        DatabaseRetriever instance = new DatabaseRetriever();
        HashSet<Booking> expResult = null;
        HashSet<Booking> result = instance.findBookingBetweenDates(startDate, endDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBookingById method, of class DatabaseRetriever.
     */
    @Test
    public void testFindBookingById() {
        System.out.println("findBookingById");
        int bookingId = 0;
        DatabaseRetriever instance = new DatabaseRetriever();
        Booking expResult = null;
        Booking result = instance.findBookingById(bookingId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
