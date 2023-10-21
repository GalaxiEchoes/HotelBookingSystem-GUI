package hotelbookingsystem.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger:
 * 21151229)
 */
public class Booking implements Serializable {

    private String guestList;
    private Person customer;
    private Room room;
    private Date startDate;
    private Date endDate;
    private float total;
    private int bookingID;

    public Booking(String guestList, Person customer, Room room, Date startDate, Date endDate, int bookingID) {
        this.customer = customer;
        this.room = room;
        this.guestList = guestList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = 0.0f;
        this.bookingID = bookingID;

    }

    /**
     * This adds a person to the Guest ArrayList
     *
     * @param e - Guest Person to be added
     */
    public void addGuest(Person e) {
        guestList.add(e);
    }

    /**
     * This removes a Guest from the Guest ArrayList
     *
     * @param guestName - String name of the Guest
     * @return 0 if successful and 1 for if there is a error
     */
    public int removeGuest(String guestName) {
        for (Person e : guestList) {
            if (e.getName().toLowerCase().equals(guestName.toLowerCase())) {
                guestList;
                return 0;
            }
        }
        return 1;
    }

    /**
     * @return room
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * @return customer
     */
    public Person getCustomer() {
        return this.customer;
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
