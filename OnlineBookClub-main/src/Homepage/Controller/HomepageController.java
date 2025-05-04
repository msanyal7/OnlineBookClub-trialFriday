package Homepage.Controller;

import Homepage.Model.Homepage;
import Homepage.Model.Library;
import Homepage.View.HomepageView;
import TrackProgress.Controller.LibraryController;
//<<<<<<< Updated upstream
import TrackProgress.Model.ReadingProgress;
import TrackProgress.View.AddBookForm;
//=======
//>>>>>>> Stashed changes
import TrackProgress.View.LibraryView;
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
                case "Reading Progress":
                    ReadingProgress readingProgress = new ReadingProgress();
                    LibraryView libraryView = new LibraryView();
                    AddBookForm addBookFormView = new AddBookForm();
                    LibraryController libraryController = new LibraryController(readingProgress, libraryView, addBookFormView);
                    view.addTab(tabTitle, libraryView);
                    break;
            }
        }
        view.showView(); // Ensure the frame is made visible
    }




}