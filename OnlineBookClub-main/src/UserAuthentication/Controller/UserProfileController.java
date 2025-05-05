package UserAuthentication.Controller;

import Channels.Controller.ChannelListController;
import UserAuthentication.Model.User;
import UserAuthentication.View.UserProfileView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileController implements ActionListener {
    private User user;
    private UserProfileView view;


    public UserProfileController(User user, UserProfileView view) {
        this.user = user;
        this.view = view;
        view.displayData(user);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source.equals(view.getUpgradeSubscriptionButton())) {
        openChangeSubscriptionWindow();
        }
//        if(source.equals(view.getChannels())){
//            openChannelList();
//        }
    }

//    private void openChannelList(){
//        ChannelListController channelListController = new ChannelListController(user);
//
//    }
    private void openChangeSubscriptionWindow() {
        SwingUtilities.invokeLater(() -> {
            ChangeSubscriptionController changeSub = new ChangeSubscriptionController();
            JFrame subFrame = new JFrame("Change Subscription");

            subFrame.setContentPane(changeSub.getMainPanel());
            subFrame.setSize(400, 300);
            subFrame.setLocationRelativeTo(null);
            subFrame.setVisible(true);

            changeSub.getChangeButton().addActionListener(evt -> {
                subFrame.dispose();

                openAddPaymentWindow();
            });
        });
    }

    private void openAddPaymentWindow() {
        SwingUtilities.invokeLater(() -> {
            AddPaymentController addPaymentController = new AddPaymentController();
            JFrame paymentFrame = new JFrame("Add Payment Information");

            paymentFrame.setContentPane(addPaymentController.getMainPanel());
            paymentFrame.setSize(400, 300);
            paymentFrame.setLocationRelativeTo(null);
            paymentFrame.setVisible(true);

            addPaymentController.getSaveSubmitButton().addActionListener(evt2 -> {
                String firstName = addPaymentController.getFirstName();
                String lastName = addPaymentController.getLastName();
                String creditCardNumber = addPaymentController.getCreditCardNumber();
                String expirationDate = addPaymentController.getExpirationDate();

                user.changeSubscriptionStatus("Premium");
                view.setStatus("Premium");

                JOptionPane.showMessageDialog(paymentFrame,
                        "Subscription changed to Premium!\nPayment information saved.\n"
                                + "First Name: " + firstName + "\n"
                                + "Last Name: " + lastName + "\n"
                                + "Credit Card: " + creditCardNumber + "\n"
                                + "Expiration Date: " + expirationDate);

                paymentFrame.dispose();
            });
        });
    }
}
