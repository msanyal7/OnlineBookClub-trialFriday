package MeetingBookClub.Model;

import java.sql.Time;
import java.util.Date;

public class MakeMeetings {
    public static MeetingInterface createMeeting(Date meetingDate, Time meetingTime, String meetingName, String meetingLink){
        return new Meeting(meetingDate,meetingTime,meetingName,meetingLink);
    }
}
