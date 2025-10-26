package com.addressbook;

import javax.swing.*;

/**
 * Delete contact by name with confirmation
 */
public class DeleteContactWindow {
    public DeleteContactWindow(AddressBook ab, Runnable onChange) {
        JFrame frame = new JFrame("Delete Contact");
        frame.setSize(420, 200);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Enter name to delete:");
        nameLabel.setBounds(20, 30, 140, 25);
        JTextField nameTF = new JTextField();
        nameTF.setBounds(170, 30, 220, 25);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(100, 90, 100, 35);
        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(240, 90, 100, 35);

        frame.add(nameLabel); frame.add(nameTF);
        frame.add(deleteBtn); frame.add(clearBtn);

        frame.setVisible(true);

        deleteBtn.addActionListener(e -> {
            String name = nameTF.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Enter a name to delete.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int conf = JOptionPane.showConfirmDialog(frame, "Delete contact '" + name + "'?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                boolean removed = ab.deleteContact(name);
                if (removed) {
                    JOptionPane.showMessageDialog(frame, "Contact deleted.");
                    if (onChange != null) onChange.run();
                    nameTF.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Contact not found.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        clearBtn.addActionListener(e -> nameTF.setText(""));
    }
}
