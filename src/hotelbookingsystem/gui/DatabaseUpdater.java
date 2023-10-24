package hotelbookingsystem.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class DatabaseUpdater implements IDatabaseUpdater{
    private Session session;
    private Transaction tx;

    public DatabaseUpdater() {
    }
    
    /**
     * Deletes the booking from the database
     * @param booking - Booking to be deleted
     */
    @Override
    public void deleteBooking(Booking booking){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        
        try{
            Query query = session.createQuery("DELETE FROM Booking WHERE bookingID = :bookingID");
            query.setParameter("bookingID", booking.getBookingID());

            int rowsAffected = query.executeUpdate();

            if (rowsAffected > 0) {
                tx.commit();
            } else {
                tx.rollback();
            }
        } catch (Exception ex) { 
            tx.rollback();
            Logger.getLogger(DatabaseUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatabaseManager.closeSession(session);
    }
    
    /**
     * Adds the booking to the database
     * @param booking - Booking to be added
     * @param saveCustomer - Boolean if customer is new and needs to be saved
     */
    @Override
    public void addBooking(Booking booking, boolean saveCustomer ){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();

        try {
            session.save(booking);
            if(saveCustomer == true){
                session.save(booking.getCustomer());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } 
        
        DatabaseManager.closeSession(session);
    }
    
    /**
     * Updates the booking depending on the BookingID
     * @param changedBooking - the changed Booking to be updated
     */
    @Override
    public void updateBooking(Booking changedBooking){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        
        try {
            session.update(changedBooking);
            session.update(changedBooking.getCustomer());
            tx.commit();
        
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        
        DatabaseManager.closeSession(session);
    }
    
    /**
     * Saves a new Admin or User account to Person database
     * @param newStaff - Admin or User to be saved
     */
    @Override
    public void saveNewStaff(Person newStaff){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        try {
            session.save(newStaff);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } 
        
        DatabaseManager.closeSession(session);
    }
}
