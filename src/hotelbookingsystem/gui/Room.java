package hotelbookingsystem.gui;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "roomSize")
@Table(name = "Rooms")
abstract public class Room implements Serializable {
    
    @Id
    @Column(name = "room_id")
    protected int roomID;
    
    @Column(name = "roomSize")
    protected String roomSize;
    
    @Column(name = "price")
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
        return this.roomSize;
    }

    /**
     * @return price
     */
    public double getPrice() {
        return this.price;
    }
    
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    public void setPrice(double price) {
        this.price = price;
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
