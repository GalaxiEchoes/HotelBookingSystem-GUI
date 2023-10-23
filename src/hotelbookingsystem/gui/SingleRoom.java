package hotelbookingsystem.gui;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@DiscriminatorValue("Single")
public class SingleRoom extends Room{

    public SingleRoom(int roomID) {
        super(roomID, 75.60);
    }

    public SingleRoom() {
    }

    /**
     * {@inheritDoc}
     * @return String representation for a small room
     */
    @Override
    public String toString() {
        return "Room ID: " + getRoomID() + " Size: " + getSize() + " Price: $" + getPrice();
    }
    
    @Override
    public String getSize() {
        return "Single";
    }
}
