package UserAuthentication.Controller;

import javax.swing.*;
import java.awt.*;

public class ChangeSubscriptionController extends JPanel{
    private JPanel mainPanel;
    private JLabel subscriptionLabel;
    private JLabel currentStatusLabel;
    private JLabel statusLabel;
    private JButton changeToPremiumButton;

    public ChangeSubscriptionController() {
        subscriptionLabel = new JLabel("Subscription Status");
        currentStatusLabel = new JLabel("Current:");
        statusLabel = new JLabel("Free");
        changeToPremiumButton = new JButton("Change to Premium");

        // Panel to hold everything
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));
        mainPanel.add(subscriptionLabel);
        mainPanel.add(currentStatusLabel);
        mainPanel.add(statusLabel);
        mainPanel.add(changeToPremiumButton);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getChangeButton() {
        return changeToPremiumButton;
    }

    public void setStatus(String newStatus) {
        statusLabel.setText(newStatus);
    }
}
