/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

/**
 *
 * @author jenni
 */
public class LogInManager {
    
    
    public LogInManager(){
        
    }
      /*
    old Login stuff from admin
      **
     * This first validates the old password to login, then sets new password if successful
     * 
     * @param oldPassword - String password to log in
     * @param newPassword - String new password to log in
     * @return true if change successful, false otherwise
     *//*
    public boolean setPassword(String oldPassword, String newPassword) {
        if(this.login(oldPassword)){
            this.password = newPassword;
            return true;
        }
        return false;
    }*/
    
     /**
     * Checks if user input matches password in file
     * 
     * @param aAdmin
     * @param password - String password used to login
     * @param username
     * @return true if logged in, false if wrong password
     */
    public boolean checkLogin(Admin aAdmin, String password, String username) {
        if(password.equalsIgnoreCase(aAdmin.getPassword()) && username.equalsIgnoreCase(aAdmin.getName())) {
            return true;
        }/*else if (password.equalsIgnoreCase(user.getPassword()) && username.equalsIgnoreCase(user.getName())){
            return true;
        }*/
        return false;
    }

    
}
