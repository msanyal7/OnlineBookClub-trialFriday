package Homepage.Controller;

import UserAuthentication.Model.User;

public class HomepageController {
    //Attributes
    User userProfile;

    //CONSTRUCTOR
    public HomepageController(User userProfile) {
        this.userProfile = userProfile;
    }


    //METHODS
    public User getUserProfile() {
        return userProfile;
    }
    public void setUserProfile(User userProfile) {
        this.userProfile = userProfile;
    }


        public void displayHomepage() {
            System.out.println("Displaying the Homepage...");
        }
    }

