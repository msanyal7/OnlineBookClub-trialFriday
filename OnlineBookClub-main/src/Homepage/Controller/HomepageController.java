package Homepage.Controller;

import Homepage.Model.Homepage;
import Homepage.View.HomepageView;
import UserAuthentication.Controller.UserProfileController;
import UserAuthentication.Model.User;
import UserAuthentication.View.UserProfileView;
import javax.swing.*;


public class HomepageController {

    private Homepage model;
    private HomepageView view;
    User user = new User("admin", "werna@com", "1234");

    public HomepageController(Homepage model, HomepageView view) {
        this.model = model;
        this.view = view;
        homepageTabs();
    }
    private void homepageTabs() {
        for (String tabTitle : model.getTabTitles()) {
            switch (tabTitle) {
                case "Profile":
                    UserProfileView userProfileView = new UserProfileView();
                    UserProfileController profileController = new UserProfileController(user, userProfileView);
                    view.addTab(tabTitle, userProfileView);
                    break;
            }
        }
        view.showView(); // Ensure the frame is made visible
    }




}