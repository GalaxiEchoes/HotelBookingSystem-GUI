package hotelbookingsystem.gui;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@DiscriminatorValue("Double")
public class DoubleRoom extends Room {

    public DoubleRoom(int roomID) {
        super(roomID, 98.20);
    }

    public DoubleRoom() {
    }
    
    /**
     * @return String representation of the room size
     */
    @Override
    public String getSize() {
        return "Double";
    }
    
    /**
     * {@inheritDoc}
     * @return String representation for a medium room
     */
    @Override
    public String toString() {
        return "Room ID: " + getRoomID() + " Size: " + getSize() + " Price: $" + getPrice();
    }
}
