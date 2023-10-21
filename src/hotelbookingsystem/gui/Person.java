package hotelbookingsystem.gui;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
abstract public class Person implements Serializable {

    protected String name;
    
    public Person(String name) {
        this.name = name;
    }

    /**
     * @return name  
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name - String name of person
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     * Generates a hash code for the object
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     * {@inheritDoc}
     * Compares Person to obj for equality by comparing names
     * 
     * @param obj - Person object to compare this Person to
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
        final Person other = (Person) obj;
        return Objects.equals(this.name, other.name);
    }

}
