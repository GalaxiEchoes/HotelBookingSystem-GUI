package hotelbookingsystem.gui;

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
    private static IDatabaseRetriever dbRetriever;
    private static Session session;
    private static Transaction tx;
    private static Booking booking;
    
    public ModelManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        mManager = new ModelManager();
        dbRetriever = ObjectFactory.createDatabaseRetriever();
        booking = new Booking("this", ObjectFactory.createCustomer("John", "john@gmail.com", "9793893"), mManager.getRoomByID(1), ObjectFactory.createDate(10, 10, 2023),ObjectFactory.createDate(12, 10, 2023));
        session = DatabaseManager.getSession();
    }
    
    @AfterClass
    public static void tearDownClass() {
        restartSession();
        if(booking.getBookingID() != 0){
            session.delete(booking);
            session.delete(booking.getCustomer());
            tx.commit();
        }
        DatabaseManager.closeSession(session);
    }
    
    @Before
    public void setUp() {
        restartSession();
        if(booking.getBookingID() != 0){
            session.delete(booking);
            session.delete(booking.getCustomer());
            booking.setBookingID(0);
            booking.getCustomer().setCustomerID(0);
            tx.commit();
        }
        restartSession();
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
        session.save(booking.getCustomer());
        session.save(booking);
        tx.commit();
        
        //Test
        HashSet<Room> result = mManager.findAvailableRooms(booking.getStartDate(), booking.getEndDate());
        
        //Verification
        assertFalse(result.contains(booking.getRoom()));
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
    public void testGetRoomByID_ShouldReturnNull_WhenRoomDoesNotExist() {
        System.out.println("getRoomByID_ShouldReturnNull_WhenRoomDoesNotExist");
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
        
        //Test
        mManager.saveNewBooking(booking);
        
        //Validation
        HashSet<Booking> result = dbRetriever.getAllBookings();
        assertTrue(result.contains(booking));
    }

    /**
     * Test of updateBooking method, of class ModelManager.
     */
    @Test
    public void testUpdateBookingWithNewBooking() {
        System.out.println("updateBookingWithNewBooking");
        
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
        session.save(booking.getCustomer());
        session.save(booking);
        tx.commit();
        
        //Test
        HashSet<Booking> result = mManager.findBooking(booking);
        
        //Verification
        assertTrue(result.contains(booking));
    }

    /**
     * Test of invoiceBooking method, of class ModelManager.
     */
    @Test
    public void testInvoiceBooking() {
        System.out.println("invoiceBooking");
        float total = 226.8f;
        
        //Test
        mManager.invoiceBooking(booking);
        
        //Verification
        assertTrue(booking.getTotal() == total);
    }
    
    /**
     * Utility method to restart the session.
     */
    static public void restartSession(){
        DatabaseManager.closeSession(session);
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
    }
}
