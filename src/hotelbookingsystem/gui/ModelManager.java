package hotelbookingsystem.gui;

import java.util.Date;
import java.util.HashSet;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class ModelManager {
    private final IDatabaseRetriever dbRetriever;
    private final IDatabaseUpdater dbUpdater;

    public ModelManager(){
        dbRetriever = new DatabaseRetriever();
        dbUpdater = new DatabaseUpdater();
    }
    
    /**
     * 
     * @param startDate - Date to start searching from (inclusive)
     * @param endDate - Date to end searching (inclusive)
     * @return HashSet of rooms that are available
     */
    public HashSet<Room> findAvailableRooms(Date startDate, Date endDate){
        //Stub return
        return new HashSet<Room>();
    }
    
    /**
     * Saves a new Booking to the database
     * @param booking - Booking to be saved 
     */
    public void saveNewBooking(Booking booking){
        Customer customer = dbRetriever.getExsistingCustomer(booking);
        Boolean saveCustomer = (customer == null);
        
        //Synchonises customer if customer matches previous database entry
        if(saveCustomer == false){
            booking.setCustomer(customer);
        }
        
        dbUpdater.addBooking(booking, saveCustomer);
    }
    
    /**
     * Updates the database info for the booking
     * @param booking - Booking to be updated
     */
    public void updateBooking(Booking booking){
        dbUpdater.updateBooking(booking);
    }
    
    /**
     * Deletes the booking from database
     * @param booking - Booking to be deleted 
     */
    public void deleteBooking(Booking booking){
        dbUpdater.deleteBooking(booking);
    }
    
    /**
     * Finds Admin or User account with a matching username
     * @param username - username to be matched
     * @return Person object or null if it does not exist in database
     */
    public Person findStaff(String username){
        Person staff = dbRetriever.findStaff(username); 
        
        return staff;
    }
    
    /**
     * Saves new Admin or User account to database
     * @param newStaff - account to be saved
     */
    public void saveNewStaff(Person newStaff){
        dbUpdater.saveNewStaff(newStaff);
    }
    
    /**
     * @param criteria - Booking object that contains search specifications 
     * @return HashSet of bookings that match the criteria
     */
    public HashSet<Booking> findBooking(Booking criteria){
        //Stub return
        return new HashSet<Booking>();
    }
}
