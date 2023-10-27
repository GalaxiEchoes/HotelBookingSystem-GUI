/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.util.HashSet;
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
        */
        
        ModelManager mManager = new ModelManager();
        Session session = DatabaseManager.getSession();
        Transaction tx = session.beginTransaction();
        Customer customer = ObjectFactory.createCustomer("John", "john@gmail.com", "9793893");
        session.save(customer);
        session.flush();

        Booking booking = new Booking("this",customer , mManager.getRoomByID(1), ObjectFactory.createDate(10, 10, 2023),ObjectFactory.createDate(12, 10, 2023));
        System.out.println(booking.getRoom());
        session.saveOrUpdate(booking);
        tx.commit();
        
        IDatabaseRetriever dbRetriever = ObjectFactory.createDatabaseRetriever();
        
        HashSet<Booking> bookings = dbRetriever.getAllBookings();
        for(Booking b: bookings){
            System.out.println(b);
        }
    }  
}
