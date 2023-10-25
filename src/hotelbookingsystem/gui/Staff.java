/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@DiscriminatorColumn(name = "person_type")
abstract public class Staff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    protected int personId;
    
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
     * @param name - String name of person
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * @return personId  
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * @param personId - int ID of person
     */
    public void setPersonId(int personId) {
        this.personId = personId;
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