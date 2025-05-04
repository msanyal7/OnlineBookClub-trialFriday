package UserAuthentication.Model;

import Channels.Model.Channel;
import Homepage.Model.Library;
import Homepage.Model.ReadingGoal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private String password;
    private List<ReadingGoal> readingGoals;
    private ArrayList<Channel> subscribedChannels;
    private Library library;
    private boolean subscriptionStatus;
    public String paymentType;
    private int paymentInfo;
    public String userSubscription;
    private ImageIcon profilePicture;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.subscribedChannels = new ArrayList<>();
    }

    public User(String username) {
        this.username = username;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public ArrayList<Channel> getSubscribedChannels() {
        if (subscribedChannels == null) {
            subscribedChannels = new ArrayList<>();
        }
        return subscribedChannels;
    }

    public void subscribeToChannel(Channel channel) {
        if (!getSubscribedChannels().contains(channel)) {
            subscribedChannels.add(channel);
            System.out.println(getUsername() + " Subscribed to: " + channel.getChannelName());
        }
    }

    public void unsubscribeFromChannel(Channel channel) {
        if (getSubscribedChannels().remove(channel)) {
            System.out.println(getUsername() + " Unsubscribed from: " + channel.getChannelName());
        }
    }

    public void changeSubscriptionStatus(String newSubscriptionStatus) {
        this.userSubscription = newSubscriptionStatus;
    }

    public void changePaymentInfo(String newPaymentType, int newPaymentInfo) {
        this.paymentType = newPaymentType;
        this.paymentInfo = newPaymentInfo;
    }
}