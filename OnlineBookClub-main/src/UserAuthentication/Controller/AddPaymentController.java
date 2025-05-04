package UserAuthentication.Controller;

import javax.swing.*;
import java.awt.*;

public class AddPaymentController {
    private JLabel mainPanel;
    private JLabel paymentLabel;
    private JLabel firstNameLabel;
    private JTextField firstNameInput;
    private JLabel lastNameLabel;
    private JTextField lastNameInput;
    private JLabel creditCardLabel;
    private JTextField creditCardInput;
    private JLabel expDateLabel;
    private JTextField expDateInput;
    private JButton saveSubmitButton;

    public AddPaymentController() {
        // Initialize components
        paymentLabel = new JLabel("Payment Information");
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        creditCardLabel = new JLabel("Credit Card Number:");
        expDateLabel = new JLabel("Expiration Date:");

        firstNameInput = new JTextField(20);
        lastNameInput = new JTextField(20);
        creditCardInput = new JTextField(20);
        expDateInput = new JTextField(10);
        saveSubmitButton = new JButton("Save and Submit");

        // Set up the layout for the payment form
        mainPanel = new JLabel();
        mainPanel.setLayout(new GridLayout(6, 2, 10, 10));

        // Add components to the panel
        mainPanel.add(paymentLabel); // This is the payment label
        mainPanel.add(new JLabel());  // Empty label to balance the layout
        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameInput);
        mainPanel.add(lastNameLabel);
        mainPanel.add(lastNameInput);
        mainPanel.add(creditCardLabel);
        mainPanel.add(creditCardInput);
        mainPanel.add(expDateLabel);
        mainPanel.add(expDateInput);
        mainPanel.add(new JLabel());  // Empty label to balance the layout
        mainPanel.add(saveSubmitButton);
    }

    // Getter for the main panel
    public JLabel getMainPanel() {
        return mainPanel;
    }

    // Getter for the save/submit button
    public JButton getSaveSubmitButton() {
        return saveSubmitButton;
    }

    // Getter methods for the input fields (optional)
    public String getFirstName() {
        return firstNameInput.getText();
    }

    public String getLastName() {
        return lastNameInput.getText();
    }

    public String getCreditCardNumber() {
        return creditCardInput.getText();
    }

    public String getExpirationDate() {
        return expDateInput.getText();
    }

    public JTextField getFirstNameInput() {
        return firstNameInput;
    }

    public JTextField getLastNameInput() {
        return lastNameInput;
    }

    public JTextField getCreditCardInput() {
        return creditCardInput;
    }

    public JTextField getExpDateInput() {
        return expDateInput;
    }

}
