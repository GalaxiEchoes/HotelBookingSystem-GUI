package hotelbookingsystem.gui;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger:
 * 21151229)
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
    private Person customer;
    
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

    public Booking(String guestList, Person customer, Room room, Date startDate, Date endDate) {
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
    public Person getCustomer() {
        return this.customer;
    }
    
    /**
     * @param room - Person object for booking
     */
    public void getCustomer(Person customer) {
        this.customer = customer;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getGuestNotes() {
        return guestNotes;
    }

    public void setGuestNotes(String guestNotes) {
        this.guestNotes = guestNotes;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getTotal() {
        return total;
    }

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
