package hotelbookingsystem.gui;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class ModelManager {
    private final IDatabaseRetriever dbRetriever;
    private final IDatabaseUpdater dbUpdater;
    private final HashSet<Room> allRooms;

    public ModelManager(){
        dbRetriever = ObjectFactory.createDatabaseRetriever();
        dbUpdater = ObjectFactory.createDatabaseUpdater();
        
        allRooms = dbRetriever.getAllRooms();
    }
    
    /**
     * Returns all rooms available for the time period (inclusive)
     * @param startDate - Date to start searching from (inclusive)
     * @param endDate - Date to end searching (inclusive)
     * @return HashSet of rooms that are available
     */
    public HashSet<Room> findAvailableRooms(Date startDate, Date endDate){
        HashSet<Room> availableRooms = new HashSet<>(allRooms);
        HashSet<Booking> allBookings = dbRetriever.findBookingBetweenDates(startDate, endDate);
        
        for(Booking current: allBookings){
            availableRooms.remove(current.getRoom());
        }

        return availableRooms;
    }
    
    /**
     * Returns the room object corresponding to the RoomID
     * @param roomID - int id of room
     * @return Room or null if it does not exist
     */
    public Room getRoomByID(int roomID){
        for(Room current: allRooms){
            if(current.getRoomID() == roomID){
                return current;
            }
        }
        
        return null;
    }
    
    /**
     * Saves a new Booking to the database
     * @param booking - Booking to be saved 
     */
    public void saveNewBooking(Booking booking){
        if(booking.getBookingID() == 0){
            Customer customer = dbRetriever.getExsistingCustomer(booking);
        
            //Synchonises customer if customer matches previous database entry
            if(customer != null){
                booking.setCustomer(customer);
            }
        
            dbUpdater.addBooking(booking);
        }
    }
    
    /**
     * Updates the database info for the booking if the id is not default 0
     * @param booking - Booking to be updated
     */
    public void updateBooking(Booking booking){
        if(booking.getBookingID() != 0){
            dbUpdater.updateBooking(booking);
        }
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
     * @return Staff object or null if it does not exist in database
     */
    public Staff findStaff(String username){
        Staff staff = dbRetriever.findStaff(username); 
        
        return staff;
    }
    
    /**         
     * Saves new Admin or User account to database
     * @param newStaff - account to be saved
     * @return true if successful, false if
     */
    public boolean saveNewStaff(Staff newStaff){
        boolean result = dbUpdater.saveNewStaff(newStaff);
        return result;
    }
    
    /**
     * @param criteria - Booking object that contains search specifications 
     * @return HashSet of bookings that match the criteria
     */
    public HashSet<Booking> findBooking(Booking criteria){
        HashSet<Booking> bookings = dbRetriever.findBookingBetweenDates(criteria.getStartDate(), criteria.getEndDate());

        bookings.removeIf(booking -> 
            (criteria.getBookingID() != 0 && criteria.getBookingID() != booking.getBookingID()) ||
            (criteria.getRoom() != null && criteria.getRoom().getRoomID() != booking.getRoom().getRoomID()) ||
            (criteria.getCustomer() != null && 
                (criteria.getCustomer().getName() != null && !criteria.getCustomer().getName().isEmpty() && !criteria.getCustomer().getName().equalsIgnoreCase(booking.getCustomer().getName())) ||
                (criteria.getCustomer().getEmail() != null && !criteria.getCustomer().getEmail().isEmpty() && !criteria.getCustomer().getEmail().equalsIgnoreCase(booking.getCustomer().getEmail())) ||
                (criteria.getCustomer().getPhoneNumber() != null && !criteria.getCustomer().getPhoneNumber().isEmpty() && !criteria.getCustomer().getPhoneNumber().equalsIgnoreCase(booking.getCustomer().getPhoneNumber())))
        );

        return bookings;
    }
    
    /**
     * @param bookingId - int Id of the Booking
     * @return Booking that matches the bookingId
     */
    public Booking findBookingById(int bookingId){
        Booking booking = dbRetriever.findBookingById(bookingId);
        
        return booking;
    }
    
    /**
     * This calculates the total price and saves or updates
     * @param booking 
     */
    public void invoiceBooking(Booking booking){
        // Convert Date objects to LocalDate objects
        LocalDate localStartDate = booking.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localEndDate = booking.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calculate difference in days
        long daysBetween = ChronoUnit.DAYS.between(localStartDate, localEndDate) + 1;
        
        booking.setTotal((float) (daysBetween * booking.getRoom().getPrice()));
        
        if(booking.getBookingID() == 0){
            dbUpdater.addBooking(booking);
        } else{
            dbUpdater.updateBooking(booking);
        }  
    }
    
    /**
     * Converts a date into its individual integers
     * @param date - Date to be converted
     * @return int array with day, month, year as int's
     */
   /* public int[] convertDateToIntArray(Date date){
        int[] timeArray = new int[3];
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Extract the day, month, and year from the calendar
        timeArray[0]= calendar.get(Calendar.DAY_OF_MONTH);
        timeArray[1]= calendar.get(Calendar.MONTH) + 1; 
        timeArray[2]= calendar.get(Calendar.YEAR);
        return timeArray;
    }*/
    
    /**
     * Retrieves all booking from database
     * @return HashSet of bookings
     */
    public HashSet<Booking> getAllBookings(){
        return dbRetriever.getAllBookings();
    }
    
    /**
     * @return HashSet of rooms
     */
    public HashSet<Room> getAllRooms(){
        return this.allRooms;
    }
}
