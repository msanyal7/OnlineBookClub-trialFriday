package UserAuthentication.Controller;

import Homepage.Controller.HomepageController;
import Homepage.Model.Book;
import Homepage.Model.Homepage;
import Homepage.View.HomepageView;
import UserAuthentication.Model.User;
import UserAuthentication.Model.UserAuthentication;
import UserAuthentication.View.AuthenticationView;
import UserAuthentication.View.RegisterView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthenticationController {
    private UserAuthentication auth;
    private AuthenticationView view;
    private RegisterView registerView;
    private UserProfileController userProfileController;

    public AuthenticationController(UserAuthentication auth) {
        this.auth = auth;
        this.view = new AuthenticationView(this);
        this.registerView = new RegisterView(new RegisterButtonListener());
        registerView.setVisible(false);


        this.view.addLoginButtonListener(new LoginButtonListener());
        this.view.addRegisterButtonListener(new RegisterButtonListener());
        this.registerView.addRegisterButtonListener(new RegisterButtonListener());
    }

    // This class triggers the homepage to pop up when the user logins
    class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();
            User user = auth.login(username, password);
            if (user != null) {
                HomepageView homepageView = new HomepageView();
                Homepage homepageModel = new Homepage();
                // issue
                HomepageController homepageController = new HomepageController(homepageModel, homepageView);
                view.dispose();
                view.showMessage("Login successful!");
            } else {
                view.showError("Invalid username or password.");
            }
        }
    }

    public class RegisterButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if (source.equals(view.getRegisterButton())) {
                view.setVisible(false);
//                new RegisterView(this);
                registerView.setVisible(true);
            }
            if (source.equals(registerView.getRegisterButton())){
                String username = registerView.getUsername();
                String email = registerView.getEmail();
                String password = registerView.getPassword();

                if (username != null && email != null && password != null) {
                    auth.register(username, email, password);
                    view.showMessage("Registration successful!");
                    //back to login
                    showLoginScreen();
                } else {
                    view.showError("Invalid username or password.");
                }
            }
        }
    }

    public void showLoginScreen(){
        registerView.setVisible(false);
        view.setVisible(true);
    }
}