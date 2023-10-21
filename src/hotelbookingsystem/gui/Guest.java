package hotelbookingsystem.gui;

//import hotelbookingsystem.gui.Person;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class Guest extends Person{

    public Guest(String name) {
        super(name);
    }
    
    /**
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }
    
    /**
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     * @return String representation of Guest 
     */
    @Override
    public String toString() {
        return "Guest: " + this.name;
    }
}
