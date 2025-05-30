package Homepage.Controller;

import Channels.Controller.ChannelListController;
import Channels.View.ChannelListView;
import Homepage.Model.Homepage;
import Homepage.Model.Library;
import Homepage.View.HomepageView;
import MeetingBookClub.Controller.MeetingListViewController;
import MeetingBookClub.Model.MeetingsList;
import MeetingBookClub.View.MeetingListView;
import TrackProgress.Controller.LibraryController;
//<<<<<<< Updated upstream
import TrackProgress.Model.ReadingProgress;
import TrackProgress.View.AddBookForm;
//=======
//>>>>>>> Stashed changes
import TrackProgress.View.LibraryView;
import UserAuthentication.Controller.AddPaymentController;
import UserAuthentication.Controller.ChangeSubscriptionController;
import UserAuthentication.Controller.UserProfileController;
import UserAuthentication.Model.User;
import UserAuthentication.View.UserProfileView;
import javax.swing.*;
import java.awt.*;


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
                case "Reading Progress":
                    ReadingProgress readingProgress = new ReadingProgress();
                    LibraryView libraryView = new LibraryView();
                    AddBookForm addBookFormView = new AddBookForm();
                    LibraryController libraryController = new LibraryController(readingProgress, libraryView, addBookFormView);
                    view.addTab(tabTitle, libraryView.getPanel());
                    break;
                case "Profile":
                    UserProfileView userProfileView = new UserProfileView();
                    ChangeSubscriptionController changeSubscriptionController = new ChangeSubscriptionController();
                    AddPaymentController addPaymentController = new AddPaymentController();
                    UserProfileController profileController = new UserProfileController(user, userProfileView);
                    view.addTab(tabTitle, userProfileView);
                    break;
                case "Meetings":
                    MeetingsList meetingsList = new MeetingsList();
                    MeetingListView meetingListView = new MeetingListView();
                    MeetingListViewController meetingListViewController = new MeetingListViewController(meetingsList, meetingListView);
                    view.addTab(tabTitle, meetingListView.getJPanell());
                    break;
                case "Channels":
                    //ChannelListView channelListView = new ChannelListView(user);
                    JPanel channelsTab = new JPanel(new BorderLayout());
                    ChannelListController channelListController = new ChannelListController(user, channelsTab);
                    //channelsTab = channelListController.getChannelListView().getPanel();
                    view.addTab(tabTitle, channelsTab);
                    break;
            }
        }
        view.showView();
    }




}