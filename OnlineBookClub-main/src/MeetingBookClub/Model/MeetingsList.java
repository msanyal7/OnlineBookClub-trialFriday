package MeetingBookClub.Model;

import java.util.ArrayList;
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
        meetingList = new ArrayList<>();
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
