package MeetingBookClub.View;

import javax.swing.*;

public class MeetingListView {


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
    private JButton delete_meeting_button;

    public MeetingListView(){
        createComponents();
    }

    public void createComponents(){
        MeetingListTitle = new JLabel("Meeting List");
        ListofMeetings = new JList<>(new DefaultListModel<>());
        AddToList = new JButton("Add Meeting");
        JPanell = new JPanel();
        JPanell.add(MeetingListTitle);
        JPanell.add(new JScrollPane(ListofMeetings));
        JPanell.add(AddToList);
        this.JPanell.setSize(100,200);
    }
}
