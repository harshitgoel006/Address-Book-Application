package com.addressbook;

import javax.swing.*;

/**
 * Simple window to show total count; has Refresh button.
 */
public class CountContactsWindow {
    public CountContactsWindow(AddressBook ab) {
        JFrame frame = new JFrame("Total Contacts");
        frame.setSize(300, 180);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel countLabel = new JLabel("Total contacts: " + ab.getCount());
        countLabel.setBounds(60, 30, 200, 30);

        JButton refresh = new JButton("Refresh");
        refresh.setBounds(40, 80, 90, 30);
        JButton close = new JButton("Close");
        close.setBounds(160, 80, 90, 30);

        frame.add(countLabel); frame.add(refresh); frame.add(close);
        frame.setVisible(true);

        refresh.addActionListener(e -> countLabel.setText("Total contacts: " + ab.getCount()));
        close.addActionListener(e -> frame.dispose());
    }
}
