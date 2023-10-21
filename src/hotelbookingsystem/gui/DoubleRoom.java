package hotelbookingsystem.gui;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class DoubleRoom extends Room {

    public DoubleRoom(int roomID) {
        this.roomID = roomID;
        this.size = "M";
        this.price = 98.20;
    }

    /**
     * @return roomID
     */
    @Override
    public int getRoomID() {
        return this.roomID;
    }

    /**
     * @return size
     */
    @Override
    public String getSize() {
        return this.size;
    }

    /**
     * @return price
     */
    @Override
    public double getPrice() {
        return this.price;
    }

    /**
     * @param price - price of medium room
     */
    public void setPrice(double price) {
        this.price = price;
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
