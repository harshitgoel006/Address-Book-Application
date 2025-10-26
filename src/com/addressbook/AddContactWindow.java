package com.addressbook;

import javax.swing.*;

/**
 * Window to add a contact (with Clear)
 */
public class AddContactWindow {
    public AddContactWindow(AddressBook ab, Runnable onChange) {
        JFrame frame = new JFrame("Add Contact");
        frame.setSize(420, 320);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name *:");
        nameLabel.setBounds(30, 30, 100, 25);
        JTextField nameTF = new JTextField();
        nameTF.setBounds(140, 30, 230, 25);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 70, 100, 25);
        JTextField phoneTF = new JTextField();
        phoneTF.setBounds(140, 70, 230, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 110, 100, 25);
        JTextField emailTF = new JTextField();
        emailTF.setBounds(140, 110, 230, 25);

        JLabel addrLabel = new JLabel("Address:");
        addrLabel.setBounds(30, 150, 100, 25);
        JTextField addrTF = new JTextField();
        addrTF.setBounds(140, 150, 230, 25);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(80, 200, 100, 35);
        addBtn.setFocusable(false);

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(220, 200, 100, 35);
        clearBtn.setFocusable(false);

        frame.add(nameLabel); frame.add(nameTF);
        frame.add(phoneLabel); frame.add(phoneTF);
        frame.add(emailLabel); frame.add(emailTF);
        frame.add(addrLabel); frame.add(addrTF);
        frame.add(addBtn); frame.add(clearBtn);

        frame.setVisible(true);

        addBtn.addActionListener(e -> {
            String name = nameTF.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Name is required.", "Validation", JOptionPane.WARNING_MESSAGE);
                return;
            }
            ab.addContact(new Contact(name, phoneTF.getText().trim(), emailTF.getText().trim(), addrTF.getText().trim()));
            JOptionPane.showMessageDialog(frame, "Contact added successfully.");
            if (onChange != null) onChange.run();
            // Clear after add
            nameTF.setText(""); phoneTF.setText(""); emailTF.setText(""); addrTF.setText("");
        });

        clearBtn.addActionListener(e -> {
            nameTF.setText(""); phoneTF.setText(""); emailTF.setText(""); addrTF.setText("");
        });
    }
}
