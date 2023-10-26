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
public class ModelManagerTest {
    
    public ModelManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of findAvailableRooms method, of class ModelManager.
     */
    @Test
    public void testFindAvailableRooms() {
        System.out.println("findAvailableRooms");
        Date startDate = null;
        Date endDate = null;
        ModelManager instance = new ModelManager();
        HashSet<Room> expResult = null;
        HashSet<Room> result = instance.findAvailableRooms(startDate, endDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomByID method, of class ModelManager.
     */
    @Test
    public void testGetRoomByID() {
        System.out.println("getRoomByID");
        int roomID = 0;
        ModelManager instance = new ModelManager();
        Room expResult = null;
        Room result = instance.getRoomByID(roomID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewBooking method, of class ModelManager.
     */
    @Test
    public void testSaveNewBooking() {
        System.out.println("saveNewBooking");
        Booking booking = null;
        ModelManager instance = new ModelManager();
        instance.saveNewBooking(booking);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBooking method, of class ModelManager.
     */
    @Test
    public void testUpdateBooking() {
        System.out.println("updateBooking");
        Booking booking = null;
        ModelManager instance = new ModelManager();
        instance.updateBooking(booking);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteBooking method, of class ModelManager.
     */
    @Test
    public void testDeleteBooking() {
        System.out.println("deleteBooking");
        Booking booking = null;
        ModelManager instance = new ModelManager();
        instance.deleteBooking(booking);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findStaff method, of class ModelManager.
     */
    @Test
    public void testFindStaff() {
        System.out.println("findStaff");
        String username = "";
        ModelManager instance = new ModelManager();
        Staff expResult = null;
        Staff result = instance.findStaff(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewStaff method, of class ModelManager.
     */
    @Test
    public void testSaveNewStaff() {
        System.out.println("saveNewStaff");
        Staff newStaff = null;
        ModelManager instance = new ModelManager();
        instance.saveNewStaff(newStaff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBooking method, of class ModelManager.
     */
    @Test
    public void testFindBooking() {
        System.out.println("findBooking");
        Booking criteria = null;
        ModelManager instance = new ModelManager();
        HashSet<Booking> expResult = null;
        HashSet<Booking> result = instance.findBooking(criteria);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBookingById method, of class ModelManager.
     */
    @Test
    public void testFindBookingById() {
        System.out.println("findBookingById");
        int bookingId = 0;
        ModelManager instance = new ModelManager();
        Booking expResult = null;
        Booking result = instance.findBookingById(bookingId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invoiceBooking method, of class ModelManager.
     */
    @Test
    public void testInvoiceBooking() {
        System.out.println("invoiceBooking");
        Booking booking = null;
        ModelManager instance = new ModelManager();
        instance.invoiceBooking(booking);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
