package MeetingBookClub.Model;

import java.sql.Time;
import java.util.Date;

public class Meeting implements MeetingInterface {

    /**
     * Following variables are used in the meeting feature
     */

    public Date meetingDate;
    public Time meetingTime;
    public String meetingName;
    public String meetingLink;

    /**
     * Constructor
     * @param meetingDate
     * @param meetingTime
     * @param meetingName
     * @param meetingLink
     */

    public Meeting(Date meetingDate, Time meetingTime, String meetingName, String meetingLink) {
        this.meetingDate = meetingDate;
        this.meetingTime = meetingTime;
        this.meetingName = meetingName;
        this.meetingLink = meetingLink;
    }

    /**
     * Getters
     * @return
     */
    @Override
    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }
    @Override
    public Time getMeetingTime() {
        return meetingTime;
    }

    /**
     * setters
     * @param meetingTime
     */

    public void setMeetingTime(Time meetingTime) {
        this.meetingTime = meetingTime;
    }
    @Override
    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }
    @Override
    public String getMeetingLink() {
        return meetingLink;
    }

    public void setMeetingLink(String meetingLink) {
        this.meetingLink = meetingLink;
    }

    /**
     * CRUD operations
     */

    @Override
    public String getMeeting (){
        return meetingName + meetingDate;
    }

    public String toString() {
        return "MEETING: "+ meetingName;
    }

}
