package hotelbookingsystem.gui;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@DiscriminatorValue("Suite")
public class Suite extends Room {

    public Suite(int roomID) {
        super(roomID, 129.00);
    }

    public Suite() {
    }

    /**
     * {@inheritDoc}
     * @return String representation for a large room
     */
    @Override
    public String toString() {
        return "Room ID: " + getRoomID() + " Size: " + getSize() + " Price: $" + getPrice();
    }
    
    @Override
    public String getSize() {
        return "Suite";
    }
}
