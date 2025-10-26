package com.addressbook;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Lists all contacts in scrollable text area (with refresh button)
 */
public class ViewAllContactsWindow {
    public ViewAllContactsWindow(AddressBook ab) {
        JFrame frame = new JFrame("All Contacts");
        frame.setSize(520, 480);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 460, 360);

        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(50, 400, 100, 30);
        JButton closeBtn = new JButton("Close");
        closeBtn.setBounds(370, 400, 100, 30);

        frame.add(scroll); frame.add(refreshBtn); frame.add(closeBtn);
        frame.setVisible(true);

        refreshDisplay(ab, area);

        refreshBtn.addActionListener(e -> refreshDisplay(ab, area));
        closeBtn.addActionListener(e -> frame.dispose());
    }

    private void refreshDisplay(AddressBook ab, JTextArea area) {
        ArrayList<Contact> all = ab.getAllContacts();
        StringBuilder sb = new StringBuilder();
        if (all.isEmpty()) {
            sb.append("No contacts.\n");
        } else {
            int idx = 1;
            for (Contact c : all) {
                sb.append(idx++).append(". ").append(c.toString()).append("\n");
            }
        }
        area.setText(sb.toString());
    }
}
