package hotelbookingsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
 *
 */
public class HotelController implements ActionListener {

    /**
     * enum for the different panels
     */
    public enum panelState {
        LoginPanel,
        MenuPanel,
        AdminMenuPanel,
        MakeBookingPanel,
        SearchBookingPanel,
        EditBookingPanel,
        AddStaffPanel,
    }

    public GUIManager GUIManager;
    public ModelManager modelManager;
    public LogInManager liManager;
    public panelState currentPanel;
    boolean adminMode;

    public HotelController() {
        this.modelManager = new ModelManager();
        this.liManager = new LogInManager();
        currentPanel = panelState.LoginPanel;
    }

    public void addView(GUIManager GUIManager) {
        this.GUIManager = GUIManager;
    }

    /**
     * Handle's all the actions to be preformed when buttons are pressed,
     * comboBox changes textField changes or any other changes to components of
     * panels
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if ("Login".equals(actionCommand)) {
            login();

        } else if ("Log Out".equals(actionCommand)) {
            logOut();

        } else if ("Make Booking".equals(actionCommand)) {
            makeBooking();

        } else if ("Search/Edit Booking".equals(actionCommand)) {
            searchBooking();

        } else if ("Add Staff".equals(actionCommand)) {
            addStaff();

        } else if ("Submit User".equals(actionCommand)) {
            submitUser();

        } else if ("Submit Admin".equals(actionCommand)) {
            submitAdmin();

        } else if ("Menu".equals(actionCommand)) {
            menu();

        } else if ("Find Rooms".equals(actionCommand)) {
            findRooms();

        } else if ("Submit".equals(actionCommand)) {
            submit();

        } else if ("Search".equals(actionCommand)) {
            search();

        } else if ("Save Changes".equals(actionCommand)) {
            saveChanges();

        } else if ("Delete".equals(actionCommand)) {
            delete();

        } else if ("Edit".equals(actionCommand)) {
            edit();
        }

    }

    /**
     * Handles what happens when login is pressed depending if the person is a
     * user or admin it switches to different main menu if its a normal user it
     * switches to main Menu if its a admin it switches to admin menu
     */
    private void login() {
        String[] loginInfo = GUIManager.getLogin();
        Staff staff = modelManager.findStaff(loginInfo[0]);

        if (staff != null) {
            if (liManager.checkLogin(staff, loginInfo[1], loginInfo[0])) {
                adminMode = liManager.checkAdmin(staff);
                GUIManager.detatchComponents(currentPanel);
                //Check login details
                if (adminMode == true) {
                    GUIManager.switchToAdminMenu();
                    currentPanel = panelState.AdminMenuPanel;
                } else {
                    GUIManager.switchToMenu();
                    currentPanel = panelState.MenuPanel;
                }
            } else {
                GUIManager.clearAllText();
                GUIManager.userIncorrectInputWarning("Incorrect Username or Password, please check Report.");

            }
        } else {
            GUIManager.clearAllText();
            GUIManager.userIncorrectInputWarning("Incorrect Username or Password, please check Report.");

        }

    }

    /**
     * Handles what happens when logout is pressed switches to the loginPanel
     */
    public void logOut() {
        GUIManager.detatchComponents(currentPanel);
        GUIManager.switchToLogin();
        currentPanel = panelState.LoginPanel;
    }

    /**
     * switches to the addStaffPanel
     */
    private void addStaff() {
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.AddStaffPanel;
        GUIManager.switchToAddStaff();
    }

    /**
     * finds all available rooms for the specified dates
     */
    private void findRooms() {
        Booking booking = GUIManager.getBooking();

        if (booking == null) {
            GUIManager.userIncorrectInputWarning("Start date must be before end date, please try again.");
        } else {
            HashSet<Room> rooms = modelManager.findAvailableRooms(booking.getStartDate(), booking.getEndDate());
            GUIManager.showRoomsFound(rooms);
        }
    }

    /**
     * Handles what happens when make booking is pressed switches to
     * makeBookingPanel
     */
    public void makeBooking() {
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.MakeBookingPanel;
        GUIManager.switchToMakeBooking();
    }

    /**
     * Handles what happens when search booking is pressed switches to
     * searchBooking
     */
    public void searchBooking() {
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.SearchBookingPanel;
        HashSet<Room> allRooms = modelManager.getAllRooms();
        GUIManager.switchToSearchBooking(allRooms);
    }

    /**
     *
     * goes to the main menu for type of user that is signed in admins go to
     * admin menu users go to main menu
     */
    public void menu() {
        GUIManager.detatchComponents(currentPanel);
        if (adminMode == true) {
            GUIManager.switchToAdminMenu();
            currentPanel = panelState.AdminMenuPanel;
        } else {
            GUIManager.switchToMenu();
            currentPanel = panelState.MenuPanel;
        }
    }

    /**
     * Handles what happens when submit user is pressed saves the new staff as a
     * user
     */
    private void submitUser() {

        String[] loginInfo = GUIManager.getLogin();
        Staff staff = ObjectFactory.createStaff("User", loginInfo[0], loginInfo[1]);

        if (modelManager.saveNewStaff(staff)) {
            if (adminMode == true) {
                GUIManager.detatchComponents(currentPanel);
                GUIManager.switchToAdminMenu();
                currentPanel = panelState.AdminMenuPanel;
            } else {
                GUIManager.switchToMenu();
                currentPanel = panelState.MenuPanel;
            }
        } else {
            GUIManager.userIncorrectInputWarning("Username must be unique, please try another.");
        }
    }

    /**
     * Handles what happens when submit admin is pressed saves the new staff as
     * a admin
     */
    private void submitAdmin() {
        String[] loginInfo = GUIManager.getLogin();
        Staff staff = ObjectFactory.createStaff("Admin", loginInfo[0], loginInfo[1]);

        if (modelManager.saveNewStaff(staff)) {
            GUIManager.detatchComponents(currentPanel);
            if (adminMode == true) {
                GUIManager.switchToAdminMenu();
                currentPanel = panelState.AdminMenuPanel;
            } else {
                GUIManager.switchToMenu();
                currentPanel = panelState.MenuPanel;
            }
        } else {
            GUIManager.userIncorrectInputWarning("Username must be unique, please try another.");
        }
    }

    /**
     * Handles when submit is pressed saves the booking as a new booking in the
     * system
     */
    private void submit() {
        Booking booking = GUIManager.getBooking();
        if (booking == null) {
            GUIManager.userIncorrectInputWarning("Start date must be before end date, please try again.");
        } else if (booking.getCustomer().getEmail().isEmpty() || booking.getCustomer().getName().isEmpty() || booking.getCustomer().getPhoneNumber().isEmpty() || booking.getRoom() == null) {
            GUIManager.userIncorrectInputWarning("All fields must be filled.");
        } else {
            modelManager.saveNewBooking(booking);
            modelManager.invoiceBooking(booking);
            GUIManager.detatchComponents(currentPanel);

            if (adminMode == true) {
                GUIManager.switchToAdminMenu();
                currentPanel = panelState.AdminMenuPanel;
            } else {
                GUIManager.switchToMenu();
                currentPanel = panelState.MenuPanel;
            }
        }
    }

    /**
     * Handles if search is pressed searches for the specific booking
     */
    private void search() {
        Booking booking = GUIManager.getBooking();

        //Cchecks if valid object
        if (booking == null) {
            GUIManager.userIncorrectInputWarning("Start date must be before end date, please try again.");
        } else {
            HashSet<Booking> returnedBookings = modelManager.findBooking(booking);
            GUIManager.showBookingsFound(returnedBookings);
        }
    }

    /**
     * Handel's what happens when edit is pressed goes to editBookingPanel and
     * allows user to edit the selected booking
     */
    private void edit() {
        Booking booking = GUIManager.getSelectedSearchBooking();
        if (booking != null) {
            HashSet<Room> rooms = modelManager.findAvailableRooms(booking.getStartDate(), booking.getEndDate());
            GUIManager.switchToEditBooking(booking, rooms);
            currentPanel = panelState.EditBookingPanel;
        } else {
            GUIManager.userIncorrectInputWarning("Please select a booking to edit.");
        }
    }

    /**
     * Handles what happens when saveChanges is pressed updates the booking
     * details for selected booking
     */
    private void saveChanges() {
        Booking booking = GUIManager.getBooking();

        if (booking != null) {
            //Getting all available rooms
            HashSet<Room> availableRooms = modelManager.findAvailableRooms(booking.getStartDate(), booking.getEndDate());
            Booking oldBooking = modelManager.findBookingById(booking.getBookingID());
            availableRooms.add(oldBooking.getRoom());

            if (availableRooms.contains(booking.getRoom())) {
                modelManager.invoiceBooking(booking);
                GUIManager.detatchComponents(currentPanel);

                if (adminMode == true) {
                    GUIManager.switchToAdminMenu();
                    currentPanel = panelState.AdminMenuPanel;
                } else {
                    GUIManager.switchToMenu();
                    currentPanel = panelState.MenuPanel;
                }
            } else {
                GUIManager.userIncorrectInputWarning("This room is occupied, please choose another.");
            }
        } else {
            GUIManager.userIncorrectInputWarning("Start date must be before end date, please try again.");
        }
    }

    /**
     * Handles what happens when delete is pressed deletes the selected booking
     */
    public void delete() {
        Booking booking = GUIManager.getBooking();

        if (booking != null) {
            modelManager.updateBooking(booking);
            modelManager.deleteBooking(booking);
            GUIManager.detatchComponents(currentPanel);
            if (adminMode == true) {
                GUIManager.switchToAdminMenu();
                currentPanel = panelState.AdminMenuPanel;
            } else {
                GUIManager.switchToMenu();
                currentPanel = panelState.MenuPanel;
            }
        } else {
            GUIManager.userIncorrectInputWarning("Start date must be before end date, please try again.");
        }
    }
}
