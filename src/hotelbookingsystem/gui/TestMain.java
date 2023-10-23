/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelbookingsystem.gui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.apache.logging.log4j.EventLogger;

/**
 *
 * @author jenni
 */
public class TestMain {
    public static void main(String[] args) {
        org.apache.logging.log4j.LogManager.getContext(false);
        // Create a new customer
        Customer customer = new Customer("John Doe", "john.doe@example.com", "1234567890");

        // Get the session factory
        SessionFactory factory = DatabaseManager.getSessionFactory();

        // Open a new session
        Session session = factory.openSession();

        // Start a new transaction
        Transaction transaction = session.beginTransaction();

        // Save the customer to the database
        session.save(customer);
        
        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();

        // Open a new session
        session = factory.openSession();

        // Start a new transaction
        transaction = session.beginTransaction();

        // Retrieve the customer from the database
        Customer retrievedCustomer = session.get(Customer.class, customer.getPersonId());

        // Print the customer's details to the console
        System.out.println(retrievedCustomer);

        // Delete the customer from the database
        session.delete(retrievedCustomer);

        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();

        // Close the factory
        factory.close();
    }
    
}
