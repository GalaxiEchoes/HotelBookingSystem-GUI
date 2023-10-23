/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author berri
 */
public class HotelController implements ActionListener{
    
    private ModelManager model;
    private LogInManager loginM;
    private GUIManager gui;
    
    public HotelController()
    {
        model = new ModelManager();
        loginM = new LogInManager();
        gui = new GUIManager();
    }
    
    
    public void action(){
        gui.l
    }
    
    private boolean loginData(String username, String password){
        if(model.getAdmin().contains(username)){
             if( loginM.login(model.getAdmin, password, username)){
                 return true;
             }
             return false;
        }
        return false;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
