package TestHarness;
import MeetingBookClub.Model.Meeting;
import MeetingBookClub.Model.MeetingsList;
import MeetingBookClub.View.MeetingListView;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.*;
import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
public class SystemTestCases {
    public void testMeetingClick (){
        MeetingsList meetingsList = new MeetingsList();
        MeetingListView meetingListView = new MeetingListView();
        Date date = new Date(2024,3,25);
        Time time = new Time(2,30,00);
        Meeting meeting = new Meeting(date, time, "Meeting Test Click", "www.meetingTestClick.com");

        meetingsList.addMeetingtoList(meeting);

        DefaultListModel<Meeting> list = new DefaultListModel<>();
        list.addElement(meeting);
        meetingListView.getListofMeetings().setModel(list);

        meetingListView.getListofMeetings().setSelectedIndex(0);
        Meeting clickedMeeting = (Meeting) meetingListView.getListofMeetings().getSelectedValue();

        if (clickedMeeting.getMeetingName().equals("Meeting Test Click")){
            System.out.println("meeting can be clicked, test pass");
        }
        else{
            System.out.println("meeting cannot be clicked");
        }

    }



}
