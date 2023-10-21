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

    /**
     * This first validates the old password to login, then sets new password if successful
     * 
     * @param oldPassword - String password to log in
     * @param newPassword - String new password to log in
     * @return true if change successful, false otherwise
     */
    public boolean setPassword(String oldPassword, String newPassword) {
        if(this.login(oldPassword)){
            this.password = newPassword;
            return true;
        }
        return false;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - username of admin 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Checks if user input matches password in file
     * 
     * @param password - String password used to login
     * @return true if logged in, false if wrong password
     */
    public boolean login(String password) {
        if(this.password.contentEquals(password)) {
            return true;
        }
        return false;
    }

}
