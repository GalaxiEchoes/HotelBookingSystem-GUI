/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import hibernateutils.HibernateUtils;


/**
 *
 * @author mgk3508
 */
public class DatabaseUpdater implements IDatabaseUpdater{
    private final DatabaseManager dbManager;
    private final Connection conn;
    private Statement statement;
    private SessionFactory sessionFactory;

    public DatabaseUpdater() {
        dbManager = DatabaseManager.getDBInstance();
        conn = dbManager.getConnection();
        if (conn == null) {
            System.err.println("Failed to establish a connection to the database.");
            System.exit(1);
        }
        try {
            this.statement = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }
    
    public void deleteBooking(Booking booking){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
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
        session.close();
    }
    
    public void addBooking(Booking booking, boolean saveCustomer ){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

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
    }
    
    public void updateBooking(Booking oldBooking, Booking newBooking){
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE Booking SET roomID = ?, startDate = ?, endDate = ?, person = ?, guests = ? WHERE name = ? AND startDate = ? AND endDate = ?");
            pstmt.setString(1, Integer.toString(newBooking.getRoom().getRoomID()));
            pstmt.setDate(2, new Date(newBooking.getStartDate().getTime()));
            pstmt.setDate(3, new Date(newBooking.getEndDate().getTime()));
            pstmt.setString(4, newBooking.getCustomer().getName());
            pstmt.setString(5, newBooking.getGuestNotes());
            
            pstmt.setString(6, oldBooking.getCustomer().getName());
            pstmt.setDate(7, new Date(oldBooking.getStartDate().getTime()));
            pstmt.setDate(8, new Date(oldBooking.getEndDate().getTime()));
            
            pstmt.executeUpdate();
            
            pstmt = conn.prepareStatement("UPDATE Booking SET name = ?, email = ?, phone = ? WHERE name = ? AND email = ? AND phone = ?");
            pstmt.setString(1, newBooking.getCustomer().getName());
            pstmt.setString(2, ((Customer) newBooking.getCustomer()).getEmail());
            pstmt.setString(3, ((Customer)newBooking.getCustomer()).getPhoneNumber());
            
            pstmt.setString(4, oldBooking.getCustomer().getName());
            pstmt.setString(5, ((Customer)oldBooking.getCustomer()).getEmail());
            pstmt.setString(6, ((Customer)oldBooking.getCustomer()).getPhoneNumber());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //double check that the names match???
    private void initializeDatabase(){
        try {
            if(this.tableExsists("BOOKING") == false){
                statement.executeUpdate("CREATE TABLE BOOKINGS (ROOMID INT, STARTDATE DATE , ENDDATE DATE, PERSON VARCHAR(20), GUESTS VARCHAR(150) )");
            }
            if(this.tableExsists("ROOM") == false){
                statement.executeUpdate("CREATE TABLE ROOMS (ROOMID INT, SIZE VARCHAR(20), PRICE FLOAT)");
                
                //Inserting rooms into database
                statement.executeUpdate("INSERT INTO ROOMS VALUES (1, 'Single', 75.60),"
                        + "(2, 'Single', 75.60),"
                        + "(3, 'Single', 75.60),"
                        + "(4, 'Single', 75.60),"
                        + "(5, 'Single', 75.60),"
                        + "(6, 'Double', 98.20),"
                        + "(7, 'Double', 98.20),"
                        + "(8, 'Double', 98.20),"
                        + "(9, 'Double', 98.20),"
                        + "(10, 'Double', 98.20),"
                        + "(11, 'Suite', 129.00),"
                        + "(12, 'Suite', 129.00),"
                        + "(13, 'Suite', 129.00),"
                        + "(14, 'Suite', 129.00),"
                        + "(15, 'Suite', 129.00)");
            }
            if(this.tableExsists("PERSON") == false){
                statement.executeUpdate("CREATE TABLE PERSONS (NAME VARCHAR(20), EMAIL VARCHAR(20), PHONE VARCHAR(20))");
            }
            if(this.tableExsists("ADMIN") == false){
                statement.executeUpdate("CREATE TABLE ADMINS (USERNAME VARCHAR(20), PASSWORD VARCHAR(20))");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean tableExsists(String tableName){
        boolean exsists = false;
         try {
            DatabaseMetaData databaseMetadata = conn.getMetaData();
            ResultSet rs = databaseMetadata.getTables(null, null, tableName, null);
            
            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                if(table_name.equalsIgnoreCase(tableName))
                {
                    exsists = true;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return exsists;
    }
    
    public void closeConnection(){
        this.dbManager.closeConnections();
    }
}
