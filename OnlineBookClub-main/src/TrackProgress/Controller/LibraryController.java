package TrackProgress.Controller;

import Homepage.Model.Book;
import TrackProgress.Model.ReadingProgress;
import TrackProgress.View.AddBookForm;
import TrackProgress.View.BookProgressForm;
import TrackProgress.View.LibraryView;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;

public class LibraryController {
    private ReadingProgress readingProgress;
    private LibraryView libraryView;
    private AddBookForm addBookForm;
    private JFrame addFrame;

    public LibraryController(ReadingProgress readingProgress, LibraryView libraryView, AddBookForm addBookForm) {
        this.readingProgress = readingProgress;
        this.libraryView = libraryView;
        this.addBookForm = addBookForm;

        // Button listeners
        libraryView.getAddABookButton().addActionListener(e -> openAddBookForm());
        libraryView.getUpdateBookButton().addActionListener(e -> updateBook());
        libraryView.getDeleteBookButton().addActionListener(e -> deleteBook());

        // List selection listener
        libraryView.getReadingList().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedValue = libraryView.getReadingList().getSelectedValue();
                if (selectedValue != null) {
                    openBookProgressForm(extractBookTitle(selectedValue));
                }
            }
        });

        updateWantToReadDisplay();
        updateBookCount();
        updateBooksReadDisplay();
    }

    private void openAddBookForm() {
        if (addFrame == null) {
            addFrame = new JFrame("Add a Book");
            addFrame.setContentPane(addBookForm.getPanel());
            addFrame.pack();
        }

        addFrame.setVisible(true);

        for (ActionListener al : addBookForm.getAddButton().getActionListeners()) {
            addBookForm.getAddButton().removeActionListener(al);
        }

        addBookForm.getAddButton().addActionListener(e -> {
            try {
                String name = addBookForm.getNameTextField().getText();
                String author = addBookForm.getAuthorTextField().getText();
                int pages = Integer.parseInt(addBookForm.getNumPagesTextField().getText());

                Book newBook = new Book(name, author, pages);
                readingProgress.addBookToRead(newBook);

                updateWantToReadDisplay();
                updateBookCount();

                addBookForm.getNameTextField().setText("");
                addBookForm.getAuthorTextField().setText("");
                addBookForm.getNumPagesTextField().setText("");

                addFrame.setVisible(false);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for pages.");
            }
        });

        addBookForm.getBackButton().addActionListener(e -> addFrame.setVisible(false));
    }

    private void updateBookCount() {
        int count = readingProgress.getBooksToRead().size();
        libraryView.setNumOfBooks(count);
    }

    private void updateWantToReadDisplay() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Book book : readingProgress.getBooksToRead()) {
            model.addElement(book.getTitle() + " by " + book.getAuthor()); // Show title + author
        }
        libraryView.getReadingList().setModel(model);
    }

    private void updateBooksReadDisplay() {
        StringBuilder sb = new StringBuilder();
        for (Book book : readingProgress.getBooksRead()) {
            sb.append("Title: ").append(book.getTitle())
                    .append(", Author: ").append(book.getAuthor())
                    .append(", Pages: ").append(book.getNumPages()).append("\n");
        }
        libraryView.setBookInfoList(sb.toString());
    }

    private void openBookProgressForm(String bookTitle) {
        for (Book book : readingProgress.getBooksToRead()) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                new BookProgressForm(book, readingProgress, this); // Pass the controller
                return;
            }
        }
    }

    public void refreshBookProgressLabel(Book book) {
        double progress = book.getBookProgress();
        libraryView.getBookProgressLabel().setText("Progress: " + String.format("%.2f", progress) + "%");
    }

    private void updateBook() {
        String bookTitleInput = JOptionPane.showInputDialog("Enter the title of the book you want to update:");

        for (Book book : readingProgress.getBooksToRead()) {
            if (book.getTitle().equalsIgnoreCase(bookTitleInput)) {
                String newTitle = JOptionPane.showInputDialog("Enter new title:");
                String newAuthor = JOptionPane.showInputDialog("Enter new author:");
                String newPagesStr = JOptionPane.showInputDialog("Enter new number of pages:");
                try {
                    int newPages = Integer.parseInt(newPagesStr);

                    book.setTitle(newTitle);
                    book.setAuthor(newAuthor);
                    book.setNumPages(newPages);

                    updateWantToReadDisplay();
                    JOptionPane.showMessageDialog(null, "Book updated successfully!");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid number of pages.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found!");
    }

    private void deleteBook() {
        String bookTitleInput = JOptionPane.showInputDialog("Enter the title of the book you want to delete:");

        Book bookToRemove = null;
        for (Book book : readingProgress.getBooksToRead()) {
            if (book.getTitle().equalsIgnoreCase(bookTitleInput)) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            readingProgress.getBooksToRead().remove(bookToRemove);
            updateWantToReadDisplay();
            updateBookCount();
            JOptionPane.showMessageDialog(null, "Book deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Book not found!");
        }
    }

    public void refreshLibraryView() {
        updateBookCount();
        updateWantToReadDisplay();
        updateBooksReadDisplay();
    }

    private String extractBookTitle(String listItemText) {
        // "Book Name by Author Name" --> Use on the "Book Name"
        if (listItemText.contains(" by ")) {
            return listItemText.substring(0, listItemText.indexOf(" by ")).trim();
        }
        return listItemText.trim();
    }
}
