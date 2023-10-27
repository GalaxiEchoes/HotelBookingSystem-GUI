package hotelbookingsystem.gui;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger:
 * 21151229)
 */
public class LogInManager {

    public LogInManager() {

    }

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

    /**
     * Checks if Staff has admin permissions
     * @param user - Staff object
     * @return - True if staff has permission, false if not
     */
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
