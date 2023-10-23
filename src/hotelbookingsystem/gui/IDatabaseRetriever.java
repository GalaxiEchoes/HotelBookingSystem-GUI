package hotelbookingsystem.gui;

import java.util.HashSet;

/**
 *
 * @author mgk3508
 */
public interface IDatabaseRetriever {
    public HashSet<Room> getAllRooms();
    public HashSet<Person> getAllAdmins();
    public HashSet<Booking> getAllBookings();
    public Person getExsistingCustomer(Booking booking);
}
