package UserAuthentication.Model;

import Channels.Model.Channel;

import java.util.ArrayList;
import java.util.List;

public class UserAuthentication {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public UserAuthentication() {
        // FAKE USERS
        User admin = new User("admin", "admin@example.com", "1234");
        users.add(admin);
        users.add(new User("user", "user@example.com", "pass"));
        users.add(new User("wasabi00"));
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }



    public User register(String username, String email, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return null;
            }
        }
        User newUser = new User(username, email, password);
        users.add(newUser);
        return newUser;
    }

    public void logout(User user) {
        // Placeholder logic
    }


}
