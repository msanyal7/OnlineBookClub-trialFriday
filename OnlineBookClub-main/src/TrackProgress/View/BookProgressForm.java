package TrackProgress.View;

import Homepage.Model.Book;
import TrackProgress.Controller.LibraryController;
import TrackProgress.Model.ReadingProgress;

import javax.swing.*;
import java.awt.*;

public class BookProgressForm extends JPanel{
    private JPanel bookProgressPanel;
    private JLabel bookTitleLabel;
    private JLabel pagesProgressLabel;
    private JTextField updatePagesTextField;
    private JButton backButton;
    private JButton submitButton;
    private Book currentBook;
    private JFrame frame;
    private LibraryController libraryController;
    private ReadingProgress readingProgress;  // NEW: need access to ReadingProgress model

    // Constructor
    public BookProgressForm(Book book, ReadingProgress readingProgress, LibraryController libraryController) {
        this.currentBook = book;
        this.readingProgress = readingProgress; // NEW: pass model
        this.libraryController = this.libraryController;
        createUIComponents(); // Initialize all UI components
        setupFrame(); // Setup and display the frame
        setupListeners(); // Setup button actions
    }

    // Create and organize all the UI components
    private void createUIComponents() {
        // Initialize components
        bookProgressPanel = new JPanel();
        bookProgressPanel.setLayout(new GridLayout(6, 1, 10, 10));

        bookTitleLabel = new JLabel("Title: " + currentBook.getTitle());
        pagesProgressLabel = new JLabel("Total Pages: " + currentBook.getNumPages());

        updatePagesTextField = new JTextField(10);
        submitButton = new JButton("Update Pages Read");
        backButton = new JButton("Back");

        // Add components to the panel
        bookProgressPanel.add(bookTitleLabel);
        bookProgressPanel.add(pagesProgressLabel);
        bookProgressPanel.add(new JLabel("Enter pages you've read:"));
        bookProgressPanel.add(updatePagesTextField);
        bookProgressPanel.add(submitButton);
        bookProgressPanel.add(backButton);
    }

    // Setup the JFrame properties
    private void setupFrame() {
        frame = new JFrame("Update Progress - " + currentBook.getTitle());
        frame.setContentPane(bookProgressPanel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // Define actions for buttons
    private void setupListeners() {
        submitButton.addActionListener(e -> updatePages());
        backButton.addActionListener(e -> frame.dispose());
    }

    // Handle the page update logic
    private void updatePages() {
        try {
            int pagesRead = Integer.parseInt(updatePagesTextField.getText());
            if (pagesRead <= currentBook.getNumPages()) {
                // Actually update readingProgress
                readingProgress.updateProgress(pagesRead);

                //Update book progress field if you want finer tracking
                double progressPercentage = (double) pagesRead / currentBook.getNumPages() * 100;
                currentBook.setBookProgress(progressPercentage);

                JOptionPane.showMessageDialog(frame, "Progress Updated Successfully!\nYou are " + String.format("%.2f", progressPercentage) + "% through this book.");
                libraryController.refreshLibraryView();
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Pages read cannot be more than total pages!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
        }
    }
}


