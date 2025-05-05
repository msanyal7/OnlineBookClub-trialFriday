package TrackProgress.View;

import javax.swing.*;
import java.awt.*;

public class LibraryView extends JPanel {
    private JPanel libraryPnlRoot;
    private JTextField numofBookTextField;
    private JTextArea bookInfoListTextArea;
    private JButton addABookButton;
    private JLabel numBooksLabel;
    private JLabel libraryLabel;
    private JTextArea wantToReadTextArea;
    private JLabel readingWishListLabel;
    private JLabel libraryTitleLabel;
    private JButton updateBookButton;
    private JButton deleteBookButton;

    private JList<String> readingList;
    private JLabel bookProgressLabel;
    private DefaultListModel<String> readingListModel;

    //CHANGES
    private JTabbedPane tabbedPane;

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
    //CHANGES END

    public JPanel getPanel() {
        return libraryPnlRoot;
    }

    public JButton getAddABookButton() {
        return addABookButton;
    }

    public JButton getUpdateBookButton() {
        return updateBookButton;
    }

    public JButton getDeleteBookButton() {
        return deleteBookButton;
    }

    public JTextArea getWantToReadTextArea() {
        return wantToReadTextArea;
    }

    public JTextField getNumOfBookTextField() {
        return numofBookTextField;
    }

    public JTextArea getBookInfoListTextArea() {
        return bookInfoListTextArea;
    }

    public void setNumOfBooks(int count) {
        numofBookTextField.setText(String.valueOf(count));
    }

    public void setWantToReadList(String text) {
        wantToReadTextArea.setText(text);
    }

    public void setBookInfoList(String text) {
        bookInfoListTextArea.setText(text);
    }

    public JList<String> getReadingList() {
        return readingList;
    }

    public JLabel getBookProgressLabel() {
        return bookProgressLabel;
    }

    public DefaultListModel<String> getReadingListModel() {
        return readingListModel;
    }

    private void createUIComponents() {
        libraryPnlRoot = new JPanel();
        libraryPnlRoot.setLayout(new BorderLayout());

        // Top Section
        JPanel topPanel = new JPanel(new FlowLayout());
        addABookButton = new JButton("Add a Book?");
        updateBookButton = new JButton("Update Book");
        deleteBookButton = new JButton("Delete Book");
        numofBookTextField = new JTextField(5);

        topPanel.add(addABookButton);
        topPanel.add(updateBookButton);
        topPanel.add(deleteBookButton);
        topPanel.add(new JLabel("Books to Read:"));
        topPanel.add(numofBookTextField);

        // Center Section
        readingListModel = new DefaultListModel<>();
        readingList = new JList<>(readingListModel);
        JScrollPane readingListScrollPane = new JScrollPane(readingList);

        bookInfoListTextArea = new JTextArea(10, 25);
        JScrollPane readScroll = new JScrollPane(bookInfoListTextArea);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(readingListScrollPane);
        centerPanel.add(readScroll);

        //Bottom Label
        bookProgressLabel = new JLabel("Select a book to see progress!");
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(bookProgressLabel);

        libraryPnlRoot.add(topPanel, BorderLayout.NORTH);
        libraryPnlRoot.add(centerPanel, BorderLayout.CENTER);
        libraryPnlRoot.add(bottomPanel, BorderLayout.SOUTH);
    }
}