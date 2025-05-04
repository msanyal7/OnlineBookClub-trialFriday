package Channels.Controller;

import Channels.Model.Channel;
import Channels.View.ChannelListView;
import Channels.View.ChannelView;
import UserAuthentication.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChannelListController implements ActionListener {
    private User user;
    private ChannelListView channelListView;

    public ChannelListController(User user) {
        this.user = user;
        this.channelListView = new ChannelListView(user);

        // 🎯 Add listener for opening channels
        channelListView.addChannelOpenListener(this);

        // Display the channel list UI
        JFrame frame = new JFrame("Channel List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(channelListView);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("channelOpen".equals(e.getActionCommand())) {
            Channel selectedChannel = (Channel) e.getSource();
            openChannel(selectedChannel);
        }
    }

    private void openChannel(Channel channel) {
        System.out.println("Opening channel: " + channel.getChannelName());
        // Create the ChannelView and open it
        ChannelController view = new ChannelController(channel, user);
        //view. createComponents();
    }
}
