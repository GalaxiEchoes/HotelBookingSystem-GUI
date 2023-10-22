/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import hibernateutils.HibernateUtils;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mgk3508
 */
public class DatabaseRetriever implements IDatabaseRetriever{
    
    private final DatabaseManager dbManager;
    private final Connection conn;
    private Statement statement;
    private SessionFactory sessionFactory;

    public DatabaseRetriever() {
        dbManager = DatabaseManager.getDBInstance();
        conn = dbManager.getConnection();
        if (conn == null) {
            System.err.println("Failed to establish a connection to the database.");
            System.exit(1);
        }
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }
    
    public HashSet<Room> getRooms(){
        HashSet<Room> roomSet = null;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Room> query = session.createQuery("FROM Room", Room.class);
        List<Room> rooms = query.getResultList();
        roomSet = new HashSet<>(rooms);
        session.getTransaction().commit();
        
        return roomSet;
    }
    
    public HashSet<Person> getAdmins(){
        HashSet<Person> adminSet = null;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Admin> query = session.createQuery("FROM Admin", Admin.class);
        List<Admin> admin = query.getResultList();
        adminSet = new HashSet<>(admin);
        session.getTransaction().commit();
        
        return  adminSet;
    }
    
    public Person getExsistingCustomer(Booking booking){
        Session session = sessionFactory.openSession();
   
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Person WHERE email = :email OR phone = :phone");
        query.setParameter("email", ((Customer) booking.getCustomer()).getEmail());
        query.setParameter("phone", ((Customer) booking.getCustomer()).getPhoneNumber());

        List<Person> result = query.list();

        if (result.isEmpty()) {
            tx.rollback();
            return null;
        } else {
            tx.rollback();
            return result.get(0);
        }
    }
    
    public HashSet<Booking> getBookings(){
        HashSet<Booking> bookingSet = null;
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Booking> query = session.createQuery("FROM Booking", Booking.class);
        List<Booking> booking = query.getResultList();
        bookingSet = new HashSet<>(booking);
        session.getTransaction().commit();
        
        return bookingSet;
    }
    
    public void closeConnection(){
        this.dbManager.closeConnections();
    }
}
