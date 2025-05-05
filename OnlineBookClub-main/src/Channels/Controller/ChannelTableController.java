package Channels.Controller;

import Channels.Model.Channel;
import Channels.Model.ChannelTableModel;
import Channels.View.ChannelsDataSelectionView;
import UserAuthentication.Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChannelTableController implements ActionListener {

    private ChannelsDataSelectionView channelsDataSelectionView;

    public ChannelsDataSelectionView getChannelsDataSelectionView() {
        return channelsDataSelectionView;
    }

    private ChannelTableModel channelTableModel;
    public User user;
    private List<Channel> channels = new ArrayList<>();
    private JPanel parentPanel;
    public ChannelTableController(User user, JPanel homepagePanel){
        this.user = user;
        this.parentPanel = homepagePanel;
        createData();
        channelsDataSelectionView = new ChannelsDataSelectionView(this);
        this.channelTableModel = new ChannelTableModel(channels);
        //channelsDataSelectionView.setContentPane(channelsDataSelectionView.);
        channelsDataSelectionView.createComponents();
        channelsDataSelectionView.addSubscribeActionListener(this);
        channelsDataSelectionView.addBackButtonListener(this);

    }
    private void addActionListeners() {
        //channelsDataSelectionView.getSubscribeChannel().addActionListener(this);
        //channelsDataSelectionView.getBtnTransaction().addActionListener(this);
    }
    private void updateParentPanel(JPanel newPanel) {
        parentPanel.removeAll();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(newPanel, BorderLayout.CENTER);
        parentPanel.revalidate();
        parentPanel.repaint();
    }
    public ChannelTableModel getChannelTableModel(){
        return this.channelTableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source.equals(channelsDataSelectionView.getSubscribeChannel())) {
            subscribeToChannel();
        }
        if (source.equals(channelsDataSelectionView.getBackButton())){
            goBackToListView();
        }
    }

    public void subscribeToChannel(){
        //instrumentListView.dispose();
        int selectedRow = channelsDataSelectionView.getChannelsTable().getSelectedRow();
        Channel subscribetoChannel = channelTableModel.getChannels().get(selectedRow);
        if(subscribetoChannel != null){
            System.out.println("Should subscribe to " + subscribetoChannel.getChannelName());
            user.subscribeToChannel(subscribetoChannel);
        }
    }

    public void goBackToListView(){
        ChannelListController channelListController = new ChannelListController(user, parentPanel);
        updateParentPanel(channelListController.getChannelListView().getPanel());
    }

    public void createData(){
        Channel channel = new Channel("For Lovers", "Channel for Fun and Romance");
        Channel channel2 = new Channel("Wimpy", "Channel for Humor in Diary Of a Wimpy Kid");
        Channel channel3 = new Channel("If You like Kdramas", "Join if you enjoy Kdramas");
        Channel channel4 = new Channel("For the Love of Gore", "Peeps that enjoy seeing gross stuff");

        channels.add(channel);
        channels.add(channel2);
        channels.add(channel3);
        channels.add(channel4);
    }
}
