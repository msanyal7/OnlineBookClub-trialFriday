package MeetingBookClub.Controller;

import MeetingBookClub.Model.MeetingsList;

/**
 * to show list on calendar
 */

public class MeetingsCalendarController {


    /**
     * the calendar will display the list of events in a calendar view
     */

    public MeetingsList meetingsList;



    public MeetingsCalendarController(MeetingsList meetingsList) {
        this.meetingsList = meetingsList;
    }



    public MeetingsList getMeetingsList() {
        return meetingsList;
    }

    public void setMeetingsList(MeetingsList meetingsList) {
        this.meetingsList = meetingsList;
    }





}
