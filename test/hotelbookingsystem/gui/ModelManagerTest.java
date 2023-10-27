package hotelbookingsystem.gui;

import java.util.Date;
import java.util.HashSet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
    
    private static ModelManager mManager;
    private static Session session;
    private static Transaction tx;
    private static Booking booking;
    
    public ModelManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        mManager = new ModelManager();
        booking = new Booking("this", ObjectFactory.createCustomer("John", "john@gmail.com", "9793893"), ObjectFactory.createNewRoom(1, "Single"), ObjectFactory.createDate(10, 10, 2023),ObjectFactory.createDate(12, 10, 2023));
        booking.setBookingID(10);
        booking.getCustomer().setPersonID(10);
        session = DatabaseManager.getSession();
    }
    
    @AfterClass
    public static void tearDownClass() {
        DatabaseManager.closeSession(session);
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
        mManager.saveNewBooking(booking);
        tx = session.beginTransaction();
        
        //Test
        HashSet<Room> result = mManager.findAvailableRooms(booking.getStartDate(), booking.getEndDate());
        
        //Verification
        assertFalse(result.contains(booking.getRoom()));
        
        Query deleteCustomer = session.createQuery("DELETE FROM Customer WHERE personID = :person_id");
        deleteCustomer.setParameter("person_id", booking.getCustomer().getPersonID());
        tx.commit();
        mManager.deleteBooking(booking);
    }

    /**
     * Test of getRoomByID method, of class ModelManager.
     */
    @Test
    public void testGetRoomByID() {
        System.out.println("getRoomByID");
        int roomID = 15;
        
        //Test
        Room result = mManager.getRoomByID(roomID);
        
        //Validation
        assertEquals(roomID, result.getRoomID());
    }
    
    /**
     * Test of getRoomByID method, of class ModelManager. Using Id for a room that does not exist.
     */
    @Test
    public void testGetRoomByIDRoomDoesNotExist() {
        System.out.println("getRoomByID");
        int roomID = 69;
        
        //Test
        Room result = mManager.getRoomByID(roomID);
        assertNull(result);
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
     * Test of updateBooking method, of class ModelManager. Booking Id is 0 so shouldn't Update.
     */
    @Test
    public void testUpdateBookingWithNewBooking() {
        System.out.println("updateBooking");
        Booking booking = new Booking();
        
        //Test
        mManager.updateBooking(booking);
        
        //Validation
        assertTrue(booking.getBookingID() == 0);
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
