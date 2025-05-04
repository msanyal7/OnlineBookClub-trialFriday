package Channels.View;

import Channels.Model.Channel;
import Channels.Model.ChannelObserver;
import Channels.Model.Comment;
import Homepage.Model.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChannelView extends JFrame implements ChannelObserver {
    private JPanel pnlRoot;
    private JPanel commentPnl;
    private JScrollPane scrollPane;
    private JTextArea inputArea;
    public JTextArea getInputArea(){
        return this.inputArea;
    }
    private JButton sendButton;
    public JButton getSendButton(){
        return this.sendButton;
    }
    private JPanel inputPanel;
    private String currentUser;
    private Channel channel;
    private JLabel channelNameLabel;
    private JLabel bookImageLabel;
    private JButton channelDetailsButton;
    private JList<String> membersList;
    public ChannelView(Channel channel, String currentUser) {
        this.channel = channel;
        this.currentUser = currentUser;

        pnlRoot.setLayout(new BorderLayout());

        // Create header panel with channel info
        JPanel headerPanel = createHeaderPanel();
        pnlRoot.add(headerPanel, BorderLayout.NORTH);

        // Comment panel in scroll
        commentPnl.setLayout(new BoxLayout(commentPnl, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(commentPnl);
        pnlRoot.add(scrollPane, BorderLayout.CENTER);

        // Input area
        inputArea = new JTextArea(3, 30);
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        sendButton = new JButton("Send");

        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        pnlRoot.add(inputPanel, BorderLayout.SOUTH);

        channel.addObserver(this);

        // Load existing comments
        for (Comment c : channel.getChannelComments()) {
            addCommentToView(c);
        }
    }
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        headerPanel.setBackground(new Color(240, 240, 240));

        // Channel name label
        channelNameLabel = new JLabel(channel.getChannelName());
        channelNameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        headerPanel.add(channelNameLabel, BorderLayout.WEST);

        // Channel details button
        channelDetailsButton = new JButton("Channel Details");
        channelDetailsButton.addActionListener(e -> showChannelDetails());
        headerPanel.add(channelDetailsButton, BorderLayout.EAST);

        // Book image (if available)
        if (channel.getBook() != null && channel.getBookImage() != null) {
            JPanel bookPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            bookImageLabel = new JLabel(new ImageIcon(channel.getBookImage().getScaledInstance(50, 70, Image.SCALE_SMOOTH)));

            // Add tooltip with book info
            Book book = channel.getBook();
            bookImageLabel.setToolTipText("<html><b>" + book.getTitle() + "</b><br>by " + book.getAuthor() + "</html>");

            // Add click listener for more info
            bookImageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showBookInfoPopup();
                }
            });

            bookPanel.add(bookImageLabel);
            headerPanel.add(bookPanel, BorderLayout.CENTER);
        }

        return headerPanel;
    }

    private void showChannelDetails() {
        JDialog detailsDialog = new JDialog(this, "Channel Details", true);
        detailsDialog.setLayout(new BorderLayout());
        detailsDialog.setSize(300, 400);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Channel name
        JLabel nameLabel = new JLabel("Channel: " + channel.getChannelName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        contentPanel.add(nameLabel);
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Book info
        if (channel.getBook() != null) {
            JLabel bookTitleLabel = new JLabel("Book: " + channel.getBook().getTitle());
            JLabel authorLabel = new JLabel("Author: " + channel.getBook().getAuthor());
            contentPanel.add(bookTitleLabel);
            contentPanel.add(authorLabel);
            contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Members section (placeholder - you would need actual member data)
        JLabel membersLabel = new JLabel("Members:");
        membersLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        contentPanel.add(membersLabel);

        // Example members list
        DefaultListModel<String> membersListModel = new DefaultListModel<>();
        membersListModel.addElement("User1");
        membersListModel.addElement("User2");
        membersListModel.addElement(currentUser);

        JList<String> membersList = new JList<>(membersListModel);
        JScrollPane membersScrollPane = new JScrollPane(membersList);
        contentPanel.add(membersScrollPane);

        detailsDialog.add(contentPanel, BorderLayout.CENTER);

        // Close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> detailsDialog.dispose());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(closeButton);
        detailsDialog.add(buttonPanel, BorderLayout.SOUTH);

        detailsDialog.setLocationRelativeTo(this);
        detailsDialog.setVisible(true);
    }

    private void showBookInfoPopup() {
        if (channel.getBook() == null) return;

        Book book = channel.getBook();
        JOptionPane.showMessageDialog(this,
                "<html><b>Title:</b> " + book.getTitle() + "<br>" +
                        "<b>Author:</b> " + book.getAuthor() + "<br>",
                "Book Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void onCommentAdded(Comment comment) {
        addCommentToView(comment);
    }

    public void addCommentToView(Comment comment) {
        String formattedComment = "<html><b>" + comment.getUserName() + ":</b><br>&nbsp;&nbsp;" + comment.getUserComment() + "</html>";
        JLabel label = new JLabel(formattedComment);
        label.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        commentPnl.add(label);
        commentPnl.revalidate();
        commentPnl.repaint();

        JScrollBar vertical = scrollPane.getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }

    public void addSendButtonListener(ActionListener listener) {
        sendButton.addActionListener(listener);
    }

    public JPanel getPanel() {
        return pnlRoot;
    }
    public void createComponents(){
        this.setTitle("Book Club Channel");
        this.setSize(500, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    // For testing standalone
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Book Club Channel");
            Channel channel = new Channel("Fantasy Fans");

            frame.setContentPane(new ChannelView(channel, "Aria").getPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setVisible(true);
        });
    }
}
