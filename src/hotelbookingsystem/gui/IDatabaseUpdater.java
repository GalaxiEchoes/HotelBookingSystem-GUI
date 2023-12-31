package hotelbookingsystem.gui;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public interface IDatabaseUpdater {
    public void deleteBooking(Booking booking);
    public void addBooking(Booking booking);
    public void updateBooking(Booking changedBooking);
    public boolean saveNewStaff(Staff newStaff);
    public void saveNewRoom(Room room);
}
