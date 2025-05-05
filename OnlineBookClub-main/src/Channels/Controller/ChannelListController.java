package Channels.Controller;

import Channels.Model.Channel;
import Channels.View.ChannelListView;
import UserAuthentication.Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChannelListController implements ActionListener {
    private User user;
    private ChannelListView channelListView;
    public ChannelListView getChannelListView() {
        return channelListView;
    }

    private ChannelTableController tableController;
    public JFrame frame;
    private JPanel parentPanel;

    public ChannelListController(User user, JPanel hpPanel) {
        this.parentPanel = hpPanel;
        this.user = user;
        this.channelListView = new ChannelListView(user);
        channelListView.addShowAllChannelsListener(this);
        // 🎯 Add listener for opening channels
        channelListView.addChannelOpenListener(this);

       showInitialView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Inside actionevent block");
        if ("channelOpen".equals(e.getActionCommand())) {
            Channel selectedChannel = (Channel) e.getSource();
            openChannel(selectedChannel);
        }
        else {
            JButton source = (JButton) e.getSource();
            if (source.equals(channelListView.getShowAllChannels())) {
                System.out.println("Clicked show All Channels");
                showChannelTable();
                //frame.setVisible(false);
            }
        }
    }
    private void showInitialView() {
        updateParentPanel(channelListView.getPanel());
    }
    private void updateParentPanel(JPanel newPanel) {
        parentPanel.removeAll();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(newPanel, BorderLayout.CENTER);
        parentPanel.revalidate();
        parentPanel.repaint();
    }
    private void openChannel(Channel channel) {
        System.out.println("Opening channel: " + channel.getChannelName());
        // Create the ChannelView and open it
        ChannelController view = new ChannelController(channel, user, parentPanel);
        updateParentPanel(view.getchannelView().getPanel());
        //view. createComponents();
    }

    public void showChannelTable(){
        tableController = new ChannelTableController(user, parentPanel);
        updateParentPanel(tableController.getChannelsDataSelectionView().getPnlRoot());
        System.out.println("SHOWING CHANNEL TABLE");
    }
}
