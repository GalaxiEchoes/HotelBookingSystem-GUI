package hotelbookingsystem.gui;

/**
 *
 * @author mgk3508
 */
public class ModelManager {
    private final IDatabaseRetriever dbRetriever;
    private final IDatabaseUpdater dbUpdater;
    

    
    public ModelManager(){
        dbRetriever = new DatabaseRetriever();
        dbUpdater = new DatabaseUpdater();
    }
    
    /*
    public HashSet<Room> getAvailableRooms(Date startDate, Date endDate){
        
    }
    
    public HashSet<Booking> getBooking(String name, int roomID, ){
        
    }
    
    public HashSet<Person> getAdmin(String name){
        
    }
    
    public void updateBooking(){
        
    }
    */
}
