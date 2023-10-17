/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotelbookingsystem.gui;

import java.util.HashSet;

/**
 *
 * @author jenni
 */
public interface IDatabaseRetriever {
    public HashSet<Room> getRooms();
    public HashSet<Person> getAdmins();
    public Person getExsistingCustomer(Booking booking);
    public HashSet<Booking> getBookings();
    public void closeConnection();
}
