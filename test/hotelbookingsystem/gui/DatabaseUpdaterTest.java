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
        booking = new Booking("this", ObjectFactory.createCustomer("John", "john@gmail.com", "9793893"), ObjectFactory.createNewRoom(1, "Single"), ObjectFactory.createDate(10, 10, 2023),ObjectFactory.createDate(12, 10, 2023));
        booking.setBookingID(10);
        booking.getCustomer().setPersonID(10);
        room = ObjectFactory.createNewRoom(16, "Single");
        staff = ObjectFactory.createStaff("Admin", "John", "John");
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
     * Test of deleteBooking method, of class DatabaseUpdater.
     */
    @Test
    public void testDeleteBooking() {
        System.out.println("deleteBooking");
        tx = session.beginTransaction();
        
        //Setup
        session.save(booking);
        tx.commit();

        //Test
        dbUpdater.deleteBooking(booking);

        //Verification
        Query<Booking> query = session.createQuery("FROM Booking b WHERE b.bookingID = :booking_id");
        query.setParameter("booking_id",  booking.getBookingID());
        List<Booking> result = query.list();
        assertTrue(result.isEmpty());
        tx.rollback();
    }

    /**
     * Test of addBooking method, of class DatabaseUpdater.
     */
    @Test
    public void testAddBooking() {
        System.out.println("addBooking");
        tx = session.beginTransaction();

        //Test
        dbUpdater.addBooking(booking);
        
        //Verification
        Query<Booking> query = session.createQuery("FROM Booking b WHERE b.bookingID = :booking_id");
        query.setParameter("booking_id",  booking.getBookingID());
        List<Booking> result = query.list();
        assertEquals(booking.getBookingID(), result.get(0).getBookingID(), 0);
        tx.rollback();
        dbUpdater.deleteBooking(booking);
    }

    /**
     * Test of updateBooking method, of class DatabaseUpdater.
     */
    @Test
    public void testUpdateBooking() {
        System.out.println("updateBooking");
        tx = session.beginTransaction();
        
        //Setup
        session.save(booking);
        tx.commit();
        booking.setTotal(160.00f);
        
        //Test
        dbUpdater.updateBooking(booking);
        
        //Verification
        Query<Booking> query = session.createQuery("FROM Booking b WHERE b.bookingID = :booking_id");
        query.setParameter("booking_id",  booking.getBookingID());
        List<Booking> result = query.list();
        assertEquals(booking.getTotal(), result.get(0).getTotal(), 0);
        tx.rollback();
        dbUpdater.deleteBooking(booking);
    }

    /**
     * Test of saveNewStaff method, of class DatabaseUpdater.
     */
    @Test
    public void testSaveNewStaff() {
        System.out.println("saveNewStaff");
        tx = session.beginTransaction();
        
        //Test
        dbUpdater.saveNewStaff(staff);
        
        //Verification
        Query<Staff> query = session.createQuery("FROM Staff s WHERE s.staffID = :staff_id");
        query.setParameter("staff_id",  staff.getStaffID());
        List<Staff> result = query.list();
        assertEquals(staff.getStaffID(), result.get(0).getStaffID(), 0);
        tx.rollback();
        Query queryDelete = session.createQuery("DELETE FROM Staff WHERE staffID = :staff_id");
        queryDelete.setParameter("staff_id", staff.getStaffID());
        tx.commit();
    }

    /**
     * Test of saveNewRoom method, of class DatabaseUpdater.
     */
    @Test
    public void testSaveNewRoom() {
        System.out.println("saveNewRoom");
        tx = session.beginTransaction();
        
        //Test
        dbUpdater.saveNewRoom(room);
        
        //Verification
        Query<Room> query = session.createQuery("FROM Room r WHERE r.roomID = :room_id");
        query.setParameter("room_id",  room.getRoomID());
        List<Room> result = query.list();
        assertEquals(room.getRoomID(), result.get(0).getRoomID(), 0);
        tx.rollback();
        Query queryDelete = session.createQuery("DELETE FROM Room WHERE roomID = :room_id");
        queryDelete.setParameter("room_id", room.getRoomID());
        tx.commit();
    }
}
