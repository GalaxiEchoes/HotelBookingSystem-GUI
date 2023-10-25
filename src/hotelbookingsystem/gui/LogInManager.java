package hotelbookingsystem.gui;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger:
 * 21151229)
 */
public class LogInManager {

    public LogInManager() {

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
    public boolean checkLogin(Staff staff, String password, String username) {
        if (staff.name.equals(username) && staff.password.equals(password)) {
            return true;
        }
        return false;
    }

    public boolean checkAdmin(Staff user) {
        if (user instanceof Admin) {
            if (user.hasPermissions()) {
                return true;
            }
            return false;
        }
        return false;
    }
}
