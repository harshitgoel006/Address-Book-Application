package com.addressbook;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Dashboard with buttons to open each window.
 */
public class MainWindow {
    private final AddressBook addressBook;
    private final JFrame frame;
    private final JLabel countLabel;

    public MainWindow(AddressBook ab) {
        addressBook = ab;
        frame = new JFrame("Address Book - Dashboard");
        frame.setSize(420, 380);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Header / count
        JLabel header = new JLabel("Address Book Application");
        header.setBounds(110, 10, 250, 25);

        countLabel = new JLabel("Total Contacts: " + addressBook.getCount());
        countLabel.setBounds(140, 40, 200, 25);

        // Buttons for windows
        JButton addBtn = new JButton("Add Contact");
        addBtn.setBounds(120, 80, 180, 35);
        addBtn.setFocusable(false);

        JButton searchBtn = new JButton("Search Contact");
        searchBtn.setBounds(120, 125, 180, 35);
        searchBtn.setFocusable(false);

        JButton updateBtn = new JButton("Update Contact");
        updateBtn.setBounds(120, 170, 180, 35);
        updateBtn.setFocusable(false);

        JButton deleteBtn = new JButton("Delete Contact");
        deleteBtn.setBounds(120, 215, 180, 35);
        deleteBtn.setFocusable(false);

        JButton viewBtn = new JButton("View All Contacts");
        viewBtn.setBounds(120, 260, 180, 35);
        viewBtn.setFocusable(false);

        JButton sortBtn = new JButton("Sort A-Z");
        sortBtn.setBounds(20, 305, 120, 30);
        sortBtn.setFocusable(false);

        JButton countWinBtn = new JButton("Count Window");
        countWinBtn.setBounds(150, 305, 120, 30);
        countWinBtn.setFocusable(false);

        JButton aboutBtn = new JButton("About");
        aboutBtn.setBounds(290, 305, 80, 30);
        aboutBtn.setFocusable(false);

        frame.add(header);
        frame.add(countLabel);
        frame.add(addBtn);
        frame.add(searchBtn);
        frame.add(updateBtn);
        frame.add(deleteBtn);
        frame.add(viewBtn);
        frame.add(sortBtn);
        frame.add(countWinBtn);
        frame.add(aboutBtn);

        frame.setVisible(true);

        // On close -> confirmation
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exitConfirm();
            }
        });

        // Button actions
        addBtn.addActionListener(e -> new AddContactWindow(addressBook, this::refreshCount));
        searchBtn.addActionListener(e -> new SearchContactWindow(addressBook));
        updateBtn.addActionListener(e -> new UpdateContactWindow(addressBook, this::refreshCount));
        deleteBtn.addActionListener(e -> new DeleteContactWindow(addressBook, this::refreshCount));
        viewBtn.addActionListener(e -> new ViewAllContactsWindow(addressBook));
        sortBtn.addActionListener(e -> {
            addressBook.sortContacts();
            JOptionPane.showMessageDialog(frame, "Contacts sorted A–Z");
            refreshCount();
        });
        countWinBtn.addActionListener(e -> new CountContactsWindow(addressBook));
        aboutBtn.addActionListener(e -> new AboutWindow());

    }

    private void refreshCount() {
        countLabel.setText("Total Contacts: " + addressBook.getCount());
    }

    private void exitConfirm() {
        int res = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            frame.dispose();
            System.exit(0);
        }
    }
}
