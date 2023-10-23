/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
@Entity
@Table(name = "Admins")
public class Admin extends Person {
    
    @Column(name = "password")
    private String password;

    public Admin(String password, String name) {
        super(name);
        this.password = password;
    }
    
    public Admin() {
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

}
