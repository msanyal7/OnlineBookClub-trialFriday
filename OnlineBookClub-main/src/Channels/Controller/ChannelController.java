package Channels.Controller;
import Channels.Model.Channel;
import Channels.Model.Comment;
import Channels.View.ChannelView;
import UserAuthentication.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChannelController implements ActionListener {

        /**
         * Discussion variables to control
         */
        public Channel channel;
        public Comment comment;
        private User user;

        /**
         * Constructor
         * @param channel
         */

        private ChannelView channelView;
        public ChannelController(Channel channel, User user) {
            this.channel = channel;
            this.user = user;
            this.channelView = new ChannelView(channel, user.getUsername());
            channelView.setContentPane(channelView.getPanel());
            channelView.createComponents();
            channelView.getSendButton().addActionListener(this);
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
