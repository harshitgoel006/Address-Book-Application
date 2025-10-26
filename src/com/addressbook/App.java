package com.addressbook;

public class App {
    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        javax.swing.SwingUtilities.invokeLater(() -> new MainWindow(ab));
    }
}
