package hotelbookingsystem.gui;

import java.util.HashSet;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mgk3508
 */
public class DatabaseRetriever implements IDatabaseRetriever{
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction tx;

    public DatabaseRetriever() {
        this.sessionFactory = DatabaseManager.getSessionFactory();
    }
    
    @Override
    public HashSet<Room> getAllRooms(){
        HashSet<Room> roomSet;
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        
        //Retrieve Rooms from database
        Query<Room> query = session.createQuery("FROM Room r", Room.class);
        List<Room> rooms = query.getResultList();
        roomSet = new HashSet<>(rooms);
        
        tx.commit();
        DatabaseManager.closeSession(session);
        
        return roomSet;
    }
    
    @Override
    public HashSet<Person> getAllAdmins(){
        HashSet<Person> adminSet;
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        
        //Retrieve Admins from database
        Query<Admin> query = session.createQuery("FROM Admin a", Admin.class);
        List<Admin> admin = query.getResultList();
        adminSet = new HashSet<>(admin);
        
        tx.commit();
        DatabaseManager.closeSession(session);
        
        return  adminSet;
    }
    
    @Override
    public HashSet<Booking> getAllBookings(){
        HashSet<Booking> bookingSet;
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        
        //Retrieve Bookings from database
        Query<Booking> query = session.createQuery("FROM Booking b", Booking.class);
        List<Booking> booking = query.getResultList();
        bookingSet = new HashSet<>(booking);
        
        tx.commit();
        DatabaseManager.closeSession(session);
        return bookingSet;
    } 
    
    @Override
    public Person getExsistingCustomer(Booking booking){
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
   
        Query query = session.createQuery("FROM Customer c WHERE c.email = :email OR c.phoneNumber = :phoneNumber");
        query.setParameter("email", ((Customer) booking.getCustomer()).getEmail());
        query.setParameter("phoneNumber", ((Customer) booking.getCustomer()).getPhoneNumber());

        List<Person> result = query.list();

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
