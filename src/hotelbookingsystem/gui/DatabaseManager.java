package hotelbookingsystem.gui;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * @author group 53: (Ellena Weissmeyer: 20100580) & (Hendrik Bernardus Kruger: 21151229)
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
    
    /**
     * Creates a new session factory
     * @return SessionFactory
     */
    public static synchronized SessionFactory getSessionFactory() {
        return factory;
    }
    
    /**
     * Creates a new session with session factory
     * @return Session
     */
    public static Session getSession() {
        return factory.openSession();
    }

    /**
     * @param session - Session that is being closed
     */
    public static void closeSession(Session session) {
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
