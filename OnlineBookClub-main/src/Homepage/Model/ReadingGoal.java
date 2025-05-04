package Homepage.Model;

public class ReadingGoal {
    //Attributes
    private int targetBooks;
    private String timeframe;
    private int booksRead;

    //CONSTRUCTOR
    public ReadingGoal(int targetBooks, String timeframe, int booksRead) {
        this.targetBooks = targetBooks;
        this.timeframe = timeframe;
        this.booksRead = booksRead;
    }

    //METHODS
    public int getTargetBooks() {
        return targetBooks;
    }
    public String getTimeframe() {
        return timeframe;
    }
    public int getBooksRead() {
        return booksRead;
    }

    public void setTargetBooks(int targetBooks) {
        this.targetBooks = targetBooks;
    }
    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }
    public void setBooksRead(int booksRead) {
        this.booksRead = booksRead;
    }

    /**
     * Increments the number of books read.
     */
    public void incrementBooksRead() {
        this.booksRead++;
    }

    /**
     * Checks if the reading goal is met.
     * @return true if booksRead >= targetBooks, false otherwise
     */
    public boolean isGoalMet() {
        return booksRead >= targetBooks;
    }
}
