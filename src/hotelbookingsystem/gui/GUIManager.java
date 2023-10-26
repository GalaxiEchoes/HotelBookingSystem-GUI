/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 *
 * @author berri
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
        cardPanel.add(createEditBooking(new Booking()), "Edit Booking");
        cardPanel.add(availabeRooms(), "Avialable Rooms");

        controlPanel.add(controlButton());

        frame.add(cardPanel);
        frame.add(controlPanel);

    }

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

        return loginPanel;
    }

    private JPanel createMainMenu() {
        JPanel mainMenuPanel = new JPanel();
        JButton makeBooking = new JButton("Make a Booking");
        JButton findBooking = new JButton("Find a Booking");

        mainMenuPanel.add(makeBooking);
        mainMenuPanel.add(findBooking);

        return mainMenuPanel;
    }

    public void mainMenu() {

        cardLayout.show(cardPanel, "Main Menu");
    }

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

    public void adminMenu() {

        cardLayout.show(cardPanel, "Admin Menu");
    }

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

    public void addStaff() {
        cardLayout.show(cardPanel, "Add Staff");
    }

    private JPanel createMakeBooking() {
        JPanel makeBookingPanel = new JPanel();

        JLabel bookingDetials = new JLabel("Booking Details: ");
        JLabel nameLabel = new JLabel("Name: ");
        JTextField customerName = new JTextField("Eneter name");
        JLabel guestListLabel = new JLabel("Email: ");
        JTextField guestList = new JTextField("Add guest List");
        JLabel startDateLabel = new JLabel("Start Date: ");
        JTextField startDate = new JTextField("Enter starting date");
        JLabel endDateLabel = new JLabel("End Date: ");
        JTextField endDateDay = new JTextField("day");
        JTextField endDateMonth = new JTextField("month");
        JTextField endDateYear = new JTextField("year");
        JLabel roomSizeLabel = new JLabel("Room size: ");

        makeBookingPanel.add(bookingDetials);
        makeBookingPanel.setLayout(new GridLayout(0, 2));
        makeBookingPanel.add(nameLabel);
        makeBookingPanel.add(customerName);
        makeBookingPanel.add(guestListLabel);
        makeBookingPanel.add(guestList);
        makeBookingPanel.add(startDateLabel);
        makeBookingPanel.add(startDate);
        makeBookingPanel.add(endDateLabel);
        makeBookingPanel.add(endDateDay);
        makeBookingPanel.add(endDateMonth);
        makeBookingPanel.add(endDateYear);
        makeBookingPanel.add(roomSizeLabel);

        return makeBookingPanel;
    }

    private JPanel availabeRooms() {
        JPanel availableRooms = new JPanel();
        JPanel roomList = new JPanel();
        JPanel buttonPanel = new JPanel();
        JList result = new JList<>(roomListModel);

        ButtonGroup roomSize = new ButtonGroup();
        JRadioButton singleRoomButton = new JRadioButton("Single Room");
        JRadioButton doubleRoomButton = new JRadioButton("Double Room");
        JRadioButton suiteRoomButton = new JRadioButton("Suite");

        roomSize.add(suiteRoomButton);
        roomSize.add(singleRoomButton);
        roomSize.add(doubleRoomButton);

        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(singleRoomButton);
        buttonPanel.add(doubleRoomButton);
        buttonPanel.add(suiteRoomButton);

        roomList.add(new JScrollPane(result));

        return availableRooms;
    }

    private JPanel controlButton() {
        JButton logout = new JButton("Logout");
        JButton mainMenu = new JButton("Main Menu");

        controlPanel.add(logout);
        controlPanel.add(mainMenu);

        return controlPanel;
    }

    public void makeBooking() {
        cardLayout.show(cardPanel, "Make a Booking");
    }

    private JPanel createSearchBooking() {
        JPanel searchBookingPanel = new JPanel();
        JButton searchButton = new JButton("Search");
        JTextField search = new JTextField();
        JList result = new JList();
        JButton edit = new JButton("Edit");

        searchBookingPanel.add(search);
        searchBookingPanel.add(searchButton);
        searchBookingPanel.add(result);

        return searchBookingPanel;
    }

    private JPanel createEditBooking() {
        JPanel editBookingPanel = new JPanel();
        JLabel bookingDetials = new JLabel("Booking Details: ");
        JLabel nameLabel = new JLabel("Name: ");
        JTextField customerName = new JTextField();
        JLabel guestListLabel = new JLabel("Guest List:");
        JTextArea guestList = new JTextArea();
        JLabel startDateDayLabel = new JLabel("Start Date Day: ");
        JTextField startDateDay = new JTextField();
        JLabel startDateMonthLabel = new JLabel("Start Date Month: ");
        JTextField startDateMonth = new JTextField();
        JLabel startDateYearLabel = new JLabel("Start Date Year: ");
        JTextField startDateYear = new JTextField();
        JLabel endDateDayLabel = new JLabel("End Date Day: ");
        JTextField endDateDay = new JTextField();
        JLabel endDateMonthLabel = new JLabel("End Date Month: ");
        JTextField endDateMonth = new JTextField();
        JLabel endDateYearLabel = new JLabel("End Date Year: ");
        JTextField endDateYear = new JTextField();
        JLabel roomLabel = new JLabel("Room ID: ");
        JTextField room = new JTextField();
        JLabel roomSizeLabel = new JLabel("Room size: ");
        JTextField roomSize = new JTextField();

        editBookingPanel.add(bookingDetials);
        editBookingPanel.setLayout(new GridLayout(0, 2));
        editBookingPanel.add(nameLabel);
        editBookingPanel.add(customerName);
        editBookingPanel.add(guestListLabel);
        editBookingPanel.add(guestList);
        editBookingPanel.add(startDateDayLabel);
        editBookingPanel.add(startDateDay);
        editBookingPanel.add(startDateMonthLabel);
        editBookingPanel.add(startDateMonth);
        editBookingPanel.add(startDateYearLabel);
        editBookingPanel.add(startDateYear);
        editBookingPanel.add(endDateDayLabel);
        editBookingPanel.add(endDateDay);
        editBookingPanel.add(endDateMonthLabel);
        editBookingPanel.add(endDateMonth);
        editBookingPanel.add(endDateYearLabel);
        editBookingPanel.add(endDateYear);
        editBookingPanel.add(roomLabel);
        editBookingPanel.add(room);
        editBookingPanel.add(roomSizeLabel);
        editBookingPanel.add(roomSize);

        return editBookingPanel;
    }

    public void editBooking(Booking aBooking) {
        cardLayout.show(cardPanel, "Edit a Booking");
    }
}
