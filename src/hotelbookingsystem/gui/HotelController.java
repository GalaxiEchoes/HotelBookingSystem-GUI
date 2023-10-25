/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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

        if (pressedButton.getText().equals("Login")) {
            if(loginData(usernameInput.getText().toString(), passwordInput.getText().toString())){
                if(
                  gui.mainMenu();
            }
        }else if (pressedButton.getText().equals("Make a Booking")){
            
        }else if (pressedButton.getText().equals("Find a Booking")){
            
        }else if (pressedButton.getText().equals("Add Staff")){
            
        }else if (pressedButton.getText().equals("Submit")){
            
        }else if(pressedButton.getText().equals("Search")){
            bookings.setText(model.findBooking());
        }else if(pressedButton.getText().equals("View")){
            
        }
        
    }

}
