package hotelbookingsystem.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger:
 * 21151229)
 */
public class GUIManager extends JFrame {

    private final CardLayout cardLayout;
    private final JPanel cardPanel;
    private final JPanel controlPanel;
    private DefaultListModel<Room> roomListModel;
    private DefaultListModel<Booking> bookingListModel;

    public GUIManager() {
        JFrame frame = new JFrame("Hotel Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        controlPanel = new JPanel();

        cardPanel.add(createLogin(), "Login");
        cardPanel.add(createMainMenu(), "Main Menu");
        cardPanel.add(createAdminMenu(), "Admin Menu");
        cardPanel.add(createMakeBooking(), "Make Booking");
        cardPanel.add(createSearchBooking(), "Search for Booking");
        cardPanel.add(createAddStaff(), "Add Staff");
        cardPanel.add(createEditBooking(), "Edit Booking");

        controlPanel.add(controlButton());

        frame.add(cardPanel, BorderLayout.NORTH);
        frame.add(controlPanel, BorderLayout.SOUTH);

    }

    /**
     * makes the loginPanel for the cardLayout frame sets the contorlPanel's
     * visibility to false
     *
     * @return loginPanel
     */
    private JPanel createLogin() {
        JPanel loginPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JTextField username = new JTextField();
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JTextField password = new JTextField();

        loginPanel.add(usernameLabel);
        loginPanel.add(username);
        loginPanel.add(passwordLabel);
        loginPanel.add(password);
        loginPanel.add(loginButton);

        controlPanel.setVisible(false);

        return loginPanel;
    }

    /**
     * sets the login as the current displayed panel
     */
    public void login() {
        controlPanel.setVisible(false);
        cardLayout.show(cardPanel, "Login");
    }

    /**
     * *
     * makes user mainMenuPanel for the cardLayout frame
     *
     * @return mainMenuPanel
     */
    private JPanel createMainMenu() {
        JPanel mainMenuPanel = new JPanel();
        JButton makeBooking = new JButton("Make a Booking");
        JButton findBooking = new JButton("Find a Booking");

        mainMenuPanel.add(makeBooking);
        mainMenuPanel.add(findBooking);

        return mainMenuPanel;
    }

    /**
     * sets mainMenu as the current displayed panel
     */
    public void mainMenu() {
        controlPanel.setVisible(true);
        cardLayout.show(cardPanel, "Main Menu");
    }

    /**
     * *
     * makes the AdminMenuPanel for the cardLayout frame add the option of
     * adding staff where normal mainMenu cant add staff
     *
     * @return adminMenuPanel
     */
    private JPanel createAdminMenu() {
        JPanel adminMenuPanel = new JPanel();
        JButton makeBooking = new JButton("Make a Booking");
        JButton findBooking = new JButton("Find a Booking");
        JButton addStaff = new JButton("Add Staff");

        adminMenuPanel.add(makeBooking);
        adminMenuPanel.add(findBooking);
        adminMenuPanel.add(addStaff);

        return adminMenuPanel;
    }

    /**
     * sets adminMenu to the current displayed panel
     */
    public void adminMenu() {
        controlPanel.setVisible(true);
        cardLayout.show(cardPanel, "Admin Menu");
    }

    /**
     * makes the addStaffPanel for the cardLayout frame
     *
     * @return addStaffPanel
     */
    private JPanel createAddStaff() {
        JPanel addStaffPanel = new JPanel();
        JButton add = new JButton("Add");
        JTextField username = new JTextField();
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JCheckBox addAdmin = new JCheckBox("Admin");
        JTextField password = new JTextField();

        addStaffPanel.add(add);
        addStaffPanel.add(usernameLabel);
        addStaffPanel.add(username);
        addStaffPanel.add(passwordLabel);
        addStaffPanel.add(password);
        addStaffPanel.add(addAdmin);

        return addStaffPanel;
    }

    /**
     * sets addStaff to the current displayed panel
     */
    public void addStaff() {
        cardLayout.show(cardPanel, "Add Staff");
    }

    /**
     * makes the makeBookingPanel where all information for a booking is entered
     *
     * @return makeBookingPanel
     */
    private JPanel createMakeBooking() {
        JPanel makeBookingPanel = new JPanel();
        JButton submit = new JButton("Submit");
        JLabel bookingDetials = new JLabel("Booking Details: ");
        JLabel nameLabel = new JLabel("Name: ");
        JTextField customerName = new JTextField();
        JLabel emailLabel = new JLabel("Email: ");
        JTextField email = new JTextField();
        JLabel numberLabel = new JLabel("Phone Number:");
        JTextField phoneNumber = new JTextField();
        JLabel guestListLabel = new JLabel("Guest List:");
        JTextArea guestList = new JTextArea();
        JLabel startDateLabel = new JLabel("Start Date (dd/mm/yyyy): ");
        JTextField startDate = new JTextField();
        JLabel endDateLabel = new JLabel("End Date(dd/mm/yyyy): ");
        JTextField endDate = new JTextField();

        //make JPanels for availableRooms, roomList and buttonPanel
        JPanel availableRooms = new JPanel();
        JPanel roomList = new JPanel();
        JPanel buttonPanel = new JPanel();
        JList result = new JList<>(roomListModel);

        //make buttons for roomSizes
        ButtonGroup roomSizeButtons = new ButtonGroup();
        JRadioButton singleRoomButton = new JRadioButton("Single Room");
        JRadioButton doubleRoomButton = new JRadioButton("Double Room");
        JRadioButton suiteRoomButton = new JRadioButton("Suite");

        //add butons to buttonGroup
        roomSizeButtons.add(suiteRoomButton);
        roomSizeButtons.add(singleRoomButton);
        roomSizeButtons.add(doubleRoomButton);

        //add componets to buttonPanel
        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.add(singleRoomButton);
        buttonPanel.add(doubleRoomButton);
        buttonPanel.add(suiteRoomButton);

        roomList.add(new JScrollPane(result));

        //add allcomponets to makeBookingPanel
        availableRooms.add(buttonPanel, BorderLayout.PAGE_START);
        availableRooms.add(roomList, BorderLayout.CENTER);
        makeBookingPanel.add(bookingDetials);
        makeBookingPanel.setLayout(new GridLayout(0, 3));
        makeBookingPanel.add(startDateLabel);
        makeBookingPanel.add(startDate);
        makeBookingPanel.add(endDateLabel);
        makeBookingPanel.add(endDate);
        makeBookingPanel.add(availableRooms, BorderLayout.EAST);
        makeBookingPanel.add(nameLabel);
        makeBookingPanel.add(customerName);
        makeBookingPanel.add(emailLabel);
        makeBookingPanel.add(email);
        makeBookingPanel.add(numberLabel);
        makeBookingPanel.add(phoneNumber);
        makeBookingPanel.add(guestListLabel);
        makeBookingPanel.add(guestList);
        makeBookingPanel.add(submit);

        return makeBookingPanel;
    }

    /**
     * sets makeBookingPanel to current displayed panel
     */
    public void makeBooking() {
        cardLayout.show(cardPanel, "Make a Booking");
    }

    /**
     * the controlPanel is so that a user can either go back to the main menu or
     * log out if an admin is loged in if they press main menu it will go back
     * to admin menu
     *
     * @return controlPanel
     */
    private JPanel controlButton() {
        JButton logout = new JButton("Logout");
        JButton mainMenu = new JButton("Main Menu");

        controlPanel.add(logout);
        controlPanel.add(mainMenu);

        return controlPanel;
    }

    /**
     * makes the panel for searching for a booking
     *
     * @return searchBookingPanel
     */
    private JPanel createSearchBooking() {
        JPanel searchBookingPanel = new JPanel();
        JButton searchButton = new JButton("Search");
        JLabel nameLabel = new JLabel("Name: ");
        JTextField customerName = new JTextField();
        JLabel emailLabel = new JLabel("Email: ");
        JTextField email = new JTextField();
        JLabel numberLabel = new JLabel("Phone Number: ");
        JTextField phoneNumber = new JTextField();
        JLabel guestListLabel = new JLabel("Guest List:");
        JTextArea guestList = new JTextArea();
        JLabel startDateLabel = new JLabel("Start Date (ss/mm/yyyy): ");
        JTextField startDate = new JTextField();
        JLabel endDateLabel = new JLabel("End Date (dd/mm/yyyy): ");
        JTextField endDate = new JTextField();

        JList result = new JList();
        JButton edit = new JButton("Edit");

        //add all componets to searchBookingPanel
        searchBookingPanel.add(nameLabel);
                searchBookingPanel.add(customerName);
        searchBookingPanel.add(emailLabel);
        searchBookingPanel.add(email);
                searchBookingPanel.add(numberLabel);
        searchBookingPanel.add(phoneNumber);
        searchBookingPanel.add(guestListLabel);
        searchBookingPanel.add(guestList);
        searchBookingPanel.add(startDateLabel);
        searchBookingPanel.add(startDate);
        searchBookingPanel.add(endDateLabel);
        searchBookingPanel.add(endDate);
        searchBookingPanel.add(searchButton);
        searchBookingPanel.add(result);
        searchBookingPanel.add(edit);

        return searchBookingPanel;
    }

    /**
     * makes searchBookingPanel to current displayed panel
     */
    public void searchBooking() {
        cardLayout.show(cardPanel, "Search for Booking");
    }

    /**
     * makes the editBookingPanel
     *
     * @return editBookingPanel
     */
    private JPanel createEditBooking() {
        //editBookingPanel and all its componets
        JPanel editBookingPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton update = new JButton("Update Detials");
        JButton delete = new JButton("Delete Booking");
        JLabel bookingDetials = new JLabel("Booking Details: ");
        JLabel nameLabel = new JLabel("Name: ");
        JTextField customerName = new JTextField();
        JLabel emailLabel = new JLabel("Email: ");
        JTextField email = new JTextField();
        JLabel numberLabel = new JLabel("Phone Number: ");
        JTextField phoneNumber = new JTextField();
        JLabel guestListLabel = new JLabel("Guest List:");
        JTextArea guestList = new JTextArea();
        JLabel startDateLabel = new JLabel("Start Date (ss/mm/yyyy): ");
        JTextField startDate = new JTextField();
        JLabel endDateLabel = new JLabel("End Date (dd/mm/yyyy): ");
        JTextField endDate = new JTextField();

        //make Jpanel for availableRooms, roomlist,radioButtonPanel
        JPanel availableRooms = new JPanel();
        JPanel roomList = new JPanel();
        JPanel radioButtonPanel = new JPanel();
        JList result = new JList<>(roomListModel);

        //make buttonGroup for radioButtons for roomsizes
        ButtonGroup roomSizeButtons = new ButtonGroup();
        JRadioButton singleRoomButton = new JRadioButton("Single Room");
        JRadioButton doubleRoomButton = new JRadioButton("Double Room");
        JRadioButton suiteRoomButton = new JRadioButton("Suite");

        //add the radioButtons to buttonGroup
        roomSizeButtons.add(suiteRoomButton);
        roomSizeButtons.add(singleRoomButton);
        roomSizeButtons.add(doubleRoomButton);

        //set layout off raidoButtonPanel and add the radioButtons to it
        radioButtonPanel.setLayout(new GridLayout(3, 1));
        radioButtonPanel.add(singleRoomButton);
        radioButtonPanel.add(doubleRoomButton);
        radioButtonPanel.add(suiteRoomButton);

        //add ScrollPane for roomlist
        roomList.add(new JScrollPane(result));

        //add radioButtonPanel and roomlist to availableRooms panel
        availableRooms.add(radioButtonPanel, BorderLayout.PAGE_START);
        availableRooms.add(roomList, BorderLayout.CENTER);

        //add buttons to buttonPanel
        buttonPanel.add(update);
        buttonPanel.add(delete);

        //adds all panels and componets to editbookingPanel
        editBookingPanel.add(bookingDetials);
        editBookingPanel.add(buttonPanel, BorderLayout.PAGE_END);
        editBookingPanel.setLayout(new GridLayout(0, 3));
        editBookingPanel.add(startDateLabel);
        editBookingPanel.add(startDate);
        editBookingPanel.add(endDateLabel);
        editBookingPanel.add(endDate);
        editBookingPanel.add(availableRooms, BorderLayout.EAST);
        editBookingPanel.add(nameLabel);
        editBookingPanel.add(customerName);
        editBookingPanel.add(emailLabel);
        editBookingPanel.add(email);
        editBookingPanel.add(numberLabel);
        editBookingPanel.add(phoneNumber);
        editBookingPanel.add(guestListLabel);
        editBookingPanel.add(guestList);
        editBookingPanel.add(buttonPanel, BorderLayout.SOUTH);

        return editBookingPanel;
    }

    /**
     * sets editBookinngPanel to current displayed panel
     */
    public void editBooking() {
        cardLayout.show(cardPanel, "Edit a Booking");
    }
}
