package com.addressbook;

import javax.swing.*;

/**
 * Simple About / Team info window
 */
public class AboutWindow {
    public AboutWindow() {
        JFrame frame = new JFrame("About");
        frame.setSize(420, 250);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setText(
                "Address Book Application\n\n" +
                        "Team Members:\n" +
                        "1. Member A (Main Dashboard)\n" +
                        "2. Member B (Add Contact)\n" +
                        "3. Member C (Search/Update)\n" +
                        "4. Member D (View/Delete/Sort)\n\n" +
                        "Project: Simple Advanced Java Project (10 marks)\n" +
                        "Data stored in-memory (ArrayList)."
        );
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(10, 10, 390, 180);
        frame.add(scroll);

        frame.setVisible(true);
    }
}
