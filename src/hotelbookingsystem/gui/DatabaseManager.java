/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import hibernateutils.HibernateUtils;
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
}
