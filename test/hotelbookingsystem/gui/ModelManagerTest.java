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
    public void testGetRoomByID_ShouldReturnNull_WhenRoomDoesNotExist() {
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
        booking.setBookingID(0);
        tx = session.beginTransaction();
        
        //Test
        mManager.saveNewBooking(booking);
        
        //Validation
        HashSet<Booking> result = dbRetriever.getAllBookings();
        assertTrue(result.contains(booking));
        
        Query deleteCustomer = session.createQuery("DELETE FROM Customer WHERE personID = :person_id");
        deleteCustomer.setParameter("person_id", booking.getCustomer().getPersonID());
        tx.commit();
        mManager.deleteBooking(booking);
        booking.setBookingID(10);
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
        tx = session.beginTransaction();
        session.save(booking);
        tx.commit();
        
        //Test
        HashSet<Booking> result = mManager.findBooking(booking);
        
        //Verification
        assertTrue(result.contains(booking));
        
        Query deleteBooking = session.createQuery("DELETE FROM Booking WHERE bookingID = :booking_id");
        deleteBooking.setParameter("booking_id", booking.getBookingID());
        tx.commit();
    }

    /**
     * Test of invoiceBooking method, of class ModelManager.
     */
    @Test
    public void testInvoiceBooking() {
        System.out.println("invoiceBooking");
        tx = session.beginTransaction();
        float total = 226.8f;
        
        //Test
        mManager.invoiceBooking(booking);
        
        //Verification
        assertTrue(booking.getTotal() == total);
        
        Query deleteBooking = session.createQuery("DELETE FROM Booking WHERE bookingID = :booking_id");
        deleteBooking.setParameter("booking_id", booking.getBookingID());
        tx.commit();
    }
}
