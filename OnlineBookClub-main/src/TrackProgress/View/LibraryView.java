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
    private JLabel progressLabel;
    private JLabel bookProgressLabel;
    private DefaultListModel<String> readingListModel;


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
        addABookButton = new JButton("Add a Book?");
        updateBookButton = new JButton("Update Book");
        deleteBookButton = new JButton("Delete Book");

        numofBookTextField = new JTextField(5);
        bookInfoListTextArea = new JTextArea(10, 25);
        wantToReadTextArea = new JTextArea(10, 25);

        readingListModel = new DefaultListModel<>();
        readingList = new JList<>(readingListModel);

        bookProgressLabel = new JLabel("Progress: ");
    }
}