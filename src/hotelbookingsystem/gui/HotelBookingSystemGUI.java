package hotelbookingsystem.gui;

import javax.swing.SwingUtilities;

/**
 *
 *
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger:
 * 21151229)
 *
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
