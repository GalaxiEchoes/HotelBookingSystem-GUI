package hotelbookingsystem.gui;

import java.util.Date;
import java.util.HashSet;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public interface IDatabaseRetriever {
    public HashSet<Room> getAllRooms();
    public HashSet<Person> getAllPersons();
    public HashSet<Booking> getAllBookings();
    public Customer getExsistingCustomer(Booking booking);
    public Person findStaff(String username);
    public HashSet<Booking> findBookingBetweenDates(Date startDate, Date endDate);
}
