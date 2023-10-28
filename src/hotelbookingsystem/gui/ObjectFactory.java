package hotelbookingsystem.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger:
 * 21151229)
 */
public class ObjectFactory {

    /**
     * Creates a Staff object depending on input string
     *
     * @param type - String type of Staff
     * @param name - username of account
     * @param password - password of account
     * @return Staff object
     */
    public static Staff createStaff(String type, String name, String password) {
        if ("Admin".equalsIgnoreCase(type)) {
            return new Admin(name, password);
        } else if ("User".equalsIgnoreCase(type)) {
            return new User(name, password);
        }
        return null;
    }

    /**
     * Creates a customer object
     *
     * @param name - name of customer
     * @param email - email of customer
     * @param phoneNumber - phoneNumber of customer
     * @return Customer
     */
    public static Customer createCustomer(String name, String email, String phoneNumber) {
        return new Customer(name, email, phoneNumber);
    }

    /**
     * Creates a DatabaseRetriever
     *
     * @return DatabaseRetriever object
     */
    public static IDatabaseRetriever createDatabaseRetriever() {
        return new DatabaseRetriever();
    }

    /**
     * Creates a DatabaseUpdater
     *
     * @return DatabaseUpdater object
     */
    public static IDatabaseUpdater createDatabaseUpdater() {
        return new DatabaseUpdater();
    }

    /**
     * creates new room depending on input string
     *
     * @param roomID - ID of room/ room number
     * @param roomSize - size of room as a string
     * @return Room object
     */
    public static Room createNewRoom(int roomID, String roomSize) {
        if ("Suite".equalsIgnoreCase(roomSize)) {
            return new Suite(roomID);
        } else if ("Double".equalsIgnoreCase(roomSize)) {
            return new DoubleRoom(roomID);
        } else if ("Single".equalsIgnoreCase(roomSize)) {
            return new SingleRoom(roomID);
        }

        return null;
    }

    /**
     * This returns a date object
     *
     * @param day - int day
     * @param month - int month 1-12
     * @param year - int year
     */
    public static Date createDate(int day, int month, int year) {
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

    /**
     * Turns a string back into a date
     *
     * @param date - String in the correct date format dd/MM/yyyy
     * @return Date object
     */
    public static Date createDateFromString(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 
     * @param date
     * @return 
     */
    public static int[] convertDateToIntArray(Date date) {
        int[] timeArray = new int[3];

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Extract the day, month, and year from the calendar
        timeArray[0] = calendar.get(Calendar.DAY_OF_MONTH);
        timeArray[1] = calendar.get(Calendar.MONTH) + 1;
        timeArray[2] = calendar.get(Calendar.YEAR);
        return timeArray;
    }
}
