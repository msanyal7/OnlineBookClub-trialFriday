package TestHarness;

import Channels.Model.Channel;
import Channels.Model.Comment;
import Homepage.Model.Book;
import Homepage.Model.Library;
import Homepage.Model.ReadingGoal;
import MeetingBookClub.Model.Meeting;
import SubManagement.Controller.AddPaymentInfo;
import TrackProgress.Model.ReadingProgress;
import UserAuthentication.Model.User;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class TestHarness {
    public TestHarness(){
      IntegrationTestCases integrationTestCases = new IntegrationTestCases();
        integrationTestCases.testAddChanneltoSubscribedList();
        integrationTestCases.testSendMessageInChannel();

        //Unit test cases
        UnitTestCases unitTestCases = new UnitTestCases();
        // testing meeting size
        unitTestCases.testMeetingSize();


        //System Test cases
        SystemTestCases systemTestCases = new SystemTestCases();
        systemTestCases.testMeetingClick();

        //NonFunctional Test Cases
        NonFunctionalTestCases nonFunctionalTestCases = new NonFunctionalTestCases();
        nonFunctionalTestCases.testValidationMessage();
        nonFunctionalTestCases.testAddBookToList();


    }
}
        /*System.out.println("Running Test Harness...:p");
        //Create Users
        User user1 = new User("JDog51");
        User user2 = new User("JillScott");
        User user3 = new User("SereinaW");
        User user4 = new User("John_doe"); // subscription & payment example


        log("Creating Books");
        Image defaultImage = new ImageIcon().getImage();

        Book book1 = new Book(defaultImage, "Queen of Abith", "Amna Cloud", false, 00);
        Book book2 = new Book(defaultImage, "Ray Franke", "Benny Bool", false, 00);
        Book book3 = new Book(defaultImage, "Half of a Yellow Sun", "Chimamanda Adichie", false, 00);

        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();


        log("Creating Book Channels:");
        Channel channel1 = new Channel("For the Yearners", book1, defaultImage);
        Channel channel2 = new Channel("Crime and Mystery", book2, defaultImage);
        Channel channel3 = new Channel("African Literature", book3, defaultImage);

        ArrayList<Channel> channels = new ArrayList<>();

        channels.add(channel1);
        channels.add(channel2);
        channels.add(channel3);

        // Printing the channels
        System.out.println("Subscribed Channels: " + channels);

        //Make Users subscribe to channels
        user1.subscribeToChannel(channel1);
        user1.subscribeToChannel(channel2);

        user2.subscribeToChannel(channel1);
        user2.subscribeToChannel(channel2);
        user2.subscribeToChannel(channel3);

        user3.subscribeToChannel(channel1);
        user3.subscribeToChannel(channel2);
        user3.subscribeToChannel(channel3);

        //creating comments in channel lol
        log("\n Comments in channel 1");
        channel1.addComment(new Comment(user1.getUsername(), "This book is very similar to Onward"));
        channel1.addComment(new Comment(user2.getUsername(), "How would this be similar to a pixar film?"));
        channel1.addComment(new Comment(user1.getUsername(), "I enjoy the use of Metaphors throughout the plot"));
        channel1.showAllCommentsInChannel();

        log("\n Comments in channel 2");
        channel2.addComment(new Comment(user3.getUsername(), "Ray is similar to Dahmer"));
        channel2.addComment(new Comment(user1.getUsername(), "Replying to comment above, Ray is like a very watered-down version"));
        channel2.addComment(new Comment(user2.getUsername(), "I love Ray's character development so much"));
        channel2.addComment(new Comment(user3.getUsername(), "You LIKE a MURDERER'S development?!"));
        channel2.showAllCommentsInChannel();
        user3.unsubscribeFromChannel(channel2);

        log("\n Comments in channel 3");
        channel3.addComment(new Comment(user1.getUsername(), "Chimamanda knows how to right a good conflicted love story"));
        channel3.addComment(new Comment(user2.getUsername(), "War is such an unnecessary thing, but the way we see the specks of it before it blows up"));
        channel3.addComment(new Comment(user3.getUsername(), "I need a movie adaptation ASAP"));
        channel3.addComment(new Comment(user1.getUsername(), "There's a movie on Prime! Me and my cousin just watched it"));
        channel3.showAllCommentsInChannel();


        // Testing Library class
        ArrayList<Book> booksRead = new ArrayList<>();
        ArrayList<Book> booksToRead = new ArrayList<>();

        booksRead.add(book2);
        booksToRead.add(book1);

        Library library = new Library(booksRead, booksToRead);

        System.out.println("Books Read: " + library.getBooksRead().size());
        System.out.println("Books to Read: " + library.getBooksToRead().size());

        // Testing ReadingGoal class
        ReadingGoal goal = new ReadingGoal(5, "Monthly", 1);
        System.out.println("Goal Met? " + goal.isGoalMet());
        goal.incrementBooksRead();
        System.out.println("Books Read: " + goal.getBooksRead());

        // Testing ReadingProgress class
        ReadingProgress progress = new ReadingProgress();
        progress.updateProgress(50);
        System.out.println("Progress: " + progress.getProgressPercentage() + "%");

        // Print initial user details
        System.out.println("Initial User Subscription: " + user4.userSubscription);
        System.out.println("Initial Payment Type: " + user4.paymentType);

        // Changing subscription status
        user4.changeSubscriptionStatus("Premium Plan");

        // Changing payment information
        user4.changePaymentInfo("PayPal", 987654321);

        // You can also test adding payment details
        AddPaymentInfo.addPaymentFullName("John", "Doe");
        AddPaymentInfo.addPaymentType("PayPal");
        AddPaymentInfo.addPaymentInfo(987654321);

        // Print final user details
        System.out.println("\nUpdated User Subscription: " + user4.userSubscription);
        System.out.println("Updated Payment Type: " + user4.paymentType);

        //Testing the Meeting Class
        Date dateTest = Date.from(Instant.now());
        Time timeTest = Time.valueOf("10:48:00");
        String meetingNametest = "Weekly Comic Book Meeting";
        String meetingLinkTest = "www.test.com";

        Meeting meeting = new Meeting(dateTest,timeTest,meetingNametest,meetingLinkTest);

        System.out.println("Testing Meeting model");
        System.out.println("Date:"+ meeting.getMeetingDate());
        System.out.println("Time"+ meeting.getMeetingTime());
        System.out.println("Meeting Name:" + meeting.getMeetingName());
        System.out.println("Meeting Link"+meeting.getMeetingLink());
    }
private void log(String string){
    System.out.println(string);
}
}
*/