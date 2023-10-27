package hotelbookingsystem.gui;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
public class Customer extends Person{

    @Column(name = "email")
    private String email;
    
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Customer(String name, String email, String phoneNumber) {
        super(name);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    public Customer() {
    }

    /**
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email - String email of Customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * @param phoneNumber - String phone number of Customer
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * {@inheritDoc}
     * @return String representation of Customer 
     */
    @Override
    public String toString() {
        return this.name + " Email: " + this.email + " Phone: " + this.phoneNumber ;
    }
}
