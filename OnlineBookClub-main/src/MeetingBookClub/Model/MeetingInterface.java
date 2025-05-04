package MeetingBookClub.Model;

import java.sql.Time;
import java.util.Date;

public interface MeetingInterface {
    String getMeeting();
    Date getMeetingDate();
    Time getMeetingTime();
    String getMeetingName();
    String getMeetingLink();
}
