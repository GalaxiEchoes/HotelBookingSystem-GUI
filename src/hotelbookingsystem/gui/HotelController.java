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
            Booking booking = GUIManager.getBooking();

            if (booking == null) {
                GUIManager.DateUserError();
            } else {
                HashSet<Room> rooms = modelManager.findAvailableRooms(booking.getStartDate(), booking.getEndDate());
                GUIManager.showRoomsFound(rooms);
            }
        } else if ("Submit".equals(actionCommand)) {
            submit();

        } else if ("Search".equals(actionCommand)) {
            search();

        } else if ("Save Changes".equals(actionCommand)) {
            GUIManager.detatchComponents(currentPanel);
            Booking booking = GUIManager.getBooking();

            if (booking != null) {
                if (adminMode == true) {
                    GUIManager.switchToAdminMenu();
                    currentPanel = panelState.AdminMenuPanel;
                } else {
                    GUIManager.switchToMenu();
                    currentPanel = panelState.MenuPanel;
                }
            } else {
                GUIManager.DateUserError();
            }

        } else if ("Delete".equals(actionCommand)) {
            GUIManager.detatchComponents(currentPanel);
            Booking booking = GUIManager.getBooking();

            if (booking != null) {
                if (adminMode == true) {
                    GUIManager.switchToAdminMenu();
                    currentPanel = panelState.AdminMenuPanel;
                } else {
                    GUIManager.switchToMenu();
                    currentPanel = panelState.MenuPanel;
                }
            } else {
                GUIManager.DateUserError();
            }

        } else if ("Edit".equals(actionCommand)) {
            edit();
        }

    }

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
                GUIManager.LoginUserError();
            }
        } else {
            GUIManager.LoginUserError();
        }

    }

    public void logOut() {
        GUIManager.detatchComponents(currentPanel);
        GUIManager.switchToLogin();
        currentPanel = panelState.LoginPanel;
    }

    private void addStaff() {
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.AddStaffPanel;
        GUIManager.switchToAddStaff();
    }

    public void makeBooking() {
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.MakeBookingPanel;
        GUIManager.switchToMakeBooking();
    }

    public void searchBooking() {
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.SearchBookingPanel;
        HashSet<Room> allRooms = modelManager.getAllRooms();
        GUIManager.switchToSearchBooking(allRooms);
    }

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

    private void submitUser() {
        GUIManager.detatchComponents(currentPanel);
        String[] loginInfo = GUIManager.getLogin();
        Staff staff = ObjectFactory.createStaff("User", loginInfo[0], loginInfo[1]);

        if (modelManager.saveNewStaff(staff)) {
            if (adminMode == true) {
                GUIManager.switchToAdminMenu();
                currentPanel = panelState.AdminMenuPanel;
            } else {
                GUIManager.switchToMenu();
                currentPanel = panelState.MenuPanel;
            }
        } else {
            GUIManager.StaffUserError();
        }
    }

    private void submitAdmin() {
        GUIManager.detatchComponents(currentPanel);
        String[] loginInfo = GUIManager.getLogin();
        Staff staff = ObjectFactory.createStaff("Admin", loginInfo[0], loginInfo[1]);

        if (modelManager.saveNewStaff(staff)) {
            if (adminMode == true) {
                GUIManager.switchToAdminMenu();
                currentPanel = panelState.AdminMenuPanel;
            } else {
                GUIManager.switchToMenu();
                currentPanel = panelState.MenuPanel;
            }
        } else {
            GUIManager.StaffUserError();
        }
    }

    private void submit() {
        GUIManager.detatchComponents(currentPanel);
        Booking booking = GUIManager.getBooking();
        if (booking == null) {
            GUIManager.DateUserError();
        } else if (booking.getCustomer().getEmail().isEmpty() || booking.getCustomer().getName().isEmpty() || booking.getCustomer().getPhoneNumber().isEmpty() || booking.getRoom() == null) {
            GUIManager.FieldsEmptyError();
        } else {
            modelManager.saveNewBooking(booking);

            if (adminMode == true) {
                GUIManager.switchToAdminMenu();
                currentPanel = panelState.AdminMenuPanel;
            } else {
                GUIManager.switchToMenu();
                currentPanel = panelState.MenuPanel;
            }
        }
    }

    private void search() {
        Booking booking = GUIManager.getBooking();

        //Cchecks if valid object
        if (booking == null) {
            GUIManager.DateUserError();
        } else {
            HashSet<Booking> returnedBookings = modelManager.findBooking(booking);
            GUIManager.showBookingsFound(returnedBookings);
        }
    }

    private void edit() {
        Booking booking = GUIManager.getSelectedSearchBooking();
        if (booking != null) {
            HashSet<Room> rooms = modelManager.findAvailableRooms(booking.getStartDate(), booking.getEndDate());
            GUIManager.switchToEditBooking(booking, rooms);
            currentPanel = panelState.EditBookingPanel;
        } else {
            GUIManager.DateUserError();
        }
    }

}
