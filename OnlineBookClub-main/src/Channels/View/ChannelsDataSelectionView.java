package Channels.View;

import Channels.Controller.ChannelTableController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChannelsDataSelectionView extends JPanel{
    private JPanel pnlRoot;

    public JPanel getPnlRoot() {
        return pnlRoot;
    }

    private JPanel pnlTable;
    private JScrollPane scrollPane;
    private JTable channelsTable;
    private JPanel pnlButton;
    private JButton subscribeChannel;
    private JPanel topPanel;
    private JButton backButton;
    public JButton getBackButton(){
        return backButton;
    }
    private ChannelTableController controller;
    private JLabel backIcon;
    private int FRAME_WIDTH = 500;
    private int FRAME_HEIGHT = 500;

    public ChannelsDataSelectionView(ChannelTableController controller){
        this.controller = controller;
    }

    public JButton getSubscribeChannel(){
        return subscribeChannel;}
    public JTable getChannelsTable() {
        return channelsTable;
    }

    public void addSubscribeActionListener(ActionListener listener){
        subscribeChannel.addActionListener(listener);
    }
    public void addBackButtonListener(ActionListener listener){
        backButton.addActionListener(listener);
    }
    public void createComponents(){

        channelsTable = new JTable(controller.getChannelTableModel());
        scrollPane.setViewportView(channelsTable);
        channelsTable.setFillsViewportHeight(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(350,300));
        this.add(pnlRoot);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);

//        this.setTitle("Channels Table");
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosed(WindowEvent e) {
//                new ChannelListController(controller.user, pnlRoot);
//            }
//        });

        this.setVisible(true);

    }



}
