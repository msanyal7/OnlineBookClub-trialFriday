package MeetingBookClub.Controller;


import MeetingBookClub.Model.Meeting;
import MeetingBookClub.Model.MeetingInterface;
import MeetingBookClub.Model.MeetingsList;
import MeetingBookClub.View.MeetingListView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
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
        view.getListofMeetings().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Meeting selected = (Meeting) view.getListofMeetings().getSelectedValue();
                if (selected != null) {
                    JOptionPane.showMessageDialog(view.getJPanell(),
                            "Meeting Name: " + selected.getMeetingName() +
                                    "\nTime: " + selected.getMeetingTime() +
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == view.getAddToList()){
            addNewMeeting();
        }
        updateListVisual();
    }

    private void addNewMeeting() {
        Date today = new Date();
        Time now = new Time(System.currentTimeMillis());
        String name = JOptionPane.showInputDialog(view.getJPanell(), "Enter Meeting Name:");
        if (name == null || name.isEmpty()) {
            return;
        }

        String link = JOptionPane.showInputDialog(view.getJPanell(), "Enter Meeting Link:");
        if (link == null || link.isEmpty()) {
            return;
        }


        Meeting newMeeting = new Meeting(today, now, name, link);
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

    }

    private void updateListVisual(){
        DefaultListModel<Meeting> listModel = new DefaultListModel<>();
        for (MeetingInterface m : model.getMeetingList()) {
            listModel.addElement((Meeting) m);
        }
        view.getListofMeetings().setModel(listModel);
    }






}
