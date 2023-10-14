/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author jenni
 */
public class DatabaseRetriever implements IDatabaseRetriever{
    
    private final DatabaseManager dbManager;
    private final Connection conn;
    private Statement statement;

    public DatabaseRetriever() {
        dbManager = DatabaseManager.getDBInstance();
        conn = dbManager.getConnection();
        if (conn == null) {
            System.err.println("Failed to establish a connection to the database.");
            System.exit(1); // Exit the program if the connection is not established.
        }
    }
    
    public List<Room> getAvailableRooms(){
        
    }
    
    public List<Person> getAdmins(){
        
    }
    
    public List<Booking> getAllBookings(){
        
    }
    
    public void closeConnection(){
        this.dbManager.closeConnections();
    }
}
