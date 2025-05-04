import Channels.Controller.ChannelController;
import Channels.Model.Channel;
import MeetingBookClub.Controller.MeetingListViewController;
import MeetingBookClub.Model.MeetingsList;
import MeetingBookClub.View.MeetingListView;
import TestHarness.TestHarness;
import TrackProgress.Controller.LibraryController;
import TrackProgress.Model.ReadingProgress;
import TrackProgress.View.AddBookForm;
import TrackProgress.View.LibraryView;
import UserAuthentication.Controller.AuthenticationController;
import UserAuthentication.Model.User;
import UserAuthentication.Model.UserAuthentication;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new TestHarness();

        // Authenticating User m
        // to test login, you can use the 2 username & password combinations below:

                    // user: admin
                    // pass: 1234

                    // user: user
                    // pass: pass

        UserAuthentication model = new UserAuthentication();
        AuthenticationController controller = new AuthenticationController(model);
//        Channel channel = new Channel("Polstergeese");
        User user = new User("admin", "werna@com", "1234");
//        ChannelController channelController = new ChannelController(channel, user);

//        User model2 = new User();
//        UserProfileView view2 = new UserProfileView();
//        UserProfileController profileController = new UserProfileController(model2, view2);

//        SwingUtilities.invokeLater(() -> {
//            User testUser = new User("admin", "jm", "1234");
//            UserProfileView profileView = new UserProfileView();
//            UserProfileController controller2 = new UserProfileController(testUser, profileView);
//
//            profileView.addChangeButtonListener(controller2.new ChangeButtonListener());
//
//        });


//        ReadingProgress readingProgressModel = new ReadingProgress();
//        LibraryView libraryView = new LibraryView();
//        AddBookForm addBookForm = new AddBookForm();
//        LibraryController libraryController = new LibraryController(readingProgressModel, libraryView, addBookForm);
//





        //Meeting

//        MeetingsList meetingsList = new MeetingsList();
//        MeetingListView meetingListView = new MeetingListView();
//        MeetingListViewController controllerMeeting = new MeetingListViewController(meetingsList, meetingListView);
//        JFrame frame = new JFrame("Meeting Manager");
//        frame.setContentPane(meetingListView.getJPanell());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);


    }
}
