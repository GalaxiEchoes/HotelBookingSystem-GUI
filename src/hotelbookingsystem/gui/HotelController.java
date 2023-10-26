/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JTextField bookings = (JTextField) e.getSource();
        JCheckBox addAdmin = (JCheckBox) e.getSource();
        JList result = (JList) e.getSource();
        
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
            
            
            
        } else if (pressedButton.getText().equals("Search")) {
           
        } else if (pressedButton.getText().equals("Edit")){
          
            
        }

    }

}
