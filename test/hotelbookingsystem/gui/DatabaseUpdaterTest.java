package hotelbookingsystem.gui;

import java.util.List;
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
public class DatabaseUpdaterTest {

    private static IDatabaseUpdater dbUpdater;
    private static ModelManager mManager;
    private static Booking booking;
    private static Room room;
    private static Staff staff;
    private static Session session;
    private static Transaction tx;
    
    public DatabaseUpdaterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dbUpdater = ObjectFactory.createDatabaseUpdater();
        mManager = new ModelManager();
        booking = new Booking("this", ObjectFactory.createCustomer("John", "john@gmail.com", "9793893"), mManager.getRoomByID(1), ObjectFactory.createDate(10, 10, 2023),ObjectFactory.createDate(12, 10, 2023));
        room = ObjectFactory.createNewRoom(16, "Single");
        staff = ObjectFactory.createStaff("Admin", "John", "John");
    }
    
    @AfterClass
    public static void tearDownClass() {
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
     * Test of deleteBooking method, of class DatabaseUpdater.
     */
    @Test
    public void testDeleteBooking() {
        System.out.println("deleteBooking");
        
        //Setup
        session.save(booking.getCustomer());
        session.save(booking);
        tx.commit();
        restartSession();
        
        //Test
        dbUpdater.deleteBooking(booking);

        //Verification
        Query<Booking> query = session.createQuery("FROM Booking b WHERE b.bookingID = :booking_id");
        query.setParameter("booking_id",  booking.getBookingID());
        List<Booking> result = query.list();
        booking.setBookingID(0);
        session.save(booking);
        tx.commit();
        assertTrue(result.isEmpty());
    }

    /**
     * Test of addBooking method, of class DatabaseUpdater.
     */
    @Test
    public void testAddBooking() {
        System.out.println("addBooking");

        //Test
        dbUpdater.addBooking(booking);
        
        //Verification
        Query<Booking> query = session.createQuery("FROM Booking b WHERE b.bookingID = :booking_id");
        query.setParameter("booking_id",  booking.getBookingID());
        List<Booking> result = query.list();
        tx.rollback();
        assertTrue(result.contains(booking));
    }

    /**
     * Test of updateBooking method, of class DatabaseUpdater.
     */
    @Test
    public void testUpdateBooking() {
        System.out.println("updateBooking");
        
        //Setup
        session.save(booking.getCustomer());
        session.save(booking);
        tx.commit();
        booking.setTotal(160.00f);
        
        //Test
        dbUpdater.updateBooking(booking);
        
        //Verification
        restartSession();
        Query<Booking> query = session.createQuery("FROM Booking b WHERE b.bookingID = :booking_id");
        query.setParameter("booking_id",  booking.getBookingID());
        List<Booking> result = query.list();
        tx.commit();
        assertTrue(result.contains(booking));
    }

    /**
     * Test of saveNewStaff method, of class DatabaseUpdater.
     */
    @Test
    public void testSaveNewStaff() {
        System.out.println("saveNewStaff");
        
        //Test
        dbUpdater.saveNewStaff(staff);
        
        //Verification
        Query<Staff> query = session.createQuery("FROM Staff s WHERE s.staffID = :staff_id");
        query.setParameter("staff_id",  staff.getStaffID());
        List<Staff> result = query.list();
        tx.commit();
        restartSession();
        session.delete(staff);
        tx.commit();
        assertTrue(result.contains(staff));
    }

    /**
     * Test of saveNewRoom method, of class DatabaseUpdater.
     */
    @Test
    public void testSaveNewRoom() {
        System.out.println("saveNewRoom");
        
        //Test
        dbUpdater.saveNewRoom(room);
        
        //Verification
        Query<Room> query = session.createQuery("FROM Room r WHERE r.roomID = :room_id");
        query.setParameter("room_id",  room.getRoomID());
        List<Room> result = query.list();
        tx.rollback();
        restartSession();
        session.delete(room);
        tx.commit();
        assertTrue(result.contains(room));
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
