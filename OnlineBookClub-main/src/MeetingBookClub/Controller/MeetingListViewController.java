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

    private final MeetingsList model;
    private final MeetingListView view;


    public MeetingListViewController(MeetingsList model, MeetingListView view) {
       this.model=model;
       this.view=view;

      addActionListeners();
      updateListVisual();
      // selects each element of list to display more information
        // listen selection listener instead of action listener  for delay for pp up
        view.getListofMeetings().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                //getting vlaue of meeting
                Meeting selected = (Meeting) view.getListofMeetings().getSelectedValue();
                //checking to see if f=value is there or not
                if (selected != null) {
                    JOptionPane.showMessageDialog(view.getJPanell(),
                            "Meeting Name: " + selected.getMeetingName() +
                                    "\nTime: " + selected.getMeetingTime() +
                                    "\nDate: " + selected.getMeetingDate()+
                                    "\nLink: " + selected.getMeetingLink(),
                            "Meeting Info",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }



    //connecting add button to meeting

    private void addActionListeners(){
        view.getAddToList().addActionListener(this);
        view.getDelete_meeting_button().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == view.getAddToList()){
            addNewMeeting();
        }
        if (source == view.getDelete_meeting_button()){
            deleteMeeting();
        }
        updateListVisual();
    }

    private void addNewMeeting() {
        Date today = new Date();
        String name = JOptionPane.showInputDialog(view.getJPanell(), "Enter Meeting Name:");
        if (name == null || name.isEmpty()) {
            return;
        }

        String link = JOptionPane.showInputDialog(view.getJPanell(), "Enter Meeting Link:");
        if (link == null || link.isEmpty()) {
            return;
        }

        // getting date
       String dateStringInput = JOptionPane.showInputDialog(view.getJPanell(), "Enter Meeting Date:");
        // date try catchh
        try {
            SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
            String meetingDate = String.valueOf(parser.parse(dateStringInput));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(view.getJPanell(), "Invalid date format. Please enter date again");
        }
        // time try catch
        Date datetime = null;
      String timeInput = JOptionPane.showInputDialog(view.getJPanell(), "Enter Meeting Time:");
        try {
            SimpleDateFormat timeParser = new SimpleDateFormat("hh:mm a");
             datetime = timeParser.parse(timeInput);

        }
        catch (ParseException e){
            JOptionPane.showMessageDialog(view.getJPanell(),"Try again");
        }

        Time time = new Time(datetime.getTime());

        Meeting newMeeting = new Meeting(today, time, name, link);
        model.addMeetingtoList(newMeeting);
        DefaultListModel<Meeting> listModel = (DefaultListModel<Meeting>) view.getListofMeetings().getModel();
        listModel.addElement(newMeeting);


    }

    private void findMeeting(){
        String meetingFind = JOptionPane.showInputDialog(view.getJPanell(), "Enter the meeting name to search:");
        for (int i=0; i < model.getMeetingList().size();i++){
            if (model.getMeetingList().get(i).getMeetingName() == meetingFind ){
                JOptionPane.showMessageDialog(view.getJPanell(), "This is your meeting: " + meetingFind);
            }
            else {
                JOptionPane.showMessageDialog(view.getJPanell(),"No Meeting found");
            }
        }

    }


    private void deleteMeeting(){
        //get click val
        Meeting meetingtoDelete = (Meeting) view.getListofMeetings().getSelectedValue();

        if (meetingtoDelete != null){
            int t = JOptionPane.showConfirmDialog(view.getJPanell(),"Delete?"+ JOptionPane.YES_NO_OPTION);
            if(t == JOptionPane.YES_OPTION){
                model.deleteMeetingFromList(meetingtoDelete);
                updateListVisual();
                JOptionPane.showMessageDialog(view.getJPanell(),"Deleted");
            }

        }
    }

    private void updateListVisual(){
        DefaultListModel<Meeting> listModel = new DefaultListModel<>();
        for (MeetingInterface m : model.getMeetingList()) {
            listModel.addElement((Meeting) m);
        }
        view.getListofMeetings().setModel(listModel);
    }






}
