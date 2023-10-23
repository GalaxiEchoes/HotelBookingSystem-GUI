package hotelbookingsystem.gui;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 *
 * @author mgk3508
 */
public class DatabaseManager {
    private static final SessionFactory factory;
    
    static {
        Configuration cfg = new Configuration().configure();
        cfg.addAnnotatedClass(Room.class);
        cfg.addAnnotatedClass(SingleRoom.class);
        cfg.addAnnotatedClass(DoubleRoom.class);
        cfg.addAnnotatedClass(Suite.class);
        cfg.addAnnotatedClass(Booking.class);
        cfg.addAnnotatedClass(Person.class);
        cfg.addAnnotatedClass(Customer.class);
        cfg.addAnnotatedClass(Admin.class);
        factory = cfg.buildSessionFactory();
    }

    public static synchronized SessionFactory getSessionFactory() {
        return factory;
    }
    
    public static Session getSession() {
        return factory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
