package hotelbookingsystem.gui;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@DiscriminatorValue("User")
public class User extends Staff{
    
    @Column(name = "password")
    private String password;

    public User(String name, String password) {
        super(name);
        this.password = password;
    }
    
    public User() {
    }
    
    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password - password of admin 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Indicates whether account has permission to create other accounts
     * @return Boolean false
     */
    public boolean hasPermissions(){
        return false;
    }
}
