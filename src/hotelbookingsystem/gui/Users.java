/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import javax.persistence.Column;

/**
 *
 * @author berri
 */
public class Users extends Person{
      @Column(name = "password")
    private String password;

    public Users(String password, String name) {
        super(name);
        this.password = password;
    }
    
    public Users() {
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
