package hotelbookingsystem.gui;

import javax.swing.SwingUtilities;

/**
 *
 * @author mgk3508
 */
public class HotelBookingSystemGUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HotelController controller = new HotelController();
                GUIManager viewManager = new GUIManager(controller);
                controller.addView(viewManager);
                viewManager.setVisible(true);
            }
        });
    }
}
