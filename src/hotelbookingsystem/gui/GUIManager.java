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
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author berri
 */
public class GUIManager extends JFrame implements ActionListener {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    LogInManager login;

    public GUIManager() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        login = new LogInManager();

        cardPanel.add(login(), "Login");
        cardPanel.add(mainMenu(), "Main Menu");
        cardPanel.add(adminMenu(), "Admin Menu");
        cardPanel.add(makeBooking(), "Make Booking");
        cardPanel.add(searchBooking(), "Search for Booking");
        cardPanel.add(editBooking(new Booking()), "Edit Booking");

    }

    public JPanel login() {
        JPanel loginPanel = new JPanel();
        JButton submit = new JButton("Submit");
        JTextField username = new JTextField();
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JTextField password = new JTextField();

        loginPanel.add(usernameLabel);
        loginPanel.add(username);
        loginPanel.add(passwordLabel);
        loginPanel.add(password);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (login.login(password.toString(), username.toString())) {

                }
            }
        });
        return loginPanel;
    }

    public JPanel mainMenu() {
        JPanel mainMenuPanel = new JPanel();

        return mainMenuPanel;
    }

    public JPanel adminMenu() {
        JPanel adminMenuPanel = new JPanel();

        return adminMenuPanel;
    }

    public JPanel makeBooking() {
        JPanel makeBookingPanel = new JPanel();

        return makeBookingPanel;
    }

    public JPanel searchBooking() {
        JPanel searchBookingPanel = new JPanel();
        JButton searchButton = new JButton("Search");
        JTextField search = new JTextField();
        JLabel result = new JLabel();

        searchBookingPanel.add(search);
        searchBookingPanel.add(searchButton);
        searchBookingPanel.add(result);

        return searchBookingPanel;
    }

    public JPanel editBooking(Booking aBooking) {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
