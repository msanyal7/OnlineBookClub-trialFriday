package TrackProgress.Model;

import Homepage.Model.Book;
import java.util.List;
import java.util.ArrayList;

public class ReadingProgress {
    private int pagesRead;
    private List<Book> booksRead;
    private List<Book> booksToRead;

    // Constructor
    public ReadingProgress() {
        this.pagesRead = 0;
        this.booksRead = new ArrayList<>();
        this.booksToRead = new ArrayList<>();
    }

    // Getters and Setters
    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    public List<Book> getBooksRead() {
        return booksRead;
    }

    public void setBooksRead(List<Book> booksRead) {
        this.booksRead = booksRead;
    }

    public List<Book> getBooksToRead() {
        return booksToRead;
    }

    public void setBooksToRead(List<Book> booksToRead) {
        this.booksToRead = booksToRead;
    }

    // Methods
    public void updateProgress(int pages) {
        this.pagesRead += pages;
        System.out.println("Updated pages read: " + pagesRead);
    }

    public void addBookToRead(Book book) {
        booksToRead.add(book);
        System.out.println("Added book to reading list: " + book);
    }

}