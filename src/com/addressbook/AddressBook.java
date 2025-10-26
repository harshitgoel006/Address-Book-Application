package com.addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Backend logic: store contacts in-memory and provide operations.
 */
public class AddressBook {
    private final ArrayList<Contact> contacts = new ArrayList<>();

    public AddressBook() {
        // Default demo contacts (so app has initial data)
        contacts.add(new Contact("Amit Sharma", "9876543210", "amit@mail.com", "Delhi"));
        contacts.add(new Contact("Riya Verma", "9123456789", "riya@mail.com", "Mumbai"));
        contacts.add(new Contact("Rahul Singh", "9000000000", "rahul@mail.com", "Kolkata"));
    }

    public synchronized void addContact(Contact c) {
        contacts.add(c);
    }

    public synchronized ArrayList<Contact> getAllContacts() {
        // return a copy to avoid external modification
        return new ArrayList<>(contacts);
    }

    public synchronized Contact searchContact(String name) {
        if (name == null) return null;
        for (Contact c : contacts) {
            if (c.getName() != null && c.getName().equalsIgnoreCase(name.trim())) {
                return c;
            }
        }
        return null;
    }

    public synchronized boolean deleteContact(String name) {
        Contact c = searchContact(name);
        if (c != null) {
            contacts.remove(c);
            return true;
        }
        return false;
    }

    public synchronized boolean updateContact(String name, String newPhone, String newEmail, String newAddress) {
        Contact c = searchContact(name);
        if (c != null) {
            if (newPhone != null) c.setPhone(newPhone);
            if (newEmail != null) c.setEmail(newEmail);
            if (newAddress != null) c.setAddress(newAddress);
            return true;
        }
        return false;
    }

    public synchronized void sortContacts() {
        Collections.sort(contacts, Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER));
    }

    public synchronized int getCount() {
        return contacts.size();
    }
}
