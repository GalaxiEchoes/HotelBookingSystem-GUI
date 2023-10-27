/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author berri
 */
public class HotelController implements ActionListener {

    private final ModelManager model;
    private final LogInManager loginM;
    private final GUIManager gui;
    private Room selectedRoom;
    private Booking selectedBooking;
    private boolean isAdmin = false;

    public HotelController() {
        model = new ModelManager();
        loginM = new LogInManager();
        gui = new GUIManager();
    }

    private boolean loginData(String username, String password) {
        if (model.findStaff(username).equals(username)) {
            if (loginM.checkLogin(model.findStaff(username), username, password)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void setSelectedRoom(Room selectedRoom) {
        this.selectedRoom = selectedRoom;
    }

    public void setSelectedBooking(Booking selectedBooking) {
        this.selectedBooking = selectedBooking;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressedButton = (JButton) e.getSource();
        JTextField usernameInput = (JTextField) e.getSource();
        JTextField passwordInput = (JTextField) e.getSource();
        JCheckBox addAdmin = (JCheckBox) e.getSource();
        DefaultListModel<Room> listModel = new DefaultListModel<>();
        JList list = (JList) e.getSource();
        AbstractButton selectedButton = (AbstractButton) e.getSource();
        JTextField startDate = (JTextField) e.getSource();
        JTextField endDate = (JTextField) e.getSource();
        JTextField name = (JTextField) e.getSource();
        JTextField email = (JTextField) e.getSource();
        JTextField phoneNumber = (JTextField) e.getSource();
        JTextArea guestList = (JTextArea) e.getSource();

        if (pressedButton.getText().equals("Login")) {
            if (loginData(usernameInput.getText(), passwordInput.getText())) {
                if (loginM.checkAdmin(model.findStaff(usernameInput.getText()))) {
                    isAdmin = true;
                    gui.adminMenu();

                } else {
                    isAdmin = false;
                    gui.mainMenu();
                }
            }
        } else if (pressedButton.getText().equals("Make a Booking")) {
            gui.makeBooking();
        } else if (pressedButton.getText().equals("Find a Booking")) {
            gui.searchBooking();
        } else if (pressedButton.getText().equals("Add Staff")) {
            gui.addStaff();
        } else if (pressedButton.getText().equals("Add")) {
            if (addAdmin.isSelected()) {
                model.saveNewStaff(ObjectFactory.createStaff("Admin", usernameInput.getText(), passwordInput.getText()));
            } else {
                model.saveNewStaff(ObjectFactory.createStaff("User", usernameInput.getText(), passwordInput.getText()));
            }
            gui.adminMenu();
        } else if (pressedButton.getText().equals("Submit")) {//to finalise the booking and add the booking to database

            Booking booking = null;
            try {
                booking = new Booking((guestList.getText()),
                        (ObjectFactory.createCustomer(name.getText(), email.getText(), phoneNumber.getText())),
                        (model.getRoomByID(selectedRoom.roomID)),
                        (ObjectFactory.createDate(Integer.parseInt(startDate.getText(0, 2)), Integer.parseInt(startDate.getText(3, 2)), Integer.parseInt(startDate.getText(6, 4)))),
                        (ObjectFactory.createDate(Integer.parseInt(endDate.getText(0, 2)), Integer.parseInt(endDate.getText(3, 2)), Integer.parseInt(endDate.getText(6, 4))))
                );
            } catch (BadLocationException ex) {
                Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
            model.saveNewBooking(booking);
            model.invoiceBooking(booking);

        } else if (pressedButton.getText().equals("Search")) {
            Booking aBooking = null;
            try {
                aBooking = new Booking((guestList.getText()),
                        (ObjectFactory.createCustomer(name.getText(), email.getText(), phoneNumber.getText())),
                        (model.getRoomByID(selectedRoom.roomID)),
                        (ObjectFactory.createDate(Integer.parseInt(startDate.getText(0, 2)), Integer.parseInt(startDate.getText(3, 2)), Integer.parseInt(startDate.getText(6, 4)))),
                        (ObjectFactory.createDate(Integer.parseInt(endDate.getText(0, 2)), Integer.parseInt(endDate.getText(3, 2)), Integer.parseInt(endDate.getText(6, 4))))
                );
            } catch (BadLocationException ex) {
                Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
            model.findBooking(aBooking);

        } else if (pressedButton.getText().equals("Edit")) {

            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        Booking selectedBooking = (Booking) list.getSelectedValue();
                        setSelectedBooking(selectedBooking);
                    }
                }
            });
            gui.editBooking();
            startDate.setText(selectedBooking.getStringStartDate());
            endDate.setText(selectedBooking.getStringEndDate());
            name.setText(selectedBooking.getCustomer().getName());
            email.setText(selectedBooking.getCustomer().getEmail());
            phoneNumber.setText(selectedBooking.getCustomer().getPhoneNumber());
            guestList.setText(selectedBooking.getGuestNotes());

        } else if (selectedButton.getText().equals("Single Room")) {
            try {
                for (Room room : model.findAvailableRooms((ObjectFactory.createDate(Integer.parseInt(startDate.getText(0, 2)), Integer.parseInt(startDate.getText(3, 2)), Integer.parseInt(startDate.getText(6, 4)))), (ObjectFactory.createDate(Integer.parseInt(endDate.getText(0, 2)), Integer.parseInt(endDate.getText(3, 2)), Integer.parseInt(endDate.getText(6, 4)))))) {

                    listModel.addElement(room);
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        Room selectedRoom = (Room) list.getSelectedValue();
                        setSelectedRoom(selectedRoom);
                    }
                }
            });
        } else if (selectedButton.getText().equals("Double Room")) {
            try {
                for (Room room : model.findAvailableRooms((ObjectFactory.createDate(Integer.parseInt(startDate.getText(0, 2)), Integer.parseInt(startDate.getText(3, 2)), Integer.parseInt(startDate.getText(6, 4)))), (ObjectFactory.createDate(Integer.parseInt(endDate.getText(0, 2)), Integer.parseInt(endDate.getText(3, 2)), Integer.parseInt(endDate.getText(6, 4)))))) {
                    listModel.addElement(room);
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        Room selectedRoom = (Room) list.getSelectedValue();
                        setSelectedRoom(selectedRoom);
                    }
                }
            });
        } else if (selectedButton.getText().equals("Suite")) {
            try {
                for (Room room : model.findAvailableRooms((ObjectFactory.createDate(Integer.parseInt(startDate.getText(0, 2)), Integer.parseInt(startDate.getText(3, 2)), Integer.parseInt(startDate.getText(6, 4)))), (ObjectFactory.createDate(Integer.parseInt(endDate.getText(0, 2)), Integer.parseInt(endDate.getText(3, 2)), Integer.parseInt(endDate.getText(6, 4)))))) {
                    listModel.addElement(room);
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
            }

            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        Room selectedRoom = (Room) list.getSelectedValue();
                        setSelectedRoom(selectedRoom);
                    }
                }
            });
        } else if (pressedButton.getText().equals("Update Detials")) {
            selectedBooking.setCustomer(ObjectFactory.createCustomer(name.getText(), email.getText(), phoneNumber.getText()));
            selectedBooking.setRoom(selectedRoom);
            selectedBooking.setGuestNotes(guestList.getText());
            try {
                selectedBooking.setStartDate(Integer.parseInt(startDate.getText(0, 2)), Integer.parseInt(startDate.getText(3, 2)), Integer.parseInt(startDate.getText(6, 4)));
            } catch (BadLocationException ex) {
                Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                selectedBooking.setEndDate(Integer.parseInt(endDate.getText(0, 2)), Integer.parseInt(endDate.getText(3, 2)), Integer.parseInt(endDate.getText(6, 4)));
            } catch (BadLocationException ex) {
                Logger.getLogger(HotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
            model.updateBooking(selectedBooking);
            model.invoiceBooking(selectedBooking);
            gui.mainMenu();

        } else if (pressedButton.getText().equals("Delete Booking")) {
            model.deleteBooking(model.findBookingById(selectedBooking.getBookingID()));
        } else if (pressedButton.getText().equals("Logout")) {
            gui.login();
        } else if (pressedButton.getText().equals("Main Menu")) {
            if (isAdmin) {
                gui.adminMenu();
            } else {
                gui.mainMenu();
            }
        }
    }
}
