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
                        "1. Harshit Goel (Main Dashboard)\n" +
                        "2. Paras Kumar (Add Contact)\n" +
                        "3. Udayan Nakoti C (Search/Update)\n" +
                        "4. Pardeksha Yadav (View/Delete/Sort)\n\n" +
                        "Project: Address Book Application \n"

        );
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(10, 10, 390, 180);
        frame.add(scroll);

        frame.setVisible(true);
    }
}
