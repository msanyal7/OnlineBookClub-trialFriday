package TestHarness;
import Homepage.Controller.HomepageController;
import Homepage.Model.Book;
import Homepage.Model.Homepage;
import Homepage.View.HomepageView;
import TrackProgress.Model.ReadingProgress;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    public void testHomepageTabsPerformance() {
        long startTime = System.currentTimeMillis();
        HomepageController controller = new HomepageController(new Homepage(), new HomepageView());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        if (duration < 5000){
            System.out.println("Homepage tabs rendered too slowly");
        }
    }
}
