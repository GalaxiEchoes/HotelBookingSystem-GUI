/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.util.HashSet;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.logging.log4j.EventLogger;
import org.hibernate.query.Query;

/**
 *
 * @author jenni
 */
public class TestMain {
    public static void main(String[] args) {
        org.apache.logging.log4j.LogManager.getContext(false);
        /*
        // Create a new customer
        Customer customer = new Customer("John Doe", "john.doe@example.com", "1234567890");

        // Get the session factory
        SessionFactory factory = DatabaseManager.getSessionFactory();

        // Open a new session
        Session session = factory.openSession();

        // Start a new transaction
        Transaction transaction = session.beginTransaction();

        // Save the customer to the database
        session.save(customer);
        
        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();

        // Open a new session
        session = factory.openSession();

        // Start a new transaction
        transaction = session.beginTransaction();

        // Retrieve the customer from the database
        Customer retrievedCustomer = session.get(Customer.class, customer.getPersonId());

        // Print the customer's details to the console
        System.out.println(retrievedCustomer);

        // Delete the customer from the database
        session.delete(retrievedCustomer);

        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();

        // Close the factory
        factory.close();
        
        
        Staff admin = ObjectFactory.createStaff("Admin", "admin", "password");
        ModelManager mManager = new ModelManager();
        mManager.saveNewStaff(admin);
        
        Staff retrieved = mManager.findStaff("admin");
        System.out.println(retrieved);
        
        
        IDatabaseUpdater dbUpdater = ObjectFactory.createDatabaseUpdater();
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(1, "Single"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(2, "Single"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(3, "Single"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(4, "Single"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(5, "Single"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(6, "Double"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(7, "Double"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(8, "Double"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(9, "Double"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(10, "Double"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(11, "Suite"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(12, "Suite"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(13, "Suite"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(14, "Suite"));
        dbUpdater.saveNewRoom(ObjectFactory.createNewRoom(15, "Suite"));

        IDatabaseRetriever dbRetriever = ObjectFactory.createDatabaseRetriever();

        
        HashSet<Booking> bookings = dbRetriever.getAllBookings();
        for(Booking b: bookings){
            System.out.println(b);
        }
        
        HashSet<Room> room = dbRetriever.getAllRooms();
        for(Room r: room){
            System.out.println(r);
        }
        
        HashSet<Staff> staff = dbRetriever.getAllStaff();
        for(Staff s: staff){
            System.out.println(s);
        }
        */
        /*
        ModelManager mManager = new ModelManager();
        IDatabaseRetriever dbRetriever = ObjectFactory.createDatabaseRetriever();
        Session session = DatabaseManager.getSession();
        Transaction tx = session.beginTransaction();
        Staff retrieved = mManager.findStaff("John");
        System.out.println(retrieved);
        session.delete(retrieved);
        tx.commit();
        
        IDatabaseRetriever dbRetriever = ObjectFactory.createDatabaseRetriever();

        
        HashSet<Booking> bookings = dbRetriever.getAllBookings();
        for(Booking b: bookings){
            System.out.println(b);
        }
        
        HashSet<Room> room = dbRetriever.getAllRooms();
        for(Room r: room){
            System.out.println(r);
        }
        
        HashSet<Staff> staff = dbRetriever.getAllStaff();
        for(Staff s: staff){
            System.out.println(s);
        }
        
        
       
        
        Customer customer = ObjectFactory.createCustomer("John", "john@gmail.com", "9793893");
        session.saveOrUpdate(customer);
        session.flush();
                
        Query query = session.createQuery("FROM Person p");
        List<Person> result = query.list();
        HashSet<Person> persons = new HashSet<>(result);
        for(Person p: persons){
            System.out.println(p);
        }
        
        HashSet<Room> rooms = dbRetriever.getAllRooms();
        for(Room r: rooms){
            System.out.println(r);
        }
        
        Booking booking = new Booking("this",customer , mManager.getRoomByID(1), ObjectFactory.createDate(10, 10, 2023),ObjectFactory.createDate(12, 10, 2023));
        System.out.println(booking.getRoom());
        session.saveOrUpdate(booking);
        tx.commit();
        
        
        HashSet<Booking> bookings = dbRetriever.getAllBookings();
        for(Booking b: bookings){
            System.out.println(b);
        }
         
        ModelManager mManager = new ModelManager();
        IDatabaseRetriever dbRetriever = ObjectFactory.createDatabaseRetriever();
        Session session = DatabaseManager.getSession();
        Transaction tx = session.beginTransaction();
        
        String hql1 = "DELETE FROM Booking b";
        Query query = session.createQuery(hql1);
        query.executeUpdate();
        
        String hql = "DELETE FROM Person";
        query = session.createQuery(hql);
        query.executeUpdate();

        tx.commit();
        session.close();
        
        Customer customer = ObjectFactory.createCustomer("John", "john@gmail.com", "9793893");
        session.save(customer);
        tx.commit();
        
        Room room = mManager.getRoomByID(1);
        
        Booking booking = new Booking("this",customer , room, ObjectFactory.createDate(10, 10, 2023),ObjectFactory.createDate(12, 10, 2023));
        session.save(booking);
        tx.commit();
        
        HashSet<Booking> bookings = dbRetriever.getAllBookings();
        for(Booking b: bookings){
            System.out.println(b);
        }
        
        DatabaseManager.closeSession(session);
        session = DatabaseManager.getSession();
        tx = session.beginTransaction();
        
        session.delete(booking);
        session.delete(customer);
        tx.commit();
        DatabaseManager.closeSession(session);
        
        
        
        Staff staff = ObjectFactory.createStaff("Admin", "admin", "password");
        session.save(staff);
        
        Customer customer = ObjectFactory.createCustomer("John", "john@gmail.com", "9793893");
        session.save(customer);
        tx.commit();
        
        Query query = session.createQuery("FROM Customer c WHERE c.customerID = 2");
        Customer customer = (Customer) query.uniqueResult();
        
        ModelManager mManager = new ModelManager();
        Room room = mManager.getRoomByID(1);
        
        Booking booking = new Booking("this", customer, room, ObjectFactory.createDate(10, 10, 2023),ObjectFactory.createDate(12, 10, 2023));
        session.save(booking);
        tx.commit();
        */
        
        
        IDatabaseRetriever dbRetriever = ObjectFactory.createDatabaseRetriever();
        Session session = DatabaseManager.getSession();
        Transaction tx = session.beginTransaction();
        
        HashSet<Booking> bookings = dbRetriever.getAllBookings();
        for(Booking b: bookings){
            System.out.println(b);

        }

        HashSet<Room> rooms = dbRetriever.getAllRooms();
        for(Room r: rooms){
            System.out.println(r);
        }
        
        HashSet<Staff> staffs = dbRetriever.getAllStaff();
        for(Staff s: staffs){
            System.out.println(s);
        }
        
        Query query = session.createQuery("FROM Customer c");
        List<Customer> result = query.list();
        HashSet<Customer> customers = new HashSet<>(result);
        for(Customer c: customers){
            System.out.println(c);
        }
        DatabaseManager.closeSession(session);
    }  
}
