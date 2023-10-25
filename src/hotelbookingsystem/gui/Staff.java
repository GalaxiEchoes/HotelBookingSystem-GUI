package hotelbookingsystem.gui;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@Table(name = "Staff")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "staff_type")
abstract public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "staff_id")
    protected int staffId;
    
    @Column(name = "name")
    protected String name;
    
    public Staff(String name) {
        this.name = name;
    }
    
    public Staff() {
    }

    /**
     * @return name  
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param name - String name of staff
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * @return staffId
     */
    public int getStaffId() {
        return staffId;
    }

    /**
     * @param staffId - int ID of staff
     */
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
    
    /**
     * Indicates whether account has permission to create other accounts
     * @return Boolean true
     */
    abstract public boolean hasPermissions();

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
     * Compares Staff to obj for equality by comparing names
     * 
     * @param obj - Staff object to compare this Staff to
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
        final Staff other = (Staff) obj;
        return Objects.equals(this.name, other.name);
    }
}
