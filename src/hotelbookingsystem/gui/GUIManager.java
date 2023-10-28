package hotelbookingsystem.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashSet;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger:
 * 21151229)
 *
 * public class GUIManager extends JFrame {
 *
 * private final CardLayout cardLayout; private final JPanel cardPanel; private
 * final JPanel controlPanel; private DefaultListModel<Room> roomListModel;
 * private final DefaultListModel<Booking> bookingListModel; private final
 * ModelManager model = new ModelManager(); // HotelController con = new
 * HotelController();
 *
 * public GUIManager() { this.bookingListModel = new
 * DefaultListModel<Booking>(); this.roomListModel = new
 * DefaultListModel<Room>(); JFrame frame = new JFrame("Hotel Booking System");
 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.setSize(600,
 * 600);
 *
 * cardLayout = new CardLayout(); cardPanel = new JPanel(cardLayout);
 * controlPanel = new JPanel();
 *
 * cardPanel.setSize(200, 200); cardPanel.add(createLogin(), "Login");
 * cardPanel.add(createMainMenu(), "Main Menu");
 * cardPanel.add(createAdminMenu(), "Admin Menu");
 * cardPanel.add(createMakeBooking(), "Make Booking");
 * cardPanel.add(createSearchBooking(), "Search for Booking");
 * cardPanel.add(createAddStaff(), "Add Staff");
 * cardPanel.add(createEditBooking(), "Edit Booking");
 *
 * controlPanel.add(controlButton()); controlPanel.setSize(200, 200);
 *
 * frame.add(cardPanel, BorderLayout.NORTH); frame.add(controlPanel,
 * BorderLayout.SOUTH); frame.setVisible(true); cardLayout.show(cardPanel,
 * "Login");
 *
 * }
 *
 * /**
 * makes the loginPanel for the cardLayout frame sets the contorlPanel's
 * visibility to false
 *
 * @return loginPanel
 *
 * private JPanel createLogin() { JPanel loginPanel = new JPanel(); JButton
 * loginButton = new JButton("Login"); JTextField username = new JTextField(50);
 * // username.setSize(WIDTH, HEIGHT); JLabel usernameLabel = new
 * JLabel("Username: "); JLabel passwordLabel = new JLabel("Password: ");
 * JPasswordField password = new JPasswordField(50); // password.setSize(WIDTH,
 * HEIGHT); JLabel invalidInput = new JLabel(" ");
 *
 * loginPanel.add(usernameLabel); loginPanel.add(username);
 * loginPanel.add(passwordLabel, BorderLayout.CENTER); loginPanel.add(password);
 * loginPanel.add(loginButton, BorderLayout.SOUTH);
 * loginPanel.add(invalidInput); controlPanel.setVisible(false);
 * //loginPanel.repaint();
 *
 * loginButton.setActionCommand("Login"); return loginPanel; }
 *
 * /**
 * sets the login as the current displayed panel
 *
 * public void login() { controlPanel.setVisible(false);
 * cardLayout.show(cardPanel, "Login");
 *
 * }
 *
 * /**
 * *
 * makes user mainMenuPanel for the cardLayout frame
 *
 * @return mainMenuPanel
 *
 * private JPanel createMainMenu() { JPanel mainMenuPanel = new JPanel();
 * JButton makeBooking = new JButton("Make a Booking"); JButton findBooking =
 * new JButton("Find a Booking");
 *
 * mainMenuPanel.add(makeBooking); mainMenuPanel.add(findBooking);
 *
 * return mainMenuPanel; }
 *
 * /**
 * sets mainMenu as the current displayed panel
 *
 * public void mainMenu() { controlPanel.setVisible(true);
 * cardLayout.show(cardPanel, "Main Menu"); }
 *
 * /**
 * *
 * makes the AdminMenuPanel for the cardLayout frame add the option of adding
 * staff where normal mainMenu cant add staff
 *
 * @return adminMenuPanel
 *
 * private JPanel createAdminMenu() { JPanel adminMenuPanel = new JPanel();
 * JButton makeBooking = new JButton("Make a Booking"); JButton findBooking =
 * new JButton("Find a Booking"); JButton addStaff = new JButton("Add Staff");
 *
 * adminMenuPanel.add(makeBooking); adminMenuPanel.add(findBooking);
 * adminMenuPanel.add(addStaff);
 *
 * return adminMenuPanel; }
 *
 * /**
 * sets adminMenu to the current displayed panel
 *
 * public void adminMenu() { controlPanel.setVisible(true);
 * cardLayout.show(cardPanel, "Admin Menu"); }
 *
 * /**
 * makes the addStaffPanel for the cardLayout frame
 *
 * @return addStaffPanel
 *
 * private JPanel createAddStaff() { JPanel addStaffPanel = new JPanel();
 * JButton add = new JButton("Add"); JTextField username = new JTextField();
 * JLabel usernameLabel = new JLabel("Username: "); JLabel passwordLabel = new
 * JLabel("Password: "); JCheckBox addAdmin = new JCheckBox("Admin"); JTextField
 * password = new JTextField();
 *
 * addStaffPanel.add(add); addStaffPanel.add(usernameLabel);
 * addStaffPanel.add(username); addStaffPanel.add(passwordLabel);
 * addStaffPanel.add(password); addStaffPanel.add(addAdmin);
 *
 * return addStaffPanel; }
 *
 * /**
 * sets addStaff to the current displayed panel
 *
 * public void addStaff() { cardLayout.show(cardPanel, "Add Staff"); }
 *
 * /**
 * makes the makeBookingPanel where all information for a booking is entered
 *
 * @return makeBookingPanel
 *
 * private JPanel createMakeBooking() { JPanel makeBookingPanel = new JPanel();
 * JButton submit = new JButton("Submit"); JLabel bookingDetials = new
 * JLabel("Booking Details: "); JLabel nameLabel = new JLabel("Name: ");
 * JTextField customerName = new JTextField(); JLabel emailLabel = new
 * JLabel("Email: "); JTextField email = new JTextField(); JLabel numberLabel =
 * new JLabel("Phone Number:"); JTextField phoneNumber = new JTextField();
 * JLabel guestListLabel = new JLabel("Guest List:"); JTextArea guestList = new
 * JTextArea(); JLabel startDateLabel = new JLabel("Start Date (dd/mm/yyyy): ");
 * JComboBox startDay = new JComboBox(); JComboBox startMonth = new JComboBox();
 * JComboBox startYear = new JComboBox(); JLabel endDateLabel = new JLabel("End
 * Date (dd/mm/yyyy)"); JComboBox endDay = new JComboBox(); JComboBox endMonth =
 * new JComboBox(); JComboBox endYear = new JComboBox(); JLabel invalidInput =
 * new JLabel(" ");
 *
 * startDay.addItem("01"); startDay.addItem("02"); startDay.addItem("03");
 * startDay.addItem("04"); startDay.addItem("05"); startDay.addItem("06");
 * startDay.addItem("07"); startDay.addItem("08"); startDay.addItem("09");
 * startDay.addItem("10"); startDay.addItem("11"); startDay.addItem("12");
 * startDay.addItem("13"); startDay.addItem("14"); startDay.addItem("15");
 * startDay.addItem("16"); startDay.addItem("17"); startDay.addItem("18");
 * startDay.addItem("19"); startDay.addItem("20"); startDay.addItem("21");
 * startDay.addItem("22"); startDay.addItem("23"); startDay.addItem("24");
 * startDay.addItem("25"); startDay.addItem("26"); startDay.addItem("27");
 * startDay.addItem("28"); startDay.addItem("29"); startDay.addItem("30");
 * startDay.addItem("31");
 *
 * startMonth.addItem("01"); startMonth.addItem("02"); startMonth.addItem("03");
 * startMonth.addItem("04"); startMonth.addItem("05"); startMonth.addItem("06");
 * startMonth.addItem("07"); startMonth.addItem("08"); startMonth.addItem("09");
 * startMonth.addItem("10"); startMonth.addItem("11"); startMonth.addItem("12");
 *
 * startYear.addItem("2023"); startYear.addItem("2024");
 * startYear.addItem("2025");
 *
 * endDay.addItem("01"); endDay.addItem("02"); endDay.addItem("03");
 * endDay.addItem("04"); endDay.addItem("05"); endDay.addItem("06");
 * endDay.addItem("07"); endDay.addItem("08"); endDay.addItem("09");
 * endDay.addItem("10"); endDay.addItem("11"); endDay.addItem("12");
 * endDay.addItem("13"); endDay.addItem("14"); endDay.addItem("15");
 * endDay.addItem("16"); endDay.addItem("17"); endDay.addItem("18");
 * endDay.addItem("19"); endDay.addItem("20"); endDay.addItem("21");
 * endDay.addItem("22"); endDay.addItem("23"); endDay.addItem("24");
 * endDay.addItem("25"); endDay.addItem("26"); endDay.addItem("27");
 * endDay.addItem("28"); endDay.addItem("29"); endDay.addItem("30");
 * endDay.addItem("31");
 *
 * endMonth.addItem("01"); endMonth.addItem("02"); endMonth.addItem("03");
 * endMonth.addItem("04"); endMonth.addItem("05"); endMonth.addItem("06");
 * endMonth.addItem("07"); endMonth.addItem("08"); endMonth.addItem("09");
 * endMonth.addItem("10"); endMonth.addItem("11"); endMonth.addItem("12");
 *
 * endYear.addItem("2023"); endYear.addItem("2024"); endYear.addItem("2025");
 *
 * //make JPanels for availableRooms, roomList and buttonPanel JPanel
 * availableRooms = new JPanel(); JPanel roomList = new JPanel(); JPanel
 * buttonPanel = new JPanel(); JList roomResult = new JList<>(roomListModel);
 *
 * for (Room room : model.getAllRooms()) { roomListModel.addElement(room); }
 *
 * //make buttons for roomSizes ButtonGroup roomSizeButtons = new
 * ButtonGroup(); JRadioButton singleRoomButton = new JRadioButton("Single
 * Room"); JRadioButton doubleRoomButton = new JRadioButton("Double Room");
 * JRadioButton suiteRoomButton = new JRadioButton("Suite");
 *
 * //add butons to buttonGroup roomSizeButtons.add(suiteRoomButton);
 * roomSizeButtons.add(singleRoomButton); roomSizeButtons.add(doubleRoomButton);
 *
 * //add componets to buttonPanel buttonPanel.setLayout(new GridLayout(3, 1));
 * buttonPanel.add(singleRoomButton); buttonPanel.add(doubleRoomButton);
 * buttonPanel.add(suiteRoomButton);
 *
 * roomList.add(new JScrollPane(roomResult));
 *
 * //add allcomponets to makeBookingPanel availableRooms.add(buttonPanel,
 * BorderLayout.PAGE_START); availableRooms.add(roomList, BorderLayout.CENTER);
 * makeBookingPanel.add(bookingDetials); makeBookingPanel.setLayout(new
 * GridLayout(0, 3)); makeBookingPanel.add(startDateLabel);
 * makeBookingPanel.add(startDay); makeBookingPanel.add(startMonth);
 * makeBookingPanel.add(startYear); makeBookingPanel.add(endDateLabel);
 * makeBookingPanel.add(endDay); makeBookingPanel.add(endMonth);
 * makeBookingPanel.add(endYear); makeBookingPanel.add(availableRooms,
 * BorderLayout.EAST); makeBookingPanel.add(nameLabel);
 * makeBookingPanel.add(customerName); makeBookingPanel.add(emailLabel);
 * makeBookingPanel.add(email); makeBookingPanel.add(numberLabel);
 * makeBookingPanel.add(phoneNumber); makeBookingPanel.add(guestListLabel);
 * makeBookingPanel.add(guestList); makeBookingPanel.add(submit);
 * makeBookingPanel.add(invalidInput);
 *
 * return makeBookingPanel; }
 *
 * /**
 * sets makeBookingPanel to current displayed panel
 *
 * public void makeBooking() { cardLayout.show(cardPanel, "Make a Booking"); }
 *
 * /**
 * the controlPanel is so that a user can either go back to the main menu or log
 * out if an admin is loged in if they press main menu it will go back to admin
 * menu
 *
 * @return buttonPanelPanel
 *
 * private JPanel controlButton() { JPanel buttonPanel = new JPanel(); JButton
 * logout = new JButton("Logout"); JButton mainMenu = new JButton("Main Menu");
 *
 * buttonPanel.add(logout); buttonPanel.add(mainMenu);
 *
 * return buttonPanel; }
 *
 * /**
 * makes the panel for searching for a booking
 *
 * @return searchBookingPanel
 *
 * private JPanel createSearchBooking() { JPanel searchBookingPanel = new
 * JPanel(); JButton searchButton = new JButton("Search"); JLabel nameLabel =
 * new JLabel("Name: "); JTextField customerName = new JTextField(); JLabel
 * emailLabel = new JLabel("Email: "); JTextField email = new JTextField();
 * JLabel numberLabel = new JLabel("Phone Number: "); JTextField phoneNumber =
 * new JTextField(); JLabel guestListLabel = new JLabel("Guest List:");
 * JTextArea guestList = new JTextArea(); JLabel startDateLabel = new
 * JLabel("Start Date (dd/mm/yyyy): "); JComboBox startDay = new JComboBox();
 * JComboBox startMonth = new JComboBox(); JComboBox startYear = new
 * JComboBox(); JLabel endDateLabel = new JLabel("End Date (dd/mm/yyyy)");
 * JComboBox endDay = new JComboBox(); JComboBox endMonth = new JComboBox();
 * JComboBox endYear = new JComboBox(); JLabel invalidInput = new JLabel(" ");
 *
 * startDay.addItem("01"); startDay.addItem("02"); startDay.addItem("03");
 * startDay.addItem("04"); startDay.addItem("05"); startDay.addItem("06");
 * startDay.addItem("07"); startDay.addItem("08"); startDay.addItem("09");
 * startDay.addItem("10"); startDay.addItem("11"); startDay.addItem("12");
 * startDay.addItem("13"); startDay.addItem("14"); startDay.addItem("15");
 * startDay.addItem("16"); startDay.addItem("17"); startDay.addItem("18");
 * startDay.addItem("19"); startDay.addItem("20"); startDay.addItem("21");
 * startDay.addItem("22"); startDay.addItem("23"); startDay.addItem("24");
 * startDay.addItem("25"); startDay.addItem("26"); startDay.addItem("27");
 * startDay.addItem("28"); startDay.addItem("29"); startDay.addItem("30");
 * startDay.addItem("31");
 *
 * startMonth.addItem("01"); startMonth.addItem("02"); startMonth.addItem("03");
 * startMonth.addItem("04"); startMonth.addItem("05"); startMonth.addItem("06");
 * startMonth.addItem("07"); startMonth.addItem("08"); startMonth.addItem("09");
 * startMonth.addItem("10"); startMonth.addItem("11"); startMonth.addItem("12");
 *
 * startYear.addItem("2023"); startYear.addItem("2024");
 * startYear.addItem("2025");
 *
 * endDay.addItem("01"); endDay.addItem("02"); endDay.addItem("03");
 * endDay.addItem("04"); endDay.addItem("05"); endDay.addItem("06");
 * endDay.addItem("07"); endDay.addItem("08"); endDay.addItem("09");
 * endDay.addItem("10"); endDay.addItem("11"); endDay.addItem("12");
 * endDay.addItem("13"); endDay.addItem("14"); endDay.addItem("15");
 * endDay.addItem("16"); endDay.addItem("17"); endDay.addItem("18");
 * endDay.addItem("19"); endDay.addItem("20"); endDay.addItem("21");
 * endDay.addItem("22"); endDay.addItem("23"); endDay.addItem("24");
 * endDay.addItem("25"); endDay.addItem("26"); endDay.addItem("27");
 * endDay.addItem("28"); endDay.addItem("29"); endDay.addItem("30");
 * endDay.addItem("31");
 *
 * endMonth.addItem("01"); endMonth.addItem("02"); endMonth.addItem("03");
 * endMonth.addItem("04"); endMonth.addItem("05"); endMonth.addItem("06");
 * endMonth.addItem("07"); endMonth.addItem("08"); endMonth.addItem("09");
 * endMonth.addItem("10"); endMonth.addItem("11"); endMonth.addItem("12");
 *
 * endYear.addItem("2023"); endYear.addItem("2024"); endYear.addItem("2025");
 *
 * JList result = new JList<>(bookingListModel); JButton edit = new
 * JButton("Edit");
 *
 * for (Booking booking : model.getAllBookings()) {
 * bookingListModel.addElement(booking); }
 *
 * JPanel bookingList = new JPanel(); bookingList.add(new JScrollPane(result));
 * //add all componets to searchBookingPanel searchBookingPanel.add(nameLabel);
 * searchBookingPanel.add(customerName); searchBookingPanel.add(emailLabel);
 * searchBookingPanel.add(email); searchBookingPanel.add(numberLabel);
 * searchBookingPanel.add(phoneNumber); searchBookingPanel.add(guestListLabel);
 * searchBookingPanel.add(guestList); searchBookingPanel.add(startDateLabel);
 * searchBookingPanel.add(startDay); searchBookingPanel.add(startMonth);
 * searchBookingPanel.add(startYear); searchBookingPanel.add(endDateLabel);
 * searchBookingPanel.add(endDay); searchBookingPanel.add(endMonth);
 * searchBookingPanel.add(endYear); searchBookingPanel.add(searchButton);
 * searchBookingPanel.add(bookingList); searchBookingPanel.add(edit);
 * searchBookingPanel.add(invalidInput);
 *
 * return searchBookingPanel; }
 *
 * /**
 * makes searchBookingPanel to current displayed panel
 *
 * public void searchBooking() { cardLayout.show(cardPanel, "Search for
 * Booking"); }
 *
 * /**
 * makes the editBookingPanel
 *
 * @return editBookingPanel
 *
 * private JPanel createEditBooking() { //editBookingPanel and all its componets
 * JPanel editBookingPanel = new JPanel(); JPanel buttonPanel = new JPanel();
 * JButton update = new JButton("Update Detials"); JButton delete = new
 * JButton("Delete Booking"); JLabel bookingDetials = new JLabel("Booking
 * Details: "); JLabel nameLabel = new JLabel("Name: "); JTextField customerName
 * = new JTextField(); JLabel emailLabel = new JLabel("Email: "); JTextField
 * email = new JTextField(); JLabel numberLabel = new JLabel("Phone Number: ");
 * JTextField phoneNumber = new JTextField(); JLabel guestListLabel = new
 * JLabel("Guest List:"); JTextArea guestList = new JTextArea(); JLabel
 * startDateLabel = new JLabel("Start Date (dd/mm/yyyy): "); JComboBox startDay
 * = new JComboBox(); JComboBox startMonth = new JComboBox(); JComboBox
 * startYear = new JComboBox(); JLabel endDateLabel = new JLabel("End Date
 * (dd/mm/yyyy)"); JComboBox endDay = new JComboBox(); JComboBox endMonth = new
 * JComboBox(); JComboBox endYear = new JComboBox(); JLabel invalidInput = new
 * JLabel(" ");
 *
 * startDay.addItem("01"); startDay.addItem("02"); startDay.addItem("03");
 * startDay.addItem("04"); startDay.addItem("05"); startDay.addItem("06");
 * startDay.addItem("07"); startDay.addItem("08"); startDay.addItem("09");
 * startDay.addItem("10"); startDay.addItem("11"); startDay.addItem("12");
 * startDay.addItem("13"); startDay.addItem("14"); startDay.addItem("15");
 * startDay.addItem("16"); startDay.addItem("17"); startDay.addItem("18");
 * startDay.addItem("19"); startDay.addItem("20"); startDay.addItem("21");
 * startDay.addItem("22"); startDay.addItem("23"); startDay.addItem("24");
 * startDay.addItem("25"); startDay.addItem("26"); startDay.addItem("27");
 * startDay.addItem("28"); startDay.addItem("29"); startDay.addItem("30");
 * startDay.addItem("31");
 *
 * startMonth.addItem("01"); startMonth.addItem("02"); startMonth.addItem("03");
 * startMonth.addItem("04"); startMonth.addItem("05"); startMonth.addItem("06");
 * startMonth.addItem("07"); startMonth.addItem("08"); startMonth.addItem("09");
 * startMonth.addItem("10"); startMonth.addItem("11"); startMonth.addItem("12");
 *
 * startYear.addItem("2023"); startYear.addItem("2024");
 * startYear.addItem("2025");
 *
 * endDay.addItem("01"); endDay.addItem("02"); endDay.addItem("03");
 * endDay.addItem("04"); endDay.addItem("05"); endDay.addItem("06");
 * endDay.addItem("07"); endDay.addItem("08"); endDay.addItem("09");
 * endDay.addItem("10"); endDay.addItem("11"); endDay.addItem("12");
 * endDay.addItem("13"); endDay.addItem("14"); endDay.addItem("15");
 * endDay.addItem("16"); endDay.addItem("17"); endDay.addItem("18");
 * endDay.addItem("19"); endDay.addItem("20"); endDay.addItem("21");
 * endDay.addItem("22"); endDay.addItem("23"); endDay.addItem("24");
 * endDay.addItem("25"); endDay.addItem("26"); endDay.addItem("27");
 * endDay.addItem("28"); endDay.addItem("29"); endDay.addItem("30");
 * endDay.addItem("31");
 *
 * endMonth.addItem("01"); endMonth.addItem("02"); endMonth.addItem("03");
 * endMonth.addItem("04"); endMonth.addItem("05"); endMonth.addItem("06");
 * endMonth.addItem("07"); endMonth.addItem("08"); endMonth.addItem("09");
 * endMonth.addItem("10"); endMonth.addItem("11"); endMonth.addItem("12");
 *
 * endYear.addItem("2023"); endYear.addItem("2024"); endYear.addItem("2025");
 *
 * //make Jpanel for availableRooms, roomlist,radioButtonPanel JPanel
 * availableRooms = new JPanel(); JPanel roomList = new JPanel(); JPanel
 * radioButtonPanel = new JPanel(); JList result = new JList<>(roomListModel);
 * for (Room room : model.getAllRooms()) { roomListModel.addElement(room); }
 * //make buttonGroup for radioButtons for roomsizes ButtonGroup roomSizeButtons
 * = new ButtonGroup(); JRadioButton singleRoomButton = new JRadioButton("Single
 * Room"); JRadioButton doubleRoomButton = new JRadioButton("Double Room");
 * JRadioButton suiteRoomButton = new JRadioButton("Suite");
 *
 * //add the radioButtons to buttonGroup roomSizeButtons.add(suiteRoomButton);
 * roomSizeButtons.add(singleRoomButton); roomSizeButtons.add(doubleRoomButton);
 *
 * //set layout off raidoButtonPanel and add the radioButtons to it
 * radioButtonPanel.setLayout(new GridLayout(3, 1));
 * radioButtonPanel.add(singleRoomButton);
 * radioButtonPanel.add(doubleRoomButton);
 * radioButtonPanel.add(suiteRoomButton);
 *
 * //add ScrollPane for roomlist roomList.add(new JScrollPane(result));
 *
 * //add radioButtonPanel and roomlist to availableRooms panel
 * availableRooms.add(radioButtonPanel, BorderLayout.PAGE_START);
 * availableRooms.add(roomList, BorderLayout.CENTER);
 *
 * //add buttons to buttonPanel buttonPanel.add(update);
 * buttonPanel.add(delete);
 *
 * //adds all panels and componets to editbookingPanel
 * editBookingPanel.add(bookingDetials); editBookingPanel.add(buttonPanel,
 * BorderLayout.PAGE_END); editBookingPanel.setLayout(new GridLayout(0, 3));
 * editBookingPanel.add(startDateLabel); editBookingPanel.add(startDay);
 * editBookingPanel.add(startMonth); editBookingPanel.add(startYear);
 * editBookingPanel.add(endDateLabel); editBookingPanel.add(endDay);
 * editBookingPanel.add(endMonth); editBookingPanel.add(endYear);
 * editBookingPanel.add(invalidInput); editBookingPanel.add(availableRooms,
 * BorderLayout.EAST); editBookingPanel.add(nameLabel);
 * editBookingPanel.add(customerName); editBookingPanel.add(emailLabel);
 * editBookingPanel.add(email); editBookingPanel.add(numberLabel);
 * editBookingPanel.add(phoneNumber); editBookingPanel.add(guestListLabel);
 * editBookingPanel.add(guestList); editBookingPanel.add(buttonPanel,
 * BorderLayout.SOUTH);
 *
 * return editBookingPanel; }
 *
 * /**
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
     * makes the admin menu for the cardLayout
     * which has the added add staff button
     *
     * @return loginPanel
     */
    private JPanel createAdminMenu() {
        adminMenuPanel = new JPanel(new GridBagLayout());
        addComponent(adminMenuPanel, new JLabel("Welcome to Hotel Booking System Main Menu"), 0, 0);

        //log out Button
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setActionCommand("Log Out");
        logoutButton.addActionListener(controllerListener);
        addComponent(adminMenuPanel, logoutButton, 0, 4);

        //make a booking button
        JButton makeBookingButton = new JButton("Make Booking");
        makeBookingButton.setActionCommand("Make Booking");
        makeBookingButton.addActionListener(controllerListener);
        addComponent(adminMenuPanel, makeBookingButton, 0, 1);

        //search/edit booking buttons
        JButton searchOrEditBooking = new JButton("Search/Edit Booking");
        searchOrEditBooking.setActionCommand("Search/Edit Booking");
        searchOrEditBooking.addActionListener(controllerListener);
        addComponent(adminMenuPanel, searchOrEditBooking, 0, 2);

        //add staff button
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

        //menu button
        JButton menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        menuButton.addActionListener(controllerListener);
        addComponent(makeBookingPanel, menuButton, 0, 1);

        //find rooms button
        JButton findRoomsButton = new JButton("Find Rooms");
        findRoomsButton.setActionCommand("Find Rooms");
        findRoomsButton.addActionListener(controllerListener);
        addComponent(makeBookingPanel, findRoomsButton, 4, 2);

        //submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(controllerListener);
        addComponent(makeBookingPanel, submitButton, 4, 7);

        return makeBookingPanel;
    }

    /**
     * makes the search for booking panel
     * 
     * @return searchBookingPanel
     */
    private JPanel createSearchBooking() {
        searchBookingPanel = new JPanel(new GridBagLayout());
        searchBookingPanel.add(new JLabel("Search Booking"));

        //menu button
        JButton menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        menuButton.addActionListener(controllerListener);
        addComponent(searchBookingPanel, menuButton, 0, 0);

        //search button
        JButton searchButton = new JButton("Search");
        searchButton.setActionCommand("Search");
        searchButton.addActionListener(controllerListener);
        addComponent(searchBookingPanel, searchButton, 1, 0);

        //edit button
        JButton editButton = new JButton("Edit");
        editButton.setActionCommand("Edit");
        editButton.addActionListener(controllerListener);
        addComponent(searchBookingPanel, editButton, 2, 0);

        return searchBookingPanel;
    }

    /**
     * 
     * @return 
     */
    private JPanel createAddStaff() {
        addStaffPanel = new JPanel(new GridBagLayout());
        addStaffPanel.add(new JLabel("Add Staff"));

        JButton menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        menuButton.addActionListener(controllerListener);
        addComponent(addStaffPanel, menuButton, 0, 0);

        JButton addUserButton = new JButton("Submit User");
        addUserButton.setActionCommand("Submit User");
        addUserButton.addActionListener(controllerListener);
        addComponent(addStaffPanel, addUserButton, 1, 0);

        JButton addAdminButton = new JButton("Submit Admin");
        addAdminButton.setActionCommand("Submit Admin");
        addAdminButton.addActionListener(controllerListener);
        addComponent(addStaffPanel, addAdminButton, 2, 0);

        return addStaffPanel;
    }

    private JPanel createEditBooking() {
        editBookingPanel = new JPanel(new GridBagLayout());
        editBookingPanel.add(new JLabel("Edit Booking"));

        JButton menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        menuButton.addActionListener(controllerListener);
        addComponent(editBookingPanel, menuButton, 0, 0);

        JButton saveButton = new JButton("Save Changes");
        saveButton.setActionCommand("Save Changes");
        saveButton.addActionListener(controllerListener);
        addComponent(editBookingPanel, saveButton, 0, 3);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setActionCommand("Delete");
        deleteButton.addActionListener(controllerListener);
        addComponent(editBookingPanel, deleteButton, 0, 5);

        return editBookingPanel;
    }

    public void switchToLogin() {
        clearAllText();
        addComponent(loginPanel, name, 0, 0);
        addComponent(loginPanel, password, 0, 1);
        addComponent(loginPanel, warningMessages, 0, 2);

        //Refresh
        loginPanel.revalidate();
        loginPanel.repaint();
        cardLayout.show(cardPanel, "Login");
    }

    public void switchToMenu() {
        cardLayout.show(cardPanel, "Main Menu");
    }

    public void switchToAdminMenu() {
        cardLayout.show(cardPanel, "Admin Menu");
    }

    public void switchToMakeBooking() {
        clearAllText();
        addComponent(makeBookingPanel, name, 1, 1);
        addComponent(makeBookingPanel, email, 2, 1);
        addComponent(makeBookingPanel, phoneNumber, 3, 1);
        addComponent(makeBookingPanel, warningMessages, 0, 5);
        addComponent(makeBookingPanel, rooms, 4, 3);
        addComponent(makeBookingPanel, startDay, 1, 2);
        addComponent(makeBookingPanel, startMonth, 2, 2);
        addComponent(makeBookingPanel, startYear, 3, 2);
        addComponent(makeBookingPanel, endDay, 1, 3);
        addComponent(makeBookingPanel, endMonth, 2, 3);
        addComponent(makeBookingPanel, endYear, 3, 3);
        addComponent(makeBookingPanel, guestListScrollPane, 4, 4);

        //Refresh
        makeBookingPanel.revalidate();
        makeBookingPanel.repaint();
        cardLayout.show(cardPanel, "Make Booking");
    }

    public void switchToSearchBooking(HashSet<Room> allRooms) {
        clearAllText();
        addComponent(searchBookingPanel, name, 1, 1);
        addComponent(searchBookingPanel, email, 2, 1);
        addComponent(searchBookingPanel, phoneNumber, 3, 1);
        addComponent(searchBookingPanel, bookingID, 4, 1);
        addComponent(searchBookingPanel, warningMessages, 0, 5);
        addComponent(searchBookingPanel, rooms, 4, 3);
        addComponent(searchBookingPanel, startDay, 1, 2);
        addComponent(searchBookingPanel, startMonth, 2, 2);
        addComponent(searchBookingPanel, startYear, 3, 2);
        addComponent(searchBookingPanel, endDay, 1, 3);
        addComponent(searchBookingPanel, endMonth, 2, 3);
        addComponent(searchBookingPanel, endYear, 3, 3);

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

    public void switchToEditBooking(Booking booking, HashSet<Room> availableRooms) {
        clearAllText();
        name.setText(booking.getCustomer().getName());
        email.setText(booking.getCustomer().getEmail());
        phoneNumber.setText(booking.getCustomer().getPhoneNumber());
        warningMessages.setText("");
        for (Room r : availableRooms) {
            rooms.addItem(r);
        }
        rooms.setSelectedItem(booking.getRoom());
        int[] startDate = ObjectFactory.convertDateToIntArray(booking.getStartDate());
        startDay.setSelectedItem(startDate[0]);
        startMonth.setSelectedItem(startDate[1]);
        startYear.setSelectedItem(startDate[2]);
        int[] endDate = ObjectFactory.convertDateToIntArray(booking.getEndDate());
        endDay.setSelectedItem(endDate[0]);
        endMonth.setSelectedItem(endDate[1]);
        endYear.setSelectedItem(endDate[2]);

        addComponent(editBookingPanel, bookingID, 2, 0);
        addComponent(editBookingPanel, name, 1, 2);
        addComponent(editBookingPanel, email, 1, 3);
        addComponent(editBookingPanel, phoneNumber, 1, 4);
        addComponent(editBookingPanel, warningMessages, 0, 5);
        addComponent(editBookingPanel, rooms, 4, 6);
        addComponent(editBookingPanel, startDay, 1, 5);
        addComponent(editBookingPanel, startMonth, 2, 5);
        addComponent(editBookingPanel, startYear, 3, 5);
        addComponent(editBookingPanel, endDay, 1, 6);
        addComponent(editBookingPanel, endMonth, 2, 6);
        addComponent(editBookingPanel, endYear, 3, 6);
        addComponent(editBookingPanel, guestListScrollPane, 1, 2);

        //Refresh
        editBookingPanel.revalidate();
        editBookingPanel.repaint();
        cardLayout.show(cardPanel, "Edit Booking");
    }

    public void switchToAddStaff() {
        clearAllText();
        addComponent(addStaffPanel, name, 0, 0);
        addComponent(addStaffPanel, password, 0, 1);
        addComponent(addStaffPanel, warningMessages, 0, 2);

        //Refresh
        addStaffPanel.revalidate();
        addStaffPanel.repaint();
        cardLayout.show(cardPanel, "Add Staff");
    }

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

    private void initializeFields() {
        Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 10, 31};
        Integer[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Integer[] years = {2023, 2024, 2025};

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

        name.setText("");
        email.setText("");
        phoneNumber.setText("");
        guestList.setText("");
        password.setText("");
        warningMessages.setText("");
    }

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

    public Booking getSelectedSearchBooking() {
        if (bookings.getItemCount() > 0) {
            return (Booking) bookings.getSelectedItem();
        }

        return null;
    }

    public String[] getLogin() {
        String[] loginInfo = new String[2];
        loginInfo[0] = name.getText();
        loginInfo[1] = new String(password.getPassword());

        return loginInfo;
    }

    public void clearAllText() {
        bookingID.setText("");
        name.setText("");
        email.setText("");
        phoneNumber.setText("");
        guestList.setText("");
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

    public void LoginUserError() {
        warningMessages.setText("Incorrect Username or Password, please check Report.");

        //Refresh
        loginPanel.revalidate();
        loginPanel.repaint();
    }

    public void StaffUserError() {
        warningMessages.setText("Username must be unique, please try another.");

        //Refresh
        addStaffPanel.revalidate();
        addStaffPanel.repaint();
    }

    public void DateUserError() {
        warningMessages.setText("Start date must be before end date, please try again.");

        //Refresh
        makeBookingPanel.revalidate();
        makeBookingPanel.repaint();
        searchBookingPanel.revalidate();
        searchBookingPanel.repaint();
        editBookingPanel.revalidate();
        editBookingPanel.repaint();
    }

    public void FieldsEmptyError() {
        warningMessages.setText("All fields must be filled");

        //refresh
        makeBookingPanel.revalidate();
        makeBookingPanel.repaint();
        searchBookingPanel.revalidate();
        searchBookingPanel.repaint();
        editBookingPanel.revalidate();
        editBookingPanel.repaint();
    }

    private void addComponent(JPanel panel, JComponent component, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(component, gbc);
    }
}
