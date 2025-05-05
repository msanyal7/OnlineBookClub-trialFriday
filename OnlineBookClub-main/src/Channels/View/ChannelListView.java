package Channels.View;

import UserAuthentication.Model.User;
import Channels.Model.Channel;
import UserAuthentication.Model.UserAuthentication;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChannelListView extends JPanel {
    private JPanel pnlRoot;

    public JPanel getPanel() {
        return this;
    }
//    public void updatePanel(JPanel panel){
//        this.getPanel() = panel;
//    }

    private User user;
    private JList<Channel> channelList;
    private DefaultListModel<Channel> listModel;
    private JPopupMenu channelMenu;
    private Channel selectedChannel;
    private JButton showAllChannels;

    public JButton getShowAllChannels() {
        return showAllChannels;
    }

    public ChannelListView(User user) {
        this.user = user;
        initializeUI();
        //createComponents();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create top panel with the "Show All Channels" button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        showAllChannels = new JButton("Show All Channels");
        topPanel.add(showAllChannels);
        add(topPanel, BorderLayout.SOUTH);

        // Create the list model and populate with user's channels
        listModel = new DefaultListModel<>();
        for (Channel channel : user.getSubscribedChannels()) {
            listModel.addElement(channel);
        }

        channelList = new JList<>(listModel);
        channelList.setCellRenderer(new ChannelListRenderer());
        channelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        channelList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index = channelList.locationToIndex(evt.getPoint());
                if (index >= 0) {
                    selectedChannel = listModel.getElementAt(index);
                    if (SwingUtilities.isRightMouseButton(evt) ||
                            isHamburgerClick(evt.getPoint(), index)) {
                        showChannelMenu(evt.getX(), evt.getY());
                    }
                }
            }
        });

        // Create scroll pane
        JScrollPane scrollPane = new JScrollPane(channelList);
        scrollPane.setPreferredSize(new Dimension(300, 400));
        add(scrollPane, BorderLayout.CENTER);

        // Create the context menu
        createChannelMenu();
    }
    private void createComponents(){
//        this.setTitle("Channel List");
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setContentPane(new ChannelListView(user));
//        this.pack();
//        this.setVisible(true);
    }
    private boolean isHamburgerClick(Point clickPoint, int index) {
        Rectangle cellBounds = channelList.getCellBounds(index, index);
        if (cellBounds != null) {
            int hamburgerX = cellBounds.x + cellBounds.width - 30;
            return clickPoint.x >= hamburgerX && clickPoint.x <= cellBounds.x + cellBounds.width;
        }
        return false;
    }

    private void createChannelMenu() {
        channelMenu = new JPopupMenu();

        JMenuItem favoriteItem = new JMenuItem("Add to Favorites");
        favoriteItem.addActionListener(e -> {
            if (selectedChannel != null) {
                selectedChannel.setChannelName(selectedChannel.getChannelName() + "⭐");
                selectedChannel.setChannelName(selectedChannel.getChannelName() + "⭐");
                JOptionPane.showMessageDialog(this,
                        "Added " + selectedChannel.getChannelName() + " to favorites");
            }
        });

        JMenuItem inviteItem = new JMenuItem("Invite User");
        inviteItem.addActionListener(e -> {
            if (selectedChannel != null) {
                // Implement invite logic here
                String userToInvite = JOptionPane.showInputDialog(this,
                        "Enter username to invite to " + selectedChannel.getChannelName());
                if (userToInvite != null && !userToInvite.isEmpty()) {
                    User invitee = findUser(userToInvite);
                    if (invitee != null){ invitee.subscribeToChannel(selectedChannel);}
                    JOptionPane.showMessageDialog(this,
                            "Invited " + userToInvite + " to " + selectedChannel.getChannelName());
                }
            }
        });

        JMenuItem removeItem = new JMenuItem("Remove Channel");
        removeItem.addActionListener(e -> {
            if (selectedChannel != null) {
                int confirm = JOptionPane.showConfirmDialog(this,
                        "Unsubscribe from " + selectedChannel.getChannelName() + "?",
                        "Confirm Unsubscribe", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    user.unsubscribeFromChannel(selectedChannel);
                    listModel.removeElement(selectedChannel);
                }
            }
        });

        channelMenu.add(favoriteItem);
        channelMenu.add(inviteItem);
        channelMenu.add(removeItem);
    }

    private User findUser(String username){
        UserAuthentication authenticationClass = new UserAuthentication();
        ArrayList<User> usersList = (ArrayList<User>) authenticationClass.getUsers();
        for (User user : usersList) {
            if (user.getUsername().toLowerCase().equals(username.toLowerCase())) {
                System.out.println("Successfully found user");
                return user;
            }
        }
        return null;

    }
    private void showChannelMenu(int x, int y) {
        if (selectedChannel != null) {
            channelMenu.show(channelList, x, y);
        }
    }

    private class ChannelListRenderer extends DefaultListCellRenderer {
        private JPanel panel;
        private JLabel nameLabel;
        private JLabel menuIcon;

        public ChannelListRenderer() {
            panel = new JPanel(new BorderLayout());
            nameLabel = new JLabel();
            menuIcon = new JLabel("☰");
            menuIcon.setForeground(Color.GRAY);

            JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            rightPanel.add(menuIcon);

            panel.add(nameLabel, BorderLayout.WEST);
            panel.add(rightPanel, BorderLayout.EAST);
            panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Channel) {
                Channel channel = (Channel) value;
                nameLabel.setText(channel.getChannelName());

                if (channel.getBook() != null) {
                    nameLabel.setToolTipText("Reading: " + channel.getBook().getTitle());
                }
            }

            if (isSelected) {
                panel.setBackground(list.getSelectionBackground());
                panel.setForeground(list.getSelectionForeground());
            } else {
                panel.setBackground(list.getBackground());
                panel.setForeground(list.getForeground());
            }

            return panel;
        }
    }
    public void addChannelOpenListener(ActionListener listener) {
        channelList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int index = channelList.locationToIndex(evt.getPoint());
                if (index >= 0 && evt.getClickCount() == 2) { // double-click to open
                    selectedChannel = listModel.getElementAt(index);
                    ActionEvent event = new ActionEvent(selectedChannel, ActionEvent.ACTION_PERFORMED, "channelOpen");
                    listener.actionPerformed(event);
                }
            }
        });
    }

    public void addShowAllChannelsListener(ActionListener listener) {
        showAllChannels.addActionListener(listener);
    }

    public Channel getSelectedChannel() {
        return selectedChannel;
    }

    public void addChannelSelectionListener(ListSelectionListener listener) {
        channelList.addListSelectionListener(listener);
    }
}