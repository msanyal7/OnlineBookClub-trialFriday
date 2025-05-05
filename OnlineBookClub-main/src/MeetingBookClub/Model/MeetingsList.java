package MeetingBookClub.Model;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

        Calendar calendar = Calendar.getInstance();

        calendar.set(2025, Calendar.MAY,2);
        Date date = calendar.getTime();

        calendar.set(Calendar.HOUR,12);
        calendar.set(Calendar.MINUTE,30);
        calendar.set(Calendar.SATURDAY,00);

        Time time = new Time(calendar.getTimeInMillis());
        meetingList.add(new Meeting(date, time,"Hunger Games","www.zoom.com"));
        meetingList.add(new Meeting(date, time,"Catcher in the Rye","www.zoom.com"));
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
