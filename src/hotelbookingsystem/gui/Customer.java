package hotelbookingsystem.gui;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class Customer extends Person{

    private String email;
    private String phoneNumber;

    public Customer(String name, String email, String phoneNumber) {
        super(name);
        this.email = email;
        this.phoneNumber = phoneNumber;
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
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @param name - String name of Customer
     */
    @Override
    public void setName(String name) {
        this.name = name;
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
