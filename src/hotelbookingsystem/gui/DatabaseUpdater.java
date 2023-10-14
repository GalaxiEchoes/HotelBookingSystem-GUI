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

/**
 *
 * @author jenni
 */
public class DatabaseUpdater implements IDatabaseUpdater{
    private final DatabaseManager dbManager;
    private final Connection conn;
    private Statement statement;

    public DatabaseUpdater() {
        dbManager = DatabaseManager.getDBInstance();
        conn = dbManager.getConnection();
        if (conn == null) {
            System.err.println("Failed to establish a connection to the database.");
            System.exit(1); // Exit the program if the connection is not established.
        }
        try {
            this.statement = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean deleteBooking(){
        return true;
    }
    
    public boolean addBooking(){
        return true;
    }
    
    public boolean updateBooking(){
        return true;
    }
    
    private void initializeDatabase(){
        try {
            if(this.tableExsists("BOOKING") == false){
                statement.executeUpdate("CREATE TABLE BOOKING (BOOKID INT, TITLE VARCHAR(50), CATEGORY VARCHAR(20), PRICE FLOAT)");
            }
            if(this.tableExsists("BOOKING") == false){
                statement.executeUpdate("CREATE TABLE BOOK (BOOKID INT, TITLE VARCHAR(50), CATEGORY VARCHAR(20), PRICE FLOAT)");
            }
            if(this.tableExsists("BOOKING") == false){
                statement.executeUpdate("CREATE TABLE BOOK (BOOKID INT, TITLE VARCHAR(50), CATEGORY VARCHAR(20), PRICE FLOAT)");
            }
            
            
            statement.executeBatch();
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
