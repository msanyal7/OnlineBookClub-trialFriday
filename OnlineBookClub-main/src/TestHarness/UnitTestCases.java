package TestHarness;

import MeetingBookClub.Model.Meeting;
import MeetingBookClub.Model.MeetingsList;
import UserAuthentication.Controller.AddPaymentController;
import UserAuthentication.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTestCases {

    private AddPaymentController addPaymentController;
    private User user;

    @BeforeEach
    public void setUp() {
        // Initialize User object and AddPaymentController
        user = new User();  // Assuming the User class has a method to set payment info
        addPaymentController = new AddPaymentController();


    }

    @Test
    public void testStorePaymentInformation() {
        String firstName = "Britney";
        String lastName = "Wang";
        String creditCardNumber = "1234567890123456"; // Example credit card number
        String expirationDate = "12/25";

        addPaymentController.getFirstNameInput().setText(firstName);
        addPaymentController.getLastNameInput().setText(lastName);
        addPaymentController.getCreditCardInput().setText(creditCardNumber);
        addPaymentController.getExpDateInput().setText(expirationDate);

        addPaymentController.getSaveSubmitButton().doClick();

        assertEquals(firstName, addPaymentController.getFirstName());
        assertEquals(lastName, addPaymentController.getLastName());
        assertEquals(creditCardNumber, addPaymentController.getCreditCardNumber());
        assertEquals(expirationDate, addPaymentController.getExpirationDate());
    }

    public void testMeetingSize () {
        MeetingsList meetingsList = new MeetingsList();

        int size = meetingsList.getMeetingList().size();

        Date date = new Date(2025,3,25);
        Time time = new Time(1,30,00);
        Meeting meeting = new Meeting(date, time, "Meeting Test", "www.meetingTest.com");

        meetingsList.addMeetingtoList(meeting);

        int sizeCheck = meetingsList.getMeetingList().size();

        if (sizeCheck==size+1){
            System.out.println("Meeting Incremented ");
        }
        else {
            System.out.println("Meeting did not increment");
        }

    }
}
