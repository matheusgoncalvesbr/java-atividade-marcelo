package ContactManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ContactManagerSwing extends JFrame {
    private List<Contact> contacts;
    private DefaultListModel<String> contactListModel;
    private JList<String> contactList;
    private JTextField nameField, phoneField, emailField;

    public ContactManagerSwing() {
        contacts = new ArrayList<>();
        setTitle("Contact Manager - Swing");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        contactListModel = new DefaultListModel<>();
        contactList = new JList<>(contactListModel);
        add(new JScrollPane(contactList), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });
        inputPanel.add(addButton);

        JButton removeButton = new JButton("Remove Contact");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeContact();
            }
        });
        inputPanel.add(removeButton);

        add(inputPanel, BorderLayout.SOUTH);
    }

    private void addContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
            Contact contact = new Contact(name, phone, email);
            contacts.add(contact);
            contactListModel.addElement(contact.toString());
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeContact() {
        int selectedIndex = contactList.getSelectedIndex();
        if (selectedIndex != -1) {
            contacts.remove(selectedIndex);
            contactListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Select a contact to remove", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ContactManagerSwing().setVisible(true);
            }
        });
    }
}
