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
public class DatabaseRetrieverTest {
    
    private static IDatabaseRetriever dbRetriever;
    private static Booking booking;
    private static Room room;
    private static Staff staff;
    private static Session session;
    private static Transaction tx;
    
    public DatabaseRetrieverTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dbRetriever = ObjectFactory.createDatabaseRetriever();
        ModelManager mManager = new ModelManager();
        booking = new Booking("this", ObjectFactory.createCustomer("John", "john@gmail.com", "9793893"), mManager.getRoomByID(1), ObjectFactory.createDate(10, 10, 2023),ObjectFactory.createDate(12, 10, 2023));
        booking.getCustomer().setCustomerID(10);
        room = ObjectFactory.createNewRoom(16, "Single");
        staff = ObjectFactory.createStaff("Admin", "John", "John");
        staff.setStaffID(201);
        session = DatabaseManager.getSession();
    }
    
    @AfterClass
    public static void tearDownClass() {
        DatabaseManager.closeSession(session);
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        session.delete(staff);
        tx.commit();
        restartSession();
        session.delete(room);
        tx.commit();
        restartSession();
        session.delete(booking);
        tx.commit();
        restartSession();
        session.delete(booking.getCustomer());
        tx.commit();
        
        DatabaseManager.closeSession(session);
    }
    
    @Before
    public void setUp() {
        DatabaseManager.closeSession(session);
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
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
        session.saveOrUpdate(room);
        tx.commit();
        
        //Test
        HashSet<Room> result = dbRetriever.getAllRooms();
        
        //Verification
        assertTrue(result.contains(room));
    }

    /**
     * Test of getAllStaff method, of class DatabaseRetriever.
     */
    @Test
    public void testGetAllStaff() {
        System.out.println("getAllStaff");
        session.saveOrUpdate(staff);
        tx.commit();
        
        //Test
        HashSet<Staff> result = dbRetriever.getAllStaff();
        
        //Verification
        assertTrue(result.contains(staff));
    }

    /**
     * Test of getAllBookings method, of class DatabaseRetriever.
     */
    @Test
    public void testGetAllBookings() {
        System.out.println("getAllBookings");
        session.saveOrUpdate(booking.getCustomer());
        tx.commit();
        restartSession();
        session.saveOrUpdate(booking);
        tx.commit();
        
        //Test
        HashSet<Booking> result = dbRetriever.getAllBookings();
        
        //Verification
        assertTrue(result.contains(booking));
    }

    /**
     * Test of getExsistingCustomer method, of class DatabaseRetriever.
     */
    @Test
    public void testGetExsistingCustomer() {
        System.out.println("getExsistingCustomer");
        session.saveOrUpdate(booking.getCustomer());
        tx.commit();
        restartSession();
        session.saveOrUpdate(booking);
        tx.commit();
        
        //Test
        Customer result = dbRetriever.getExsistingCustomer(booking);
        
        //Verification
        assertEquals(booking.getCustomer(), result);
    }

    /**
     * Test of findStaff method, of class DatabaseRetriever.
     */
    @Test
    public void testFindStaff() {
        System.out.println("findStaff");
        session.saveOrUpdate(staff);
        tx.commit();
        
        //Test
        Staff result = dbRetriever.findStaff(staff.getName());
        
        //Verification
        assertEquals(staff, result);
    }

    /**
     * Test of findBookingBetweenDates method, of class DatabaseRetriever.
     */
    @Test
    public void testFindBookingBetweenDates() {
        System.out.println("findBookingBetweenDates");
        session.saveOrUpdate(booking.getCustomer());
        tx.commit();
        restartSession();
        session.saveOrUpdate(booking);
        tx.commit();
        
        //Test
        HashSet<Booking> result = dbRetriever.findBookingBetweenDates(booking.getStartDate(), booking.getEndDate());
        
        //Verification
        assertTrue(result.contains(booking));
    }

    /**
     * Test of findBookingById method, of class DatabaseRetriever.
     */
    @Test
    public void testFindBookingById() {
        System.out.println("findBookingById");
        session.saveOrUpdate(booking.getCustomer());
        tx.commit();
        restartSession();
        session.saveOrUpdate(booking);
        tx.commit();
        
        //Test
        Booking result = dbRetriever.findBookingById(booking.getBookingID());
        
        //Verification
        assertEquals(booking, result);
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
