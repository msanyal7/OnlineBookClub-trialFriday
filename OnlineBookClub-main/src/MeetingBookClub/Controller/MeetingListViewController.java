package MeetingBookClub.Controller;


import MeetingBookClub.Model.Meeting;
import MeetingBookClub.Model.MeetingInterface;
import MeetingBookClub.Model.MeetingsList;
import MeetingBookClub.View.MeetingListView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class  MeetingListViewController implements ActionListener {


    /**
     * Meeting variables to control
     */
    // Manali model and view
    private final MeetingsList model;
    private final MeetingListView view;

   // constructor
    public MeetingListViewController(MeetingsList model, MeetingListView view) {
       this.model=model;
       this.view=view;
      // making things clickable hehe
      addActionListeners();
      //updating how the list looks
      updateListVisual();
      // selects each element of list to display more information
        // listen selection listener instead of action listener  for delay for pp up
        view.getListofMeetings().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                //getting vlaue of meeting
                Meeting selected = (Meeting) view.getListofMeetings().getSelectedValue();
                //checking to see if f=value is there or not

                if (selected != null) {
                    // formatters for date and time so they look pretty pretty
                    SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yyyy");
                    SimpleDateFormat timeParser = new SimpleDateFormat("hh:mm a");
                   // transformign the user input using format
                    String formDate = dateParser.format(selected.getMeetingDate());
                    String formTime = timeParser.format(selected.getMeetingTime());
                     // YAYYAYAY information message
                    JOptionPane.showMessageDialog(view.getJPanell(),
                            "Meeting Name: " + selected.getMeetingName() + "\n"+
                                    "Time: " + formTime + "\n"+
                                    "Date: " + formDate+ "\n"+
                                    "Link: " + selected.getMeetingLink(),
                            "Meeting Info",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }



    //connecting buttons so they work

    private void addActionListeners(){
        view.getAddToList().addActionListener(this);
        view.getDelete_meeting_button().addActionListener(this);

    }

    // making the buttons do what they're supposed to lol
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == view.getAddToList()){
            addNewMeeting();
        }
        if (source == view.getDelete_meeting_button()){
            deleteMeeting();
        }
        //visual upateeee
        updateListVisual();
    }

    // adding meeting
    private void addNewMeeting() {
        //Date today = new Date(); for dummy data
        String name = JOptionPane.showInputDialog(view.getJPanell(), "Enter Meeting Name:");
        if (name == null || name.isEmpty()) { // check for null!!
            return;
        }
        // link input
        String link = JOptionPane.showInputDialog(view.getJPanell(), "Enter Meeting Link:");
        if (link == null || link.isEmpty()) {
            return;
        }

        // getting date
        Date meetingDate = null; // putting date into scop for later?
       String dateStringInput = JOptionPane.showInputDialog(view.getJPanell(), "Enter Meeting Date (MM/DD/YYYY:");
        try { //ughhhhh attempting with exceptions for formatting
            SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
            meetingDate = parser.parse(dateStringInput);
        } catch (ParseException e) { //catch
            JOptionPane.showMessageDialog(view.getJPanell(), "Invalid date format. Please try again");
            return;
        }
        // time try catch
        Date datetime = null; //scope
      String timeInput = JOptionPane.showInputDialog(view.getJPanell(), "Enter Meeting Time (00:00 PM)");
        try {
            SimpleDateFormat timeParser = new SimpleDateFormat("hh:mm a");
             datetime = timeParser.parse(timeInput);

        }
        catch (ParseException e){
            JOptionPane.showMessageDialog(view.getJPanell(),"Try again");
        }
        // actual time not right now
        Time time1 = new Time(datetime.getTime());

        Meeting newMeeting = new Meeting(meetingDate, time1, name, link);
        model.addMeetingtoList(newMeeting);
        DefaultListModel<Meeting> listModel = (DefaultListModel<Meeting>) view.getListofMeetings().getModel();
        listModel.addElement(newMeeting);// new meeting to list


    }




    private void deleteMeeting(){
        //get click val
        Meeting meetingtoDelete = (Meeting) view.getListofMeetings().getSelectedValue();

        if (meetingtoDelete != null){
            int t = JOptionPane.showConfirmDialog(view.getJPanell(),"Delete ?");
            if(t == JOptionPane.YES_OPTION){ // of yes delete
                model.deleteMeetingFromList(meetingtoDelete);
                updateListVisual();
                JOptionPane.showMessageDialog(view.getJPanell(),"Deleted");
            }

        }
    }

    // making the list stay up to date in view vie
    private void updateListVisual(){
        DefaultListModel<Meeting> listModel = new DefaultListModel<>();
        for (MeetingInterface m : model.getMeetingList()) {
            listModel.addElement((Meeting) m);
        }
        view.getListofMeetings().setModel(listModel);
    }






}
