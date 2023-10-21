package hotelbookingsystem.gui;

import java.io.Serializable;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
abstract public class Room implements Serializable{

    protected int roomID;
    protected String size;
    protected double price;

    /**
     * @return roomID
     */
    public int getRoomID() {
        return this.roomID;
    }

    /**
     * @return size
     */
    public String getSize() {
        return this.size;
    }

    /**
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * {@inheritDoc}
     * @return String representation for a room 
     */
    @Override
    public String toString() {
        return "Room ID: " + getRoomID() + " Size: " + getSize() + " Price: $" + getPrice();
    }

    /**
     * {@inheritDoc}
     * Generates a hash code for the object
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.roomID;
        return hash;
    }

    /**
     * {@inheritDoc}
     * Compares Room to obj for equality by comparing roomID's
     * 
     * @param obj - Room object to compare this Room to
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
        final Room other = (Room) obj;
        return this.roomID == other.roomID;
    }

}
