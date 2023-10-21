package hotelbookingsystem.gui;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class Suite extends Room {

    public Suite(int roomID) {
        this.roomID = roomID;
        this.size = "L";
        this.price = 129.00;
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
     * @param price - price of large room
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * {@inheritDoc}
     * @return String representation for a large room
     */
    @Override
    public String toString() {
        return "Room ID: " + getRoomID() + " Size: " + getSize() + " Price: $" + getPrice();
    }

}
