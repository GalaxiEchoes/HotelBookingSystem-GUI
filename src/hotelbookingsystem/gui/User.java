package hotelbookingsystem.gui;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@DiscriminatorValue("User")
public class User extends Staff{

    public User(String name, String password) {
        super(name, password);
    }
    
    public User() {
    }

    /**
     * Indicates whether account has permission to create other accounts
     * @return Boolean false
     */
    @Override
    public boolean hasPermissions(){
        return false;
    }
}
