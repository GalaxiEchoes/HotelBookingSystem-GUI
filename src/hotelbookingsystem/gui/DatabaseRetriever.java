package hotelbookingsystem.gui;

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
     * @return HashSet of all Persons present in Person table
     */
    @Override
    public HashSet<Person> getAllPersons(){
        HashSet<Person> personSet;
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        
        //Retrieve Admins from database
        Query<Person> query = session.createQuery("FROM Person p", Person.class);
        List<Person> person = query.getResultList();
        personSet = new HashSet<>(person);
        
        tx.commit();
        DatabaseManager.closeSession(session);
        
        return  personSet;
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
     * Retrieves the Person with the corresponding name from the database
     * 
     * @param username - name of User or Admin account
     * @return Person - User or Admin account
     */
    @Override
    public Person findStaff(String username){
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
   
        Query query = session.createQuery("FROM Person p WHERE p.name = :name ");
        query.setParameter("name", username);

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
