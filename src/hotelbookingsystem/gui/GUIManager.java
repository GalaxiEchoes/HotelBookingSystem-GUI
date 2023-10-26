/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author berri
 */
public class GUIManager extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public GUIManager() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        

        cardPanel.add(createLogin(), "Login");
        cardPanel.add(createMainMenu(), "Main Menu");
        cardPanel.add(createAdminMenu(), "Admin Menu");
        cardPanel.add(createMakeBooking(), "Make Booking");
        cardPanel.add(createSearchBooking(), "Search for Booking");
        cardPanel.add(createAddStaff(), "Add Staff");
        cardPanel.add(createEditBooking(new Booking()), "Edit Booking");

    }

    public JPanel createLogin() {
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

        return loginPanel;
    }

    public JPanel createMainMenu() {
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

    public JPanel createAdminMenu() {
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

    public JPanel createAddStaff() {
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

    public JPanel createMakeBooking() {
        JPanel makeBookingPanel = new JPanel();
         
        JLabel bookingDetials = new JLabel("Booking Details: ");
        JLabel nameLabel = new JLabel("Name: ");
        JTextField customerName = new JTextField("Eneter name");
        JLabel guestListLabel = new JLabel("Email: ");
        JTextField guestList = new JTextField("Add guest List");
        JLabel startDateLabel = new JLabel("Start Date: ");
        JTextField startDate = new JTextField("Enter starting date");
        JLabel endDateLabel = new JLabel("End Date: ");
        JTextField endDate = new JTextField("Enter end date");
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
        makeBookingPanel.add(endDate);
        makeBookingPanel.add(roomSizeLabel);
   

        return makeBookingPanel;
    }

    public void makeBooking() {
        cardLayout.show(cardPanel, "Make a Booking");
    }

    public JPanel createSearchBooking() {
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

    public JPanel createEditBooking(Booking aBooking) {
        JPanel editBookingPanel = new JPanel();
        JLabel bookingDetials = new JLabel("Booking Details: ");
        JLabel nameLabel = new JLabel("Name: ");
        JTextField customerName = new JTextField(aBooking.getCustomer().name);
        JLabel guestListLabel = new JLabel("Email: ");
        JTextField guestList = new JTextField(aBooking.getGuestNotes());
        JLabel startDateLabel = new JLabel("Start Date(dd/mm/yy): ");
        JTextField startDate = new JTextField(aBooking.getStartDate().toString());
        JLabel endDateLabel = new JLabel("End Date(dd/mm/yy): ");
        JTextField endDate = new JTextField(aBooking.getEndDate().toString());
        JLabel roomLabel = new JLabel("Room ID: ");
        JTextField room = new JTextField(aBooking.getRoom().roomID);
        JLabel roomSizeLabel = new JLabel("Room size: ");
        JTextField roomSize = new JTextField(aBooking.getRoom().getSize());

        editBookingPanel.add(bookingDetials);
        editBookingPanel.setLayout(new GridLayout(0, 2));
        editBookingPanel.add(nameLabel);
        editBookingPanel.add(customerName);
        editBookingPanel.add(guestListLabel);
        editBookingPanel.add(guestList);
        editBookingPanel.add(startDateLabel);
        editBookingPanel.add(startDate);
        editBookingPanel.add(endDateLabel);
        editBookingPanel.add(endDate);
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
