package hotelbookingsystem.gui;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "roomSize")
@Table(name = "Room")
abstract public class Room implements Serializable {
    
    @Id
    @Column(name = "room_id")
    protected int roomID;
    
    @Column(name = "price")
    protected double price;
    
    public Room(int roomID, double price){
        this.roomID = roomID;
        this.price = price;
    }

    public Room() {
    }

    /**
     * @return roomID
     */
    public int getRoomID() {
        return this.roomID;
    }
    
    /**
     * @param roomID - ID number of the room
     */
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    /**
     * @return String representation of the room size
     */
    public abstract String getSize();

    /**
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @param price - price of the room
     */
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
