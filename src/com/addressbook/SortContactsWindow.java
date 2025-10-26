package com.addressbook;

import javax.swing.*;

/**
 * Shows sorted list (A-Z) after performing sort on backend.
 */
public class SortContactsWindow {
    public SortContactsWindow(AddressBook ab) {
        JFrame frame = new JFrame("Sort Contacts A–Z");
        frame.setSize(520, 480);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 460, 360);

        JButton sortBtn = new JButton("Sort & Show");
        sortBtn.setBounds(80, 400, 120, 30);
        JButton closeBtn = new JButton("Close");
        closeBtn.setBounds(360, 400, 120, 30);

        frame.add(scroll); frame.add(sortBtn); frame.add(closeBtn);
        frame.setVisible(true);

        sortBtn.addActionListener(e -> {
            ab.sortContacts();
            java.util.ArrayList<Contact> all = ab.getAllContacts();
            StringBuilder sb = new StringBuilder();
            int idx = 1;
            for (Contact c : all) {
                sb.append(idx++).append(". ").append(c.toString()).append("\n");
            }
            area.setText(sb.toString());
            JOptionPane.showMessageDialog(frame, "Contacts sorted A–Z.");
        });

        closeBtn.addActionListener(e -> frame.dispose());
    }
}
