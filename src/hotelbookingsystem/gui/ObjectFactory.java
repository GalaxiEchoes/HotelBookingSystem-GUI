package hotelbookingsystem.gui;

import java.util.Calendar;
import java.util.Date;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class ObjectFactory {
    
    public static Person createStaff(String type, String name, String password){
        if("Admin".equalsIgnoreCase(type)){
            return new Admin(name, password);
        } else if("User".equalsIgnoreCase(type)){
            return new User(name, password);
        }
        return null;
    }
    
    public static Customer createCustomer(String name, String email, String phoneNumber){
        return new Customer(name, email, phoneNumber);
    } 
    
    public static IDatabaseRetriever createDatabaseRetriever() {
        return new DatabaseRetriever();
    }
    
    public static IDatabaseUpdater createDatabaseUpdater() {
        return new DatabaseUpdater();
    }
    
    public static Room createNewRoom(int roomID, String roomSize){
        if("Suite".equalsIgnoreCase(roomSize)){
            return new Suite(roomID); 
        } else if ("Double".equalsIgnoreCase(roomSize)){
            return new DoubleRoom(roomID);  
        } else if ("Single".equalsIgnoreCase(roomSize)){
            return new SingleRoom(roomID);
        }
        
        return null;
    }
    
    /**
     * This returns a date object 
     * @param day - int day
     * @param month - int month 1-12
     * @param year - int year
     */
    public static Date createDate(int day, int month, int year){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        
        return date;
    }
}