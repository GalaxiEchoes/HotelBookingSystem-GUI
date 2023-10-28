package hotelbookingsystem.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger:
 * 21151229)
 *
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
        JPasswordField passwordInput = (JPasswordField) e.getSource();
        JCheckBox addAdmin = (JCheckBox) e.getSource();
        DefaultListModel<Room> listModel = new DefaultListModel<>();
        JList list = (JList) e.getSource();
        AbstractButton selectedButton = (AbstractButton) e.getSource();
        JComboBox startDay = (JComboBox) e.getSource();
        JComboBox startMonth = (JComboBox) e.getSource();
        JComboBox startYear = (JComboBox) e.getSource();
        JComboBox endDay = (JComboBox) e.getSource();
        JComboBox endMonth = (JComboBox) e.getSource();
        JComboBox endYear = (JComboBox) e.getSource();
        JTextField name = (JTextField) e.getSource();
        JTextField email = (JTextField) e.getSource();
        JTextField phoneNumber = (JTextField) e.getSource();
        JTextArea guestList = (JTextArea) e.getSource();
        JLabel invalidInput = (JLabel) e.getSource();

        if (pressedButton.getText().equals("Login")) {
            if (loginData(usernameInput.getText(), passwordInput.getText())) {
                if (loginM.checkAdmin(model.findStaff(usernameInput.getText()))) {
                    isAdmin = true;
                    gui.adminMenu();

                } else {
                    isAdmin = false;
                    gui.mainMenu();
                }
            } else {
                invalidInput.setText("invalid input");
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
            if ((ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))).before(ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString())))) {

                booking = new Booking((guestList.getText()),
                        (ObjectFactory.createCustomer(name.getText(), email.getText(), phoneNumber.getText())),
                        (model.getRoomByID(selectedRoom.roomID)),
                        (ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))),
                        (ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString())))
                );

                model.saveNewBooking(booking);
                model.invoiceBooking(booking);
            } else {
                invalidInput.setText("invalid input");
            }

        } else if (pressedButton.getText().equals("Search")) {
            Booking aBooking = null;

            if ((ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))).before(ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString())))) {

                aBooking = new Booking((guestList.getText()),
                        (ObjectFactory.createCustomer(name.getText(), email.getText(), phoneNumber.getText())),
                        (model.getRoomByID(selectedRoom.roomID)),
                        (ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))),
                        (ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString())))
                );
                model.findBooking(aBooking);
            } else {
                invalidInput.setText("invalid input");
            }

        } else if (pressedButton.getText().equals("Edit")) {

            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        Booking selectedBooking = (Booking) list.getSelectedValue();
                        setSelectedBooking(selectedBooking);
                        list.repaint();
                    }
                }
            });
            gui.editBooking();
            int[] startDateArray = model.convertDateToIntArray(selectedBooking.getStartDate());
            int[] endDateArray = model.convertDateToIntArray(selectedBooking.getEndDate());
            startDay.setSelectedItem(startDateArray[0]);
            startMonth.setSelectedItem(startDateArray[1]);
            startYear.setSelectedItem(startDateArray[2]);
            endDay.setSelectedItem(endDateArray[0]);
            endMonth.setSelectedItem(endDateArray[1]);
            endYear.setSelectedItem(endDateArray[2]);
            name.setText(selectedBooking.getCustomer().getName());
            email.setText(selectedBooking.getCustomer().getEmail());
            phoneNumber.setText(selectedBooking.getCustomer().getPhoneNumber());
            guestList.setText(selectedBooking.getGuestNotes());

        } else if (selectedButton.getText().equals("Single Room")) {

            if ((ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))).before(ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString())))) {

                for (Room room : model.findAvailableRooms((ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))), (ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString()))))) {
                    listModel.addElement(room);
                }
            } else {
                invalidInput.setText("invalid input");
            }

            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        Room selectedRoom = (Room) list.getSelectedValue();
                        setSelectedRoom(selectedRoom);
                        list.repaint();
                    }
                }
            });
        } else if (selectedButton.getText().equals("Double Room")) {

            if ((ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))).before(ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString())))) {

                for (Room room : model.findAvailableRooms((ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))), (ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString()))))) {
                    listModel.addElement(room);
                }
            } else {
                invalidInput.setText("invalid input");
            }

            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        Room selectedRoom = (Room) list.getSelectedValue();
                        setSelectedRoom(selectedRoom);
                        list.repaint();
                    }
                }
            });
        } else if (selectedButton.getText().equals("Suite")) {

            if ((ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))).before(ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString())))) {

                for (Room room : model.findAvailableRooms((ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))), (ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString()))))) {
                    listModel.addElement(room);
                }
            } else {
                invalidInput.setText("invalid input");
            }

            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        Room selectedRoom = (Room) list.getSelectedValue();
                        setSelectedRoom(selectedRoom);
                        list.repaint();
                    }
                }
            });
        } else if (pressedButton.getText().equals("Update Detials")) {
            selectedBooking.setCustomer(ObjectFactory.createCustomer(name.getText(), email.getText(), phoneNumber.getText()));
            selectedBooking.setRoom(selectedRoom);
            selectedBooking.setGuestNotes(guestList.getText());
            if ((ObjectFactory.createDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()))).before(ObjectFactory.createDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString())))) {
                selectedBooking.setStartDate(Integer.parseInt(startDay.getSelectedItem().toString()), Integer.parseInt(startMonth.getSelectedItem().toString()), Integer.parseInt(startYear.getSelectedItem().toString()));
                selectedBooking.setEndDate(Integer.parseInt(endDay.getSelectedItem().toString()), Integer.parseInt(endMonth.getSelectedItem().toString()), Integer.parseInt(endYear.getSelectedItem().toString()));
                model.updateBooking(selectedBooking);
                model.invoiceBooking(selectedBooking);
                gui.mainMenu();
            } else {
                invalidInput.setText("invalid input");
            }

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
}*/
public class HotelController implements ActionListener{
    public enum panelState {
        LoginPanel,
        MenuPanel,
        AdminMenuPanel,
        MakeBookingPanel,
        SearchBookingPanel,
        EditBookingPanel,
        AddStaffPanel,
    }
    
    public GUIManager GUIManager;
    public ModelManager modelManager;
    public LogInManager liManager;
    public panelState currentPanel;
    boolean adminMode;

    public HotelController() {
        this.modelManager = new ModelManager();
        this.liManager = new LogInManager();
        currentPanel = panelState.LoginPanel;
    }
    
    public void addView(GUIManager GUIManager){
        this.GUIManager = GUIManager;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if ("Login".equals(actionCommand)) {
            GUIManager.detatchComponents(currentPanel);
            
            String[] loginInfo = GUIManager.getLogin();
            //Staff staff = modelManager.findStaff(loginInfo[0]);
            //if(liManager.checkLogin(staff, loginInfo[1], loginInfo[0])){
                //adminMode = liManager.checkAdmin(staff);

                //Check login details
                if(adminMode == true){
                    GUIManager.switchToAdminMenu();
                    currentPanel = panelState.AdminMenuPanel;
                } else {
                    GUIManager.switchToMenu();
                    currentPanel = panelState.MenuPanel;
                }
            //}
            
            
        } else if("Log Out".equals(actionCommand)) {
            logOut();
            
        } else if("Make Booking".equals(actionCommand)){
            makeBooking();
            
        } else if("Search/Edit Booking".equals(actionCommand)){
            searchBooking();
            
        } else if("Add Staff".equals(actionCommand)){
            GUIManager.detatchComponents(currentPanel);
            
            
            currentPanel = panelState.AddStaffPanel;
            GUIManager.switchToAddStaff();
            
        } else if("Submit User".equals(actionCommand)){
            GUIManager.detatchComponents(currentPanel);
            
            String[] loginInfo = GUIManager.getLogin();
            if(modelManager.saveNewStaff(ObjectFactory.createStaff("User", loginInfo[0], loginInfo[1])) == false){
                GUIManager.StaffUserError();
            } else{
                if(adminMode == true){
                    GUIManager.switchToAdminMenu();
                    currentPanel = panelState.AdminMenuPanel;
                } else {
                    GUIManager.switchToMenu();
                    currentPanel = panelState.MenuPanel;
                }
            }
            
        } else if("Submit Admin".equals(actionCommand)){
            GUIManager.detatchComponents(currentPanel);

            String[] loginInfo = GUIManager.getLogin();
            if(modelManager.saveNewStaff(ObjectFactory.createStaff("Admin", loginInfo[0], loginInfo[1])) == false) {
                GUIManager.StaffUserError();
            } else{
                if(adminMode == true){
                    GUIManager.switchToAdminMenu();
                    currentPanel = panelState.AdminMenuPanel;
                } else {
                    GUIManager.switchToMenu();
                    currentPanel = panelState.MenuPanel;
                }
            }
             
        } else if("Menu".equals(actionCommand)){
            menu();
            
        } else if("Find Rooms".equals(actionCommand)){
            Booking booking = GUIManager.getBooking();
            if(booking != null){
                HashSet<Room> rooms = modelManager.findAvailableRooms(booking.getStartDate(), booking.getEndDate());
                GUIManager.showRoomsFound(rooms);
            } else {
                GUIManager.DateUserError();
            }
        } else if("Submit".equals(actionCommand)){
            GUIManager.detatchComponents(currentPanel);
            //grab details and submit
            if(adminMode == true){
                GUIManager.switchToAdminMenu();
                currentPanel = panelState.AdminMenuPanel;
            } else{
                GUIManager.switchToMenu();
                currentPanel = panelState.MenuPanel;
            }
            
        } else if("Search".equals(actionCommand)){
            Booking booking = GUIManager.getBooking();
            
            //Checks if valid object
            if(booking == null){
                GUIManager.DateUserError();
            } else {
                HashSet<Booking> returnedBookings = modelManager.findBooking(booking);
                GUIManager.showBookingsFound(returnedBookings);
            }
            
        } else if("Save Changes".equals(actionCommand)){
            GUIManager.detatchComponents(currentPanel);
            //grab selected booking
            //save changes
            
            if(adminMode == true){
                GUIManager.switchToAdminMenu();
                currentPanel = panelState.AdminMenuPanel;
            } else{
                GUIManager.switchToMenu();
                currentPanel = panelState.MenuPanel;
            }
            
        } else if("Delete".equals(actionCommand)){
            GUIManager.detatchComponents(currentPanel);
            //grab selected booking
            //delete booking
            if(adminMode == true){
                GUIManager.switchToAdminMenu();
                currentPanel = panelState.AdminMenuPanel;
            } else{
                GUIManager.switchToMenu();
                currentPanel = panelState.MenuPanel;
            }
            
        } else if("Edit".equals(actionCommand)){
            Booking booking = GUIManager.getSelectedSearchBooking();
            if(booking != null){
                HashSet<Room> rooms = modelManager.findAvailableRooms(booking.getStartDate(), booking.getEndDate());
                GUIManager.switchToEditBooking(booking, rooms);
                currentPanel = panelState.EditBookingPanel;
            }
        }
        
    }
    
    public void logOut(){
        GUIManager.detatchComponents(currentPanel);
        GUIManager.switchToLogin();
        currentPanel = panelState.LoginPanel;
    }
    
    public void makeBooking(){
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.MakeBookingPanel;
        GUIManager.switchToMakeBooking();
    }
    
    public void searchBooking(){
        GUIManager.detatchComponents(currentPanel);
        currentPanel = panelState.SearchBookingPanel;
        HashSet<Room> allRooms = modelManager.getAllRooms();
        GUIManager.switchToSearchBooking(allRooms);
    }
    
    public void menu(){
        GUIManager.detatchComponents(currentPanel);
        if(adminMode == true){
            GUIManager.switchToAdminMenu();
            currentPanel = panelState.AdminMenuPanel;
        } else{
            GUIManager.switchToMenu();
            currentPanel = panelState.MenuPanel;
        }
    }
    
    

}
