package Channels.Controller;
import Channels.Model.Channel;
import Channels.Model.Comment;
import Channels.View.ChannelView;
import UserAuthentication.Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChannelController implements ActionListener {

        /**
         * Discussion variables to control
         */
        public Channel channel;
        public Comment comment;
        private User user;
        public JPanel parentPanel;

        /**
         * Constructor
         * @param channel
         */

        private ChannelView channelView;
        public ChannelView getchannelView(){
            return channelView;
        }

    public ChannelController(Channel channel, User user, JPanel parentPanel) {
            this.channel = channel;
            this.user = user;
            this.parentPanel = parentPanel;
            this.channelView = new ChannelView(channel, user.getUsername());
            channelView.setContentPane(channelView.getPanel());
            //channelView.createComponents();
            showComments();
            channelView.getSendButton().addActionListener(this);
            channelView.getBackButton().addActionListener(this);
        }

        //sendButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            if(source.equals(channelView.getSendButton())) {
                String text = channelView.getInputArea().getText().trim();
                if (!text.isEmpty()) {
                    Comment comment = new Comment(user.getUsername(), text);
                    channel.addComment(comment);
                    channelView.getInputArea().setText("");
                }
            }
            if(source.equals(channelView.getBackButton())){
                goBackToListView();
            }
        }
        private void updateParentPanel(JPanel newPanel) {
            parentPanel.removeAll();
            parentPanel.setLayout(new BorderLayout());
            parentPanel.add(newPanel, BorderLayout.CENTER);
            parentPanel.revalidate();
            parentPanel.repaint();
        }
        public void goBackToListView(){
            ChannelListController channelListController = new ChannelListController(user, parentPanel);
            updateParentPanel(channelListController.getChannelListView().getPanel());
        }
        private void showComments(){
            for (Comment c : channel.getChannelComments()) {
                channelView.addCommentToView(c);
            }
        }
        /**
         * getters and setters
         * and methods for creating and deleting comments and channels
         * @return
         */

        public Channel getChannel() {
            return channel;
        }
        public void setChannel(Channel channel) {
            this.channel = channel;
        }
        public Comment getComment() {
            return comment;
        }
        public void setComment(Comment comment) {
            this.comment = comment;
        }

        /**
         * Method stubs
         * You can create and delete a channel
         * And you can create or delete a comment within each channel
         * @return
         */
        public Channel createChannel(){return channel;}
        public void deleteChannel(){}
        public Comment createComment(){return comment;}
        public void deleteComment(){}

    }
