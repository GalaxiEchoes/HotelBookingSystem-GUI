package hotelbookingsystem.gui;

import java.util.List;
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
            session.delete(booking);
            tx.commit();
            
        } catch (Exception ex) { 
            tx.rollback();
            Logger.getLogger(DatabaseUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
        DatabaseManager.closeSession(session);
    }
    
    /**
     * Adds the booking to the database
     * @param booking - Booking to be added
     */
    @Override
    public void addBooking(Booking booking){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();

        try {
            session.saveOrUpdate(booking);
            session.saveOrUpdate(booking.getCustomer());

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
            session.saveOrUpdate(changedBooking);
            session.saveOrUpdate(changedBooking.getCustomer());
            tx.commit();
        
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        
        DatabaseManager.closeSession(session);
    }
    
    /**
     * Saves a new Admin or User account to Staff database
     * @param newStaff - Admin or User to be saved
     */
    @Override
    public void saveNewStaff(Staff newStaff){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        Query query = session.createQuery("FROM Staff s WHERE s.name = :name ");
        query.setParameter("name", newStaff.getName());

        List<Staff> result = query.list();
        
        if(result.isEmpty()){
            try {
                session.saveOrUpdate(newStaff);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                e.printStackTrace();
            } 
        } else {
            throw new IllegalArgumentException("This username is not unique.");
        }

        
        DatabaseManager.closeSession(session);
    }
    
    /**
     * Saves a new Room to database
     * @param room - Room to be saved
     */
    @Override
    public void saveNewRoom(Room room){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        try {
            session.saveOrUpdate(room);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } 
        
        DatabaseManager.closeSession(session);
    }
}
