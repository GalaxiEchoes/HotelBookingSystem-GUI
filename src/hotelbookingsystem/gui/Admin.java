package hotelbookingsystem.gui;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@DiscriminatorValue("Admin")
public class Admin extends Staff {

    public Admin(String name, String password ) {
        super(name, password);
    }
    
    public Admin() {
    }
    
    /**
     * Indicates whether account has permission to create other accounts
     * @return Boolean true
     */
    @Override
    public boolean hasPermissions(){
        return true;
    }
}
