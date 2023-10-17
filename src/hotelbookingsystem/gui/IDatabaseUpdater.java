/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hotelbookingsystem.gui;

/**
 *
 * @author jenni
 */
public interface IDatabaseUpdater {
    public void deleteBooking(Booking booking);
    public void addBooking(Booking booking);
    public void updateBooking(Booking oldBooking, Booking newBooking);
    public void closeConnection();
}
