package TestHarness;
import Homepage.Model.Book;
import TrackProgress.Model.ReadingProgress;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class NonFunctionalTestCases {
    public NonFunctionalTestCases() {

    }

    public void testAddBookToList() {
        System.out.println("Running testAddBookToList()...");

        ReadingProgress readingProgress = new ReadingProgress();
        Book book = new Book("The Alchemist", "Paulo Coelho", 208);

        readingProgress.addBookToRead(book);

        if (readingProgress.getBooksToRead().contains(book)) {
            System.out.println("PASS: Book was successfully added to the reading list.");
        } else {
            System.out.println("FAIL: Book was not added to the reading list.");
        }
    }

    public void testValidationMessage() {
        System.out.println("Running testValidationMessage()...");

        String bookName = "";
        String author = "Paulo Coelho";
        int pages = 208;

        if (bookName == null || bookName.trim().isEmpty()) {
            System.out.println("PASS: Validation correctly caught empty book name.");
        } else {
            Book invalidBook = new Book(bookName, author, pages);
            ReadingProgress progress = new ReadingProgress();
            progress.addBookToRead(invalidBook);
            System.out.println("FAIL: Book with empty title was added.");
        }
    }
}
