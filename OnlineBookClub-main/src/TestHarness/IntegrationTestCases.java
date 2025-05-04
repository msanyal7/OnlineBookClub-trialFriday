package TestHarness;

import Channels.Model.Channel;
import Channels.Model.Comment;
import Channels.View.ChannelView;
import Homepage.Model.Book;
import UserAuthentication.Model.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class IntegrationTestCases {
    public IntegrationTestCases(){

    }
    public void testAddChanneltoSubscribedList() {
        User user = new User("testUser");
        Channel channel = new Channel("Fantasy Club");

        user.subscribeToChannel(channel);

        if (user.getSubscribedChannels().contains(channel)) {
            System.out.println("TC-01 Passed: Channel successfully added to subscribed list.");
        } else {
            System.out.println("TC-01 Failed: Channel NOT found in subscribed list.");
        }
    }

    public void testSendMessageInChannel(){
        User user = new User("Aria");
        Channel channel = new Channel("Fantasy Club");
        String messageText = "I love this book!";
        Comment comment = new Comment(user.getUsername(), messageText);

        // Action
        channel.addComment(comment);

        // Check
        Comment lastComment = channel.getChannelComments()
                .get(channel.getChannelComments().size() - 1);

        if (lastComment.getUserName().equals(user.getUsername()) &&
                lastComment.getUserComment().equals(messageText)) {
            System.out.println("TC-02 Passed: Comment successfully added to channel.");
        } else {
            System.out.println("TC-02 Failed: Comment mismatch.");
        }
    }
}
