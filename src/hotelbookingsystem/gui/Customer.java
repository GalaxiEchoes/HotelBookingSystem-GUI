package hotelbookingsystem.gui;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@Table(name = "Customer")
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    protected int customerID;
    
    @Column(name = "name")
    protected String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    public Customer() {
    }

    /**
     * @return name  
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name - String name of customer
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * @return customerID  
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * @param customerID - int ID of customer
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.customerID;
        hash = 13 * hash + Objects.hashCode(this.name);
        return hash;
    }

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
        final Customer other = (Customer) obj;
        if (this.customerID != other.customerID) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    /**
     * {@inheritDoc}
     * @return String representation of Customer 
     */
    @Override
    public String toString() {
        return "ID: " + this.customerID +" "+ this.name + " Email: " + this.email + " Phone: " + this.phoneNumber ;
    }
}
