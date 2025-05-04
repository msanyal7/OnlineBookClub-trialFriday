package MeetingBookClub.Model;

import java.util.ArrayList;
import java.util.List;

public class MeetingsList  {

    /**
     * List of meetings
     */
    private List<MeetingInterface> meetingList;


    /**
     * Constructor
     */

    public MeetingsList() {
        this.meetingList = new ArrayList<>();
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
