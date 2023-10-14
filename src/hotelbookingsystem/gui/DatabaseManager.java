/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jenni
 */
public class DatabaseManager {
    private static final String USER_NAME = "pdc"; //your DB username
    private static final String PASSWORD = "pdc"; //your DB password
    private static final String URL = "jdbc:derby:HotelBookingSystemDB_Ebd; create=true";  //url of the DB host
    
    private Connection conn;
    private static DatabaseManager dbmanager;

    private DatabaseManager() {
        establishConnection();
    }
    
    public static synchronized DatabaseManager getDBInstance(){
        if(dbmanager == null){
           dbmanager = new DatabaseManager();
       } 
       return dbmanager;
    }
    
    public static void main(String[] args) {
        DatabaseManager dbManager = getDBInstance();
        System.out.println(dbManager.getConnection());
    }
    
    public Connection getConnection() {
        return this.conn;
    }
    
        //Establish connection
    public void establishConnection() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " Get Connected Successfully ....");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
