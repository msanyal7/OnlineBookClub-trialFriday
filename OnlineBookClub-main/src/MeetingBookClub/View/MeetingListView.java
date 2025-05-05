package MeetingBookClub.View;

import javax.swing.*;
import java.awt.*;

public class MeetingListView extends JPanel{


    private JLabel MeetingListTitle;

    public JLabel getMeetingListTitle() {
        return MeetingListTitle;
    }

    public void setMeetingListTitle(JLabel meetingListTitle) {
        MeetingListTitle = meetingListTitle;
    }

    public JList getListofMeetings() {
        return ListofMeetings;
    }

    public void setListofMeetings(JList listofMeetings) {
        ListofMeetings = listofMeetings;
    }

    public JButton getAddToList() {
        return AddToList;
    }

    public void setAddToList(JButton addToList) {
        AddToList = addToList;
    }

    private JList ListofMeetings;
    private JButton AddToList;

    public JPanel getJPanell() {
        return JPanell;
    }

    public void setJPanell(JPanel JPanell) {
        this.JPanell = JPanell;
    }

    private JPanel JPanell;

    public JButton getDelete_meeting_button() {
        return delete_meeting_button;
    }

    public void setDelete_meeting_button(JButton delete_meeting_button) {
        this.delete_meeting_button = delete_meeting_button;
    }

    private JButton delete_meeting_button;



    public MeetingListView(){
        createComponents();
    }

    public void createComponents(){
        MeetingListTitle = new JLabel("Meeting List");
        ListofMeetings = new JList<>(new DefaultListModel<>());
        AddToList = new JButton("Add Meeting");
        delete_meeting_button = new JButton("Delete Meeting");

        JPanell = new JPanel();
        JPanell.setLayout(new BorderLayout());
        // buttons now with better format
        JPanell.add(MeetingListTitle,BorderLayout.PAGE_START);
        JPanell.add(new JScrollPane(ListofMeetings),BorderLayout.CENTER);
        //buttons buttons
        JPanell.add(AddToList,BorderLayout.AFTER_LINE_ENDS);
        JPanell.add(delete_meeting_button,BorderLayout.AFTER_LAST_LINE);
        /*
        JPanell.add(MeetingListTitle);
        JPanell.add(new JScrollPane(ListofMeetings));
        JPanell.add(AddToList);
        JPanell.add(delete_meeting_button);

         */

    }
}
