package hotelbookingsystem.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.HashSet;

/**
 * sets editBookinngPanel to current displayed panel
 *
 * public void editBooking() { cardLayout.show(cardPanel, "Edit a Booking"); }
 */
public class GUIManager extends JFrame {

    private final HotelController controllerListener;
    CardLayout cardLayout;
    JPanel cardPanel;
    GridBagConstraints gbc = new GridBagConstraints();

    // Instance variables for text boxes 
    private JTextField bookingID;
    private JTextField name;
    private JTextField email;
    private JTextField phoneNumber;
    private JLabel totalPrice;
    private JTextArea guestList;
    private JScrollPane guestListScrollPane;
    private JPasswordField password;
    private JLabel warningMessages;
    private JComboBox<Booking> bookings;
    private JComboBox<Integer> startDay;
    private JComboBox<Integer> startMonth;
    private JComboBox<Integer> startYear;
    private JComboBox<Integer> endDay;
    private JComboBox<Integer> endMonth;
    private JComboBox<Integer> endYear;
    private JComboBox<Room> rooms;

    private JPanel loginPanel;
    private JPanel menuPanel;
    private JPanel adminMenuPanel;
    private JPanel makeBookingPanel;
    private JPanel searchBookingPanel;
    private JPanel addStaffPanel;
    private JPanel editBookingPanel;

    public GUIManager(HotelController contollerListener) {
        this.controllerListener = contollerListener;

        gbc.insets = new Insets(5, 5, 5, 5);

        setTitle("HotelBookingSystem");
        this.setPreferredSize(new Dimension(1200, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        //Initialize fields
        initializeFields();

        //adding the panels to the cardLayout
        cardPanel.add(createLogin(), "Login");
        cardPanel.add(createMainMenu(), "Main Menu");
        cardPanel.add(createAdminMenu(), "Admin Menu");
        cardPanel.add(createMakeBooking(), "Make Booking");
        cardPanel.add(createSearchBooking(), "Search/Edit Booking");
        cardPanel.add(createAddStaff(), "Add Staff");
        cardPanel.add(createEditBooking(), "Edit Booking");

        add(cardPanel);
        pack();
        cardLayout.show(cardPanel, "Login");

    }

    /**
     * Makes the loginPanel for the cardLayout frame
     *
     * @return loginPanel
     */
    private JPanel createLogin() {
        loginPanel = new JPanel(new GridBagLayout());

        //Add fields
        addComponent(loginPanel, new JLabel("Login"), 0, 0);
        addComponent(loginPanel, name, 0, 1);
        addComponent(loginPanel, password, 0, 2);
        addComponent(loginPanel, warningMessages, 0, 3);

        //Button to log in
        JButton loginButton = new JButton("Login");
        loginButton.setActionCommand("Login");
        loginButton.addActionListener(controllerListener);
        addComponent(loginPanel, loginButton, 0, 3);

        return loginPanel;
    }

    /**
     * makes the main menu for the cardLayout
     *
     * @return loginPanel
     */
    private JPanel createMainMenu() {
        menuPanel = new JPanel(new GridBagLayout());
        addComponent(menuPanel, new JLabel("Welcome to Hotel Booking System Main Menu"), 0, 0);

        //Log out Button
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setActionCommand("Log Out");
        logoutButton.addActionListener(controllerListener);
        addComponent(menuPanel, logoutButton, 0, 3);

        //make a booking button
        JButton makeBookingButton = new JButton("Make Booking");
        makeBookingButton.setActionCommand("Make Booking");
        makeBookingButton.addActionListener(controllerListener);
        addComponent(menuPanel, makeBookingButton, 0, 1);

        //search/edit booking button
        JButton searchOrEditBooking = new JButton("Search/Edit Booking");
        searchOrEditBooking.setActionCommand("Search/Edit Booking");
        searchOrEditBooking.addActionListener(controllerListener);
        addComponent(menuPanel, searchOrEditBooking, 0, 2);

        return menuPanel;
    }

    /**
     * makes the admin menu for the cardLayout which has the added add staff
     * button
     *
     * @return loginPanel
     */
    private JPanel createAdminMenu() {
        adminMenuPanel = new JPanel(new GridBagLayout());
        addComponent(adminMenuPanel, new JLabel("Welcome to Hotel Booking System Main Menu"), 0, 0);

        //Buttons
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setActionCommand("Log Out");
        logoutButton.addActionListener(controllerListener);
        addComponent(adminMenuPanel, logoutButton, 0, 4);

        JButton makeBookingButton = new JButton("Make Booking");
        makeBookingButton.setActionCommand("Make Booking");
        makeBookingButton.addActionListener(controllerListener);
        addComponent(adminMenuPanel, makeBookingButton, 0, 1);

        JButton searchOrEditBooking = new JButton("Search/Edit Booking");
        searchOrEditBooking.setActionCommand("Search/Edit Booking");
        searchOrEditBooking.addActionListener(controllerListener);
        addComponent(adminMenuPanel, searchOrEditBooking, 0, 2);

        JButton addStaff = new JButton("Add Staff");
        addStaff.setActionCommand("Add Staff");
        addStaff.addActionListener(controllerListener);
        addComponent(adminMenuPanel, addStaff, 0, 3);

        return adminMenuPanel;
    }

    /**
     * makes the make a booking panel
     *
     * @return makeBookingPanel
     */
    private JPanel createMakeBooking() {
        makeBookingPanel = new JPanel(new GridBagLayout());
        addComponent(makeBookingPanel, new JLabel("Make Booking"), 0, 0);

        JButton menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        menuButton.addActionListener(controllerListener);
        addComponent(makeBookingPanel, menuButton, 0, 1);

        JButton findRoomsButton = new JButton("Find Rooms");
        findRoomsButton.setActionCommand("Find Rooms");
        findRoomsButton.addActionListener(controllerListener);
        addComponent(makeBookingPanel, findRoomsButton, 0, 5);

        JButton submitButton = new JButton("Submit");
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(controllerListener);
        addComponent(makeBookingPanel, submitButton, 0, 3);

        return makeBookingPanel;
    }

    /**
     * makes the search for booking panel
     *
     * @return searchBookingPanel
     */
    private JPanel createSearchBooking() {
        searchBookingPanel = new JPanel(new GridBagLayout());
        addComponent(searchBookingPanel, new JLabel("Search Booking"), 0, 0);

        JButton menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        menuButton.addActionListener(controllerListener);
        addComponent(searchBookingPanel, menuButton, 0, 1);

        JButton searchButton = new JButton("Search");
        searchButton.setActionCommand("Search");
        searchButton.addActionListener(controllerListener);
        addComponent(searchBookingPanel, searchButton, 0, 5);

        JButton editButton = new JButton("Edit");
        editButton.setActionCommand("Edit");
        editButton.addActionListener(controllerListener);
        addComponent(searchBookingPanel, editButton, 0, 3);

        return searchBookingPanel;
    }

    /**
     * makes addStaffPanel
     *
     * @return addStaffPanel
     */
    private JPanel createAddStaff() {
        addStaffPanel = new JPanel(new GridBagLayout());
        addStaffPanel.add(new JLabel("Add Staff"));
        addComponent(addStaffPanel, new JLabel("Add Staff"), 0, 0);

        JButton menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        menuButton.addActionListener(controllerListener);
        addComponent(addStaffPanel, menuButton, 0, 1);

        JButton addUserButton = new JButton("Submit User");
        addUserButton.setActionCommand("Submit User");
        addUserButton.addActionListener(controllerListener);
        addComponent(addStaffPanel, addUserButton, 0, 5);

        JButton addAdminButton = new JButton("Submit Admin");
        addAdminButton.setActionCommand("Submit Admin");
        addAdminButton.addActionListener(controllerListener);
        addComponent(addStaffPanel, addAdminButton, 1, 5);

        return addStaffPanel;
    }

    /**
     * makes the editBookingPanel
     *
     * @return editBookingPanel
     */
    private JPanel createEditBooking() {
        editBookingPanel = new JPanel(new GridBagLayout());
        addComponent(editBookingPanel, new JLabel("Edit Booking"), 0, 0);

        JButton menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        menuButton.addActionListener(controllerListener);
        addComponent(editBookingPanel, menuButton, 0, 1);

        JButton saveButton = new JButton("Save Changes");
        saveButton.setActionCommand("Save Changes");
        saveButton.addActionListener(controllerListener);
        addComponent(editBookingPanel, saveButton, 0, 5);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setActionCommand("Delete");
        deleteButton.addActionListener(controllerListener);
        addComponent(editBookingPanel, deleteButton, 0, 3);

        return editBookingPanel;
    }

    /**
     * switches to loginPanel
     */
    public void switchToLogin() {
        clearAllText();
        gbc.gridwidth = 2;
        addComponent(loginPanel, new JLabel("Username:"), 0, 1);
        addComponent(loginPanel, new JLabel("Password:"), 0, 2);
        addComponent(loginPanel, warningMessages, 1, 3);
        gbc.gridwidth = 1;
        addComponent(loginPanel, name, 2, 1);
        addComponent(loginPanel, password, 2, 2);

        //Refresh
        loginPanel.revalidate();
        loginPanel.repaint();
        cardLayout.show(cardPanel, "Login");
    }

    /**
     * switches to mainMenuPanel
     */
    public void switchToMenu() {
        cardLayout.show(cardPanel, "Main Menu");
    }

    /**
     * switches to adminMenuPanel
     */
    public void switchToAdminMenu() {
        cardLayout.show(cardPanel, "Admin Menu");
    }

    /**
     * switches to makeBookingpanel
     */
    public void switchToMakeBooking() {
        clearAllText();
        addComponent(makeBookingPanel, new JLabel("Name:"), 1, 1);
        addComponent(makeBookingPanel, new JLabel("Email:"), 1, 2);
        addComponent(makeBookingPanel, new JLabel("Phone:"), 1, 3);
        addComponent(makeBookingPanel, new JLabel("Day:"), 4, 1);
        addComponent(makeBookingPanel, new JLabel("Month:"), 5, 1);
        addComponent(makeBookingPanel, new JLabel("Year:"), 6, 1);
        addComponent(makeBookingPanel, new JLabel("Start Date:"), 3, 2);
        addComponent(makeBookingPanel, new JLabel("End Date:"), 3, 3);
        addComponent(makeBookingPanel, new JLabel("Guest notes:"), 2, 6);
        addComponent(makeBookingPanel, warningMessages, 2, 4);
        addComponent(makeBookingPanel, startDay, 4, 2);
        addComponent(makeBookingPanel, startMonth, 5, 2);
        addComponent(makeBookingPanel, startYear, 6, 2);
        addComponent(makeBookingPanel, endDay, 4, 3);
        addComponent(makeBookingPanel, endMonth, 5, 3);
        addComponent(makeBookingPanel, endYear, 6, 3);
        addComponent(makeBookingPanel, name, 2, 1);
        addComponent(makeBookingPanel, email, 2, 2);
        addComponent(makeBookingPanel, phoneNumber, 2, 3);
        addComponent(makeBookingPanel, rooms, 2, 5);
        addComponent(makeBookingPanel, guestListScrollPane, 2, 7);

        //Refresh
        makeBookingPanel.revalidate();
        makeBookingPanel.repaint();
        cardLayout.show(cardPanel, "Make Booking");
    }

    /**
     * switches to searchBookingPanel
     *
     * @param allRooms
     */
    public void switchToSearchBooking(HashSet<Room> allRooms) {
        clearAllText();
        addComponent(searchBookingPanel, new JLabel("Name:"), 1, 2);
        addComponent(searchBookingPanel, new JLabel("Email:"), 1, 3);
        addComponent(searchBookingPanel, new JLabel("Phone:"), 1, 4);
        addComponent(searchBookingPanel, new JLabel("Day:"), 4, 1);
        addComponent(searchBookingPanel, new JLabel("Month:"), 5, 1);
        addComponent(searchBookingPanel, new JLabel("Year:"), 6, 1);
        addComponent(searchBookingPanel, new JLabel("Start Date:"), 3, 2);
        addComponent(searchBookingPanel, new JLabel("End Date:"), 3, 3);
        addComponent(searchBookingPanel, new JLabel("Bookings Found:"), 0, 7);
        addComponent(searchBookingPanel, new JLabel("BookingID: "), 1, 1);
        addComponent(searchBookingPanel, bookingID, 2, 1);
        addComponent(searchBookingPanel, warningMessages, 2, 5);
        addComponent(searchBookingPanel, startDay, 4, 2);
        addComponent(searchBookingPanel, startMonth, 5, 2);
        addComponent(searchBookingPanel, startYear, 6, 2);
        addComponent(searchBookingPanel, endDay, 4, 3);
        addComponent(searchBookingPanel, endMonth, 5, 3);
        addComponent(searchBookingPanel, endYear, 6, 3);
        addComponent(searchBookingPanel, name, 2, 2);
        addComponent(searchBookingPanel, email, 2, 3);
        addComponent(searchBookingPanel, phoneNumber, 2, 4);
        addComponent(searchBookingPanel, rooms, 2, 6);
        gbc.gridwidth = 6;
        addComponent(searchBookingPanel, bookings, 1, 7);
        gbc.gridwidth = 1;

        //Add all rooms
        for (Room r : allRooms) {
            rooms.addItem(r);
        }

        if (rooms.getItemCount() > 0) {
            rooms.setSelectedIndex(0);
        }

        //Refresh
        searchBookingPanel.revalidate();
        searchBookingPanel.repaint();
        cardLayout.show(cardPanel, "Search/Edit Booking");
    }

    /**
     * switches to editBookingPanel
     *
     * @param booking
     * @param availableRooms
     */
    public void switchToEditBooking(Booking booking, HashSet<Room> availableRooms) {
        clearAllText();
        name.setText(booking.getCustomer().getName());
        email.setText(booking.getCustomer().getEmail());
        phoneNumber.setText(booking.getCustomer().getPhoneNumber());
        warningMessages.setText("");
        for (Room r : availableRooms) {
            rooms.addItem(r);
        }
        rooms.addItem(booking.getRoom());
        bookingID.setText(booking.getBookingID() + "");
        rooms.setSelectedItem(booking.getRoom());
        totalPrice.setText("Total: " + booking.getTotal());
        guestList.setText(booking.getGuestNotes());

        //Set start date
        int[] startDate = ObjectFactory.convertDateToIntArray(booking.getStartDate());
        startDay.setSelectedItem(startDate[0]);
        startMonth.setSelectedItem(startDate[1]);
        startYear.setSelectedItem(startDate[2]);

        //Set end date
        int[] endDate = ObjectFactory.convertDateToIntArray(booking.getEndDate());
        endDay.setSelectedItem(endDate[0]);
        endMonth.setSelectedItem(endDate[1]);
        endYear.setSelectedItem(endDate[2]);

        addComponent(editBookingPanel, new JLabel("Name:"), 1, 1);
        addComponent(editBookingPanel, new JLabel("Email:"), 1, 2);
        addComponent(editBookingPanel, new JLabel("Phone:"), 1, 3);
        addComponent(editBookingPanel, new JLabel("Day:"), 4, 1);
        addComponent(editBookingPanel, new JLabel("Month:"), 5, 1);
        addComponent(editBookingPanel, new JLabel("Year:"), 6, 1);
        addComponent(editBookingPanel, new JLabel("Start Date:"), 3, 2);
        addComponent(editBookingPanel, new JLabel("End Date:"), 3, 3);
        addComponent(editBookingPanel, new JLabel("Guest notes:"), 2, 6);
        addComponent(editBookingPanel, new JLabel("Booking ID: " + booking.getBookingID()), 2, 0);
        addComponent(editBookingPanel, totalPrice, 3, 0);
        addComponent(editBookingPanel, name, 2, 1);
        addComponent(editBookingPanel, email, 2, 2);
        addComponent(editBookingPanel, phoneNumber, 2, 3);
        addComponent(editBookingPanel, warningMessages, 2, 4);
        addComponent(editBookingPanel, rooms, 2, 5);
        addComponent(editBookingPanel, startDay, 4, 2);
        addComponent(editBookingPanel, startMonth, 5, 2);
        addComponent(editBookingPanel, startYear, 6, 2);
        addComponent(editBookingPanel, endDay, 4, 3);
        addComponent(editBookingPanel, endMonth, 5, 3);
        addComponent(editBookingPanel, endYear, 6, 3);
        addComponent(editBookingPanel, guestListScrollPane, 2, 7);

        //Refresh
        editBookingPanel.revalidate();
        editBookingPanel.repaint();
        cardLayout.show(cardPanel, "Edit Booking");
    }

    /**
     * changes to addStaffPanel
     */
    public void switchToAddStaff() {
        clearAllText();
        addComponent(addStaffPanel, name, 1, 2);
        addComponent(addStaffPanel, new JLabel("New Username:"), 0, 2);
        addComponent(addStaffPanel, password, 1, 3);
        addComponent(addStaffPanel, new JLabel("New Password:"), 0, 3);
        addComponent(addStaffPanel, warningMessages, 1, 4);

        //Refresh
        addStaffPanel.revalidate();
        addStaffPanel.repaint();
        cardLayout.show(cardPanel, "Add Staff");
    }

    /**
     * get bookings found
     *
     * @param bookingsFound
     */
    public void showBookingsFound(HashSet<Booking> bookingsFound) {
        bookings.removeAllItems();

        for (Booking b : bookingsFound) {
            bookings.addItem(b);
        }

        if (bookings.getItemCount() > 0) {
            rooms.setSelectedIndex(0);
        }

        //Refresh
        searchBookingPanel.revalidate();
        searchBookingPanel.repaint();
    }

    /**
     * sets the roomsfound to the enditbooking pannel
     *
     * @param roomsFound
     */
    public void showRoomsFound(HashSet<Room> roomsFound) {
        rooms.removeAllItems();

        for (Room r : roomsFound) {
            rooms.addItem(r);
        }

        if (rooms.getItemCount() > 0) {
            rooms.setSelectedIndex(0);
        }

        //Refresh
        editBookingPanel.revalidate();
        editBookingPanel.repaint();
    }

    /**
     * detaches the compontents so that they can be attached to next panel
     *
     * @param currentPanel
     */
    public void detatchComponents(HotelController.panelState currentPanel) {
        switch (currentPanel) {
            case LoginPanel:
                loginPanel.remove(name);
                loginPanel.remove(password);
                loginPanel.remove(warningMessages);
                break;
            case MakeBookingPanel:
                makeBookingPanel.remove(name);
                makeBookingPanel.remove(email);
                makeBookingPanel.remove(phoneNumber);
                makeBookingPanel.remove(warningMessages);
                makeBookingPanel.remove(rooms);
                makeBookingPanel.remove(startDay);
                makeBookingPanel.remove(startMonth);
                makeBookingPanel.remove(startYear);
                makeBookingPanel.remove(endDay);
                makeBookingPanel.remove(endMonth);
                makeBookingPanel.remove(endYear);
                makeBookingPanel.remove(guestListScrollPane);
            case SearchBookingPanel:
                searchBookingPanel.remove(bookingID);
                searchBookingPanel.remove(name);
                searchBookingPanel.remove(email);
                searchBookingPanel.remove(phoneNumber);
                searchBookingPanel.remove(warningMessages);
                searchBookingPanel.remove(rooms);
                searchBookingPanel.remove(startDay);
                searchBookingPanel.remove(startMonth);
                searchBookingPanel.remove(startYear);
                searchBookingPanel.remove(endDay);
                searchBookingPanel.remove(endMonth);
                searchBookingPanel.remove(endYear);
                break;
            case EditBookingPanel:
                editBookingPanel.remove(bookingID);
                editBookingPanel.remove(name);
                editBookingPanel.remove(email);
                editBookingPanel.remove(phoneNumber);
                editBookingPanel.remove(warningMessages);
                editBookingPanel.remove(rooms);
                editBookingPanel.remove(startDay);
                editBookingPanel.remove(startMonth);
                editBookingPanel.remove(startYear);
                editBookingPanel.remove(endDay);
                editBookingPanel.remove(endMonth);
                editBookingPanel.remove(endYear);
                editBookingPanel.remove(guestListScrollPane);
                editBookingPanel.remove(totalPrice);
                break;
            case AddStaffPanel:
                addStaffPanel.remove(name);
                addStaffPanel.remove(password);
                addStaffPanel.remove(warningMessages);
                break;
            case MenuPanel: // Fallthrough
            case AdminMenuPanel:
                //Do nothing
                break;
        }
    }

    /**
     * initialzes the diffferent components
     */
    private void initializeFields() {
        Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 10, 31};
        Integer[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Integer[] years = {2023, 2024, 2025};

        totalPrice = new JLabel();
        bookingID = new JTextField(15);
        name = new JTextField(15);
        email = new JTextField(15);
        phoneNumber = new JTextField(15);
        password = new JPasswordField(15);
        warningMessages = new JLabel();
        bookings = new JComboBox<>();
        rooms = new JComboBox<>();
        startDay = new JComboBox<>(days);
        startMonth = new JComboBox<>(months);
        startYear = new JComboBox<>(years);
        endDay = new JComboBox<>(days);
        endMonth = new JComboBox<>(months);
        endYear = new JComboBox<>(years);
        guestList = new JTextArea();
        guestList.setRows(10);
        guestList.setColumns(30);
        guestList.setLineWrap(true);
        guestList.setWrapStyleWord(true);
        guestListScrollPane = new JScrollPane(guestList);

        totalPrice.setText("");
        name.setText("");
        email.setText("");
        phoneNumber.setText("");
        guestList.setText("");
        password.setText("");
        warningMessages.setText("");
    }

    /**
     * gets a booking
     *
     * @return booking
     */
    public Booking getBooking() {
        //Retrieve values for booking
        Customer customer = ObjectFactory.createCustomer(name.getText(), email.getText(), phoneNumber.getText());
        Date startDate = ObjectFactory.createDate((Integer) startDay.getSelectedItem(), (Integer) startMonth.getSelectedItem(), (Integer) startYear.getSelectedItem());
        Date endDate = ObjectFactory.createDate((Integer) endDay.getSelectedItem(), (Integer) endMonth.getSelectedItem(), (Integer) endYear.getSelectedItem());
        Room room = (Room) rooms.getSelectedItem();
        String bookingIDstring = bookingID.getText();

        Booking booking = new Booking(guestList.getText(), customer, room, startDate, endDate);

        //Checks if valid time period
        if (endDate.before(startDate)) {
            return null;
        }
        try {
            int currentBookingID = Integer.parseInt(bookingIDstring);

            if (currentBookingID > 0) {
                booking.setBookingID(currentBookingID);
            }
        } catch (NumberFormatException e) {
        }

        return booking;
    }

    /**
     * sees which booking was selected
     *
     * @return booking that was selected or null
     */
    public Booking getSelectedSearchBooking() {
        if (bookings.getItemCount() > 0) {
            return (Booking) bookings.getSelectedItem();
        }

        return null;
    }

    /**
     * getting staff login information in a String[] format
     *
     * @return loginInfo
     */
    public String[] getLogin() {
        String[] loginInfo = new String[2];
        loginInfo[0] = name.getText();
        loginInfo[1] = new String(password.getPassword());

        return loginInfo;
    }

    /**
     * setsText("") for all componets aswell set the dates to position 0 in the
     * comboboxs
     */
    public void clearAllText() {
        totalPrice.setText("");
        bookingID.setText("");
        name.setText("");
        email.setText("");
        phoneNumber.setText("");
        guestList.setText("");
        warningMessages.setText("");
        password.setText("");
        bookings.removeAllItems();
        rooms.removeAllItems();
        startDay.setSelectedIndex(0);
        startMonth.setSelectedIndex(0);
        startYear.setSelectedIndex(0);
        endDay.setSelectedIndex(0);
        endMonth.setSelectedIndex(0);
        endYear.setSelectedIndex(0);
    }

    /**
     * hanedels the errors for the incorrect inputs
     * @param text 
     */
    public void userIncorrectInputWarning(String text) {
        warningMessages.setText(text);

        //refresh
        loginPanel.revalidate();
        loginPanel.repaint();
        makeBookingPanel.revalidate();
        makeBookingPanel.repaint();
        searchBookingPanel.revalidate();
        searchBookingPanel.repaint();
        editBookingPanel.revalidate();
        editBookingPanel.repaint();
        addStaffPanel.revalidate();
        addStaffPanel.repaint();
    }

    /**
     * adds componets to the gbc
     *
     * @param panel
     * @param component
     * @param x
     * @param y
     */
    private void addComponent(JPanel panel, JComponent component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(component, gbc);
    }
}
