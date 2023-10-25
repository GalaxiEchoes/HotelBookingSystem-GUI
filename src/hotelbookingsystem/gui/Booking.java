package hotelbookingsystem.gui;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@Table(name = "Bookings")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingID;
    
    @Column(name = "guest_notes")
    private String guestNotes;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    
    @Column(name = "total")
    private float total;

    public Booking(String guestList, Customer customer, Room room, Date startDate, Date endDate) {
        this.customer = customer;
        this.room = room;
        this.guestNotes = guestList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = 0.0f;
    }

    public Booking() {
    }
    
    /**
     * @return room
     */
    public Room getRoom() {
        return this.room;
    }
    
    /**
     * @param room - Room object for booking
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * @return customer
     */
    public Customer getCustomer() {
        return this.customer;
    }
    
    /**
     * @param customer - CUstomer object for booking
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the BookingID of the booking
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     * @param bookingID - ID of the booking 
     */
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    /**
     * @return guestNotes of the booking
     */
    public String getGuestNotes() {
        return guestNotes;
    }

    /**
     * @param guestNotes - String of notes about guests or other specifications of the booking
     */
    public void setGuestNotes(String guestNotes) {
        this.guestNotes = guestNotes;
    }

    /**
     * @return start date of the booking
     */
    public Date getStartDate() {
        return startDate;
    }
    
    /**
     * @return string representation of the booking startDate 
     */
    public String getStringStartDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(startDate);
        return formattedDate;
    }

    /**
     * This sets the start date object of the booking
     * @param day - int day
     * @param month - int month 1-12
     * @param year - int year
     */
    public void setStartDate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        startDate = calendar.getTime();
    }

    /**
     * @return end date of the booking
     */
    public Date getEndDate() {
        return endDate;
    }
    
    /**
     * @return string representation of the booking endDate 
     */
    public String getStringEndDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(endDate);
        return formattedDate;
    }

    /**
     * This sets the end date object of the booking
     * @param day - int day
     * @param month - int month 1-12
     * @param year - int year
     */
    public void setEndDate(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        endDate = calendar.getTime();
    }

    /**
     * @return total price of the booking
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total - total price of the booking 
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * {@inheritDoc} Generates a hash code for the Booking
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.room);
        return hash;
    }

    /**
     * {@inheritDoc} Compares booking to obj for equality by comparing rooms
     *
     * @param obj - Booking object to compare this booking to
     * @return true if equal and false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Booking other = (Booking) obj;
        return Objects.equals(this.room, other.room);
    }

    /**
     * {@inheritDoc}
     *
     * @return String representation of booking
     */
    @Override
    public String toString() {
        return "\n    Booking: " + this.customer + ", room: " + this.room;
    }
}
