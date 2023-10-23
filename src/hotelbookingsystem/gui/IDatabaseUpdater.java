package hotelbookingsystem.gui;

/**
 *
 * @author mgk3508
 */
public interface IDatabaseUpdater {
    public void deleteBooking(Booking booking);
    public void addBooking(Booking booking, boolean saveCustomer );
    public void updateBooking(Booking changedBooking);
}
