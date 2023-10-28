package hotelbookingsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger:
 * 21151229)
 *
 */
public class HotelController implements ActionListener {

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
     * Handel's all the actions to be preformed when buttons are pressed,
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
     * handels what happens when login is pressed
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
     * handels what happens when logout is pressed
     */
    public void logOut() {
        GUIManager.detatchComponents(currentPanel);
        GUIManager.switchToLogin();
        currentPanel = panelState.LoginPanel;
    }

    /**
     * handels what happens when add staff is pressed
     */
    private void addStaff() {
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.AddStaffPanel;
        GUIManager.switchToAddStaff();
    }

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
     * handels what happens when make booking is pressed
     */
    public void makeBooking() {
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.MakeBookingPanel;
        GUIManager.switchToMakeBooking();
    }

    /**
     * handels what happens when search booking is pressed
     */
    public void searchBooking() {
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.SearchBookingPanel;
        HashSet<Room> allRooms = modelManager.getAllRooms();
        GUIManager.switchToSearchBooking(allRooms);
    }

    /**
     * handels what happens when menu is pressed
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
     * handels what happens when submit user is pressed
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
     * handels what happens when submit admin is pressed
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
     * handels when submit is pressed
     */
    private void submit() {
        GUIManager.detatchComponents(currentPanel);
        Booking booking = GUIManager.getBooking();
        if (booking == null) {
            GUIManager.userIncorrectInputWarning("Start date must be before end date, please try again.");
        } else if (booking.getCustomer().getEmail().isEmpty() || booking.getCustomer().getName().isEmpty() || booking.getCustomer().getPhoneNumber().isEmpty() || booking.getRoom() == null) {
            GUIManager.userIncorrectInputWarning("All fields must be filled");
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
     * Handels if search is pressed
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
     * Handel's what happens when edit is pressed
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
     * Handels what happens when saveChanges is pressed
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
     * Handels what happens when delete is pressed
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
