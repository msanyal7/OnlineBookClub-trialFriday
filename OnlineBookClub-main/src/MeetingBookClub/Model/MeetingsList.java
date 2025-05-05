package MeetingBookClub.Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingsList  {

    /**
     * List of meetings
     */
    private List<MeetingInterface> meetingList;
    private static MeetingsList same;


    /**
     * Constructor
     */

    public MeetingsList() {
        this.meetingList = new ArrayList<>();
        meetingList.add(new Meeting(new Date(12/4/2003), new Time(12,30,0),"Hunger Games","www.zoom.com"));
        meetingList.add(new Meeting(new Date(12/4/2025), new Time(12,30,0),"Catcher in the Rye","www.zoom.com"));
    }

    public static MeetingsList getInstance(){
        if (same==null){
            same = new MeetingsList();
        }
        return same;
    }


    public void addMeetingtoList (MeetingInterface meeting){
        meetingList.add(meeting);
    }



    /**
     * deleting
     */

   public void deleteMeetingFromList(MeetingInterface meeting){
     meetingList.remove(meeting);
   }

   public List<MeetingInterface> getMeetingList(){
       return meetingList;
   }


}
