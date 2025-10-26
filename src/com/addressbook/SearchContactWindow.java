package com.addressbook;

import javax.swing.*;

/**
 * Search-only window: enter name and view contact details (read-only)
 */
public class SearchContactWindow {
    public SearchContactWindow(AddressBook ab) {
        JFrame frame = new JFrame("Search Contact");
        frame.setSize(420, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setBounds(30, 30, 90, 25);
        JTextField nameTF = new JTextField();
        nameTF.setBounds(130, 30, 230, 25);

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultArea);
        scroll.setBounds(30, 70, 330, 150);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(80, 230, 100, 30);

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(220, 230, 100, 30);

        frame.add(nameLabel); frame.add(nameTF);
        frame.add(scroll); frame.add(searchBtn); frame.add(clearBtn);

        frame.setVisible(true);

        searchBtn.addActionListener(e -> {
            String name = nameTF.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a name to search.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Contact c = ab.searchContact(name);
            if (c != null) {
                resultArea.setText("Name: " + c.getName() + "\nPhone: " + c.getPhone() + "\nEmail: " + c.getEmail()
                        + "\nAddress: " + c.getAddress());
            } else {
                resultArea.setText("Contact not found.");
            }
        });

        clearBtn.addActionListener(e -> {
            nameTF.setText("");
            resultArea.setText("");
        });
    }
}
