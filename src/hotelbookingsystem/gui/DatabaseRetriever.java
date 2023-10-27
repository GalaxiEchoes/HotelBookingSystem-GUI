package hotelbookingsystem.gui;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class DatabaseRetriever implements IDatabaseRetriever{
    private Session session;
    private Transaction tx;

    public DatabaseRetriever() {
    }
    
    /**
     * @return HashSet of all Rooms present in Room table
     */
    @Override
    public HashSet<Room> getAllRooms(){
        HashSet<Room> roomSet;
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        
        //Retrieve Rooms from database
        Query<Room> query = session.createQuery("FROM Room r", Room.class);
        List<Room> rooms = query.getResultList();
        roomSet = new HashSet<>(rooms);
        
        tx.commit();
        DatabaseManager.closeSession(session);
        
        return roomSet;
    }
    
    /**
     * @return HashSet of all Staff present in Staff table
     */
    @Override
    public HashSet<Staff> getAllStaff(){
        HashSet<Staff> staffSet;
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        
        //Retrieve Admins from database
        Query<Staff> query = session.createQuery("FROM Staff s", Staff.class);
        List<Staff> staff = query.getResultList();
        staffSet = new HashSet<>(staff);
        
        tx.commit();
        DatabaseManager.closeSession(session);
        
        return  staffSet;
    }
    
    /**
     * @return HashSet of all bookings present in Booking table
     */
    @Override
    public HashSet<Booking> getAllBookings(){
        HashSet<Booking> bookingSet;
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        
        //Retrieve Bookings from database
        Query<Booking> query = session.createQuery("FROM Booking b", Booking.class);
        List<Booking> booking = query.getResultList();
        bookingSet = new HashSet<>(booking);
        
        tx.commit();
        DatabaseManager.closeSession(session);
        return bookingSet;
    } 
    
    /**
     * This method retrieves the Customer matching to the Booking if it exists
     * @param booking - booking we are trying to find the customer for
     * @return Customer or null if not present
     */
    @Override
    public Customer getExsistingCustomer(Booking booking){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
   
        Query<Customer> query = session.createQuery("FROM Customer c WHERE c.email = :email OR c.phoneNumber = :phoneNumber");
        query.setParameter("email",  booking.getCustomer().getEmail());
        query.setParameter("phoneNumber", booking.getCustomer().getPhoneNumber());

        List<Customer> result = query.list();

        if (result.isEmpty()) {
            tx.rollback();
            DatabaseManager.closeSession(session);
            return null;
        } else {
            tx.rollback();
            DatabaseManager.closeSession(session);
            return result.get(0);
        }
    }
    
    /**
     * Retrieves the Staff with the corresponding name from the database
     * 
     * @param username - name of User or Admin account
     * @return Staff - User or Admin account
     */
    @Override
    public Staff findStaff(String username){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
   
        Query query = session.createQuery("FROM Staff s WHERE s.name = :name ");
        query.setParameter("name", username);

        List<Staff> result = query.list();
        
        if (result.isEmpty()) {
            tx.rollback();
            DatabaseManager.closeSession(session);
            return null;
        } else {
            tx.rollback();
            DatabaseManager.closeSession(session);
            return result.get(0);
        }
    }
    
    /**
     * Finds a booking between the specified dates (inclusive)
     * @param startDate - start date of booking
     * @param endDate - end date of booking
     * @return HashSet of bookings that are between the specified dates
     */
    @Override
    public HashSet<Booking> findBookingBetweenDates(Date startDate, Date endDate){
        HashSet<Booking> bookingSet;
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        
        //Sets end date to the last minute of the day to make it inclusive
        Calendar calendar = Calendar.getInstance();    
        calendar.setTime(endDate);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        endDate = calendar.getTime();
        
        if(startDate.before(endDate)){      
            //Retrieve Bookings from database
            Query<Booking> query = session.createQuery("FROM Booking b WHERE b.startDate BETWEEN :start AND :end OR b.endDate BETWEEN :start AND :end", Booking.class);
            query.setParameter("start", startDate);
            query.setParameter("end", endDate);
            List<Booking> bookings = query.getResultList();

            bookingSet = new HashSet<>(bookings);

            tx.commit();
            DatabaseManager.closeSession(session);
        } else {
            bookingSet = new HashSet<>();
            tx.commit();
            DatabaseManager.closeSession(session);
            
            throw new IllegalArgumentException("End date must be on or after the start date");
        }

        return bookingSet;
    }
    
    /**
     * Retrieves booking with the matching bookingID
     * @param bookingID - int ID number of booking
     * @return Booking
     */
    @Override 
    public Booking findBookingById(int bookingID){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
   
        Query<Booking> query = session.createQuery("FROM Booking b WHERE b.bookingID = :booking_id");
        query.setParameter("booking_id",  bookingID);

        List<Booking> result = query.list();

        if (result.isEmpty()) {
            tx.rollback();
            DatabaseManager.closeSession(session);
            return null;
        } else {
            tx.rollback();
            DatabaseManager.closeSession(session);
            return result.get(0);
        }
    }
}
