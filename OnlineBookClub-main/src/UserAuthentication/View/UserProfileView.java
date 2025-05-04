package UserAuthentication.View;

import UserAuthentication.Controller.UserProfileController;
import UserAuthentication.Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserProfileView extends JFrame{
    private JPanel pnlRoot;
    private JPanel userInfoPanel;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JLabel subscriptionLabel;
    private JLabel usernameLabel;
    private JTextField userChangeText;
    private JPasswordField passwordField1;
    private JTextField textField2;
    private JLabel statusLabel;
    private JButton changeButton;
    public JButton getChangeBtn(){
        return this.changeButton;
    }

    private JPanel imgPanel;
    private JLabel username;
    private JLabel password;
    private JLabel email;
    private JButton channels;
    public JButton getChannels(){
        return channels;
    }


    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 400;

    public UserProfileView(UserProfileController controller) {
        createComponents();
        addChangeButtonListener(controller);
        addChannelButtonListener(controller);
    }

    public void displayData(User user){
        this.username.setText(user.getUsername());
        this.email.setText(user.getEmail());
        this.password.setText(ParsePasswordString(user.getPassword()));
    }
    public void createComponents() {
        userInfoPanel.setBackground(new Color(161, 218, 216));
        pnlRoot.setBackground(new Color(161, 218, 216));
        this.add(pnlRoot);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("USER PROFILE");

    }

    private String ParsePasswordString(String string){
        StringBuilder asterisks = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            asterisks.append('*');
        }
        return asterisks.toString();
    }
    public void setStatus(String status) {
        statusLabel.setText("Status: " + status);
    }

    // You can leave this in case you want to add functionality later
    public JButton getChangeButton() {
        return changeButton;
    }

    public String getNewUsername() {
        return userChangeText.getText();
    }

    public String getNewPassword() {
        return new String(passwordField1.getPassword());
    }

    public String getNewEmail() {
        return textField2.getText();
    }

    public void addChangeButtonListener(ActionListener listener) {
        changeButton.addActionListener(listener);
    }

    public void addChannelButtonListener(ActionListener listener){
        channels.addActionListener(listener);
    }
}
