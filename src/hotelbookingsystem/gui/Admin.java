/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 */
public class Admin extends Person {
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
