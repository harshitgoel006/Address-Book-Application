package com.addressbook;

import javax.swing.*;

/**
 * Update window: search first, then edit fields and click Update.
 */
public class UpdateContactWindow {
    public UpdateContactWindow(AddressBook ab, Runnable onChange) {
        JFrame frame = new JFrame("Update Contact");
        frame.setSize(440, 370);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel searchLabel = new JLabel("Search Name:");
        searchLabel.setBounds(30, 25, 100, 25);
        JTextField searchTF = new JTextField();
        searchTF.setBounds(140, 25, 230, 25);
        JButton searchBtn = new JButton("Find");
        searchBtn.setBounds(380, 25, 60, 25);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 100, 25);
        JTextField nameTF = new JTextField();
        nameTF.setBounds(140, 70, 300, 25);
        nameTF.setEditable(false); // name is treated as key here

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 110, 100, 25);
        JTextField phoneTF = new JTextField();
        phoneTF.setBounds(140, 110, 300, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 150, 100, 25);
        JTextField emailTF = new JTextField();
        emailTF.setBounds(140, 150, 300, 25);

        JLabel addrLabel = new JLabel("Address:");
        addrLabel.setBounds(30, 190, 100, 25);
        JTextField addrTF = new JTextField();
        addrTF.setBounds(140, 190, 300, 25);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(140, 240, 120, 35);
        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(280, 240, 120, 35);

        frame.add(searchLabel); frame.add(searchTF); frame.add(searchBtn);
        frame.add(nameLabel); frame.add(nameTF);
        frame.add(phoneLabel); frame.add(phoneTF);
        frame.add(emailLabel); frame.add(emailTF);
        frame.add(addrLabel); frame.add(addrTF);
        frame.add(updateBtn); frame.add(clearBtn);

        frame.setVisible(true);

        final Contact[] found = new Contact[1];

        searchBtn.addActionListener(e -> {
            String name = searchTF.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enter name to search.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Contact c = ab.searchContact(name);
            if (c != null) {
                found[0] = c;
                nameTF.setText(c.getName());
                phoneTF.setText(c.getPhone());
                emailTF.setText(c.getEmail());
                addrTF.setText(c.getAddress());
            } else {
                JOptionPane.showMessageDialog(frame, "Contact not found.", "Info", JOptionPane.INFORMATION_MESSAGE);
                nameTF.setText(""); phoneTF.setText(""); emailTF.setText(""); addrTF.setText("");
                found[0] = null;
            }
        });

        updateBtn.addActionListener(e -> {
            if (found[0] == null) {
                JOptionPane.showMessageDialog(frame, "Search and load a contact first.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            // Name is treated as key; we allow editing phone/email/address
            ab.updateContact(found[0].getName(), phoneTF.getText().trim(), emailTF.getText().trim(), addrTF.getText().trim());
            JOptionPane.showMessageDialog(frame, "Contact updated.");
            if (onChange != null) onChange.run();
        });

        clearBtn.addActionListener(e -> {
            searchTF.setText(""); nameTF.setText(""); phoneTF.setText(""); emailTF.setText(""); addrTF.setText("");
            found[0] = null;
        });
    }
}
