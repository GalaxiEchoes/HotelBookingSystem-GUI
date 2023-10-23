package hotelbookingsystem.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author mgk3508
 */
public class DatabaseUpdater implements IDatabaseUpdater{
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction tx;

    public DatabaseUpdater() {
        this.sessionFactory = DatabaseManager.getSessionFactory();
    }
    
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
}
