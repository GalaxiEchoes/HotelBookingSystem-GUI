/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author berri
 */
public class HotelController implements ActionListener {

    private ModelManager model;
    private LogInManager loginM;
    private GUIManager gui;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressedButton = (JButton) e.getSource();
        JTextField usernameInput = (JTextField) e.getSource();
        JTextField passwordInput = (JTextField) e.getSource();
        JCheckBox addAdmin = (JCheckBox) e.getSource();
        DefaultListModel<Room> listModel = new DefaultListModel<>();
        AbstractButton selectedButton = (AbstractButton) e.getSource();
        JTextField startDateDay = (JTextField) e.getSource();
        JTextField startDateMonth = (JTextField) e.getSource();
        JTextField startDateYear = (JTextField) e.getSource();
        JTextField endDateDay = (JTextField) e.getSource();
        JTextField endDateMonth = (JTextField) e.getSource();
        JTextField endDateYear = (JTextField) e.getSource();
        JTextField name = (JTextField) e.getSource();
        

        if (pressedButton.getText().equals("Login")) {
            if (loginData(usernameInput.getText(), passwordInput.getText())) {
                if (loginM.checkAdmin(model.findStaff(usernameInput.getText()))) {
                    gui.adminMenu();
                } else {
                    gui.mainMenu();
                }
            }
        } else if (pressedButton.getText().equals("Make a Booking")) {
            gui.makeBooking();
        } else if (pressedButton.getText().equals("Find a Booking")) {

        } else if (pressedButton.getText().equals("Add Staff")) {
            gui.addStaff();
        } else if (pressedButton.getText().equals("Add")) {
            if (addAdmin.isSelected()) {
                model.saveNewStaff(ObjectFactory.createStaff("Admin", usernameInput.getText(), passwordInput.getText()));
            } else {
                model.saveNewStaff(ObjectFactory.createStaff("User", usernameInput.getText(), passwordInput.getText()));
            }
            gui.adminMenu();
        } else if (pressedButton.getText().equals("Submit")) {
            Booking booking = new Booking()
            model.saveNewBooking(booking);
            model.invoiceBooking(booking);  

        } else if (pressedButton.getText().equals("Search")) {

        } else if (pressedButton.getText().equals("Edit")) {

        } else if (selectedButton.getText().equals("Single Room")) {
            for (Room room : model.findAvailableRooms(ObjectFactory.createDate(Integer.parseInt(startDateDay.getText()), Integer.parseInt(startDateMonth.getText()), Integer.parseInt(startDateYear.getText())), ObjectFactory.createDate(Integer.parseInt(endDateDay.getText()), Integer.parseInt(endDateMonth.getText()), Integer.parseInt(endDateYear.getText())))) {
                listModel.addElement(room);
            }
        } else if (selectedButton.getText().equals("Double Room")) {
            for (Room room : model.findAvailableRooms(ObjectFactory.createDate(Integer.parseInt(startDateDay.getText()), Integer.parseInt(startDateMonth.getText()), Integer.parseInt(startDateYear.getText())), ObjectFactory.createDate(Integer.parseInt(endDateDay.getText()), Integer.parseInt(endDateMonth.getText()), Integer.parseInt(endDateYear.getText())))) {
                listModel.addElement(room);
            }
        } else if (selectedButton.getText().equals("Suite")) {
            for (Room room : model.findAvailableRooms(ObjectFactory.createDate(Integer.parseInt(startDateDay.getText()), Integer.parseInt(startDateMonth.getText()), Integer.parseInt(startDateYear.getText())), ObjectFactory.createDate(Integer.parseInt(endDateDay.getText()), Integer.parseInt(endDateMonth.getText()), Integer.parseInt(endDateYear.getText())))) {
                listModel.addElement(room);
            }
        }

    }

}
