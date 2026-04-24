import java.time.LocalDate;

public class Transaction {
    int bookId;
    int userId;
    LocalDate issueDate;
    LocalDate dueDate;
    LocalDate returnDate;

    public Transaction(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = LocalDate.now();
        this.dueDate = issueDate.plusDays(7);
    }

    public void returnBook() {
        returnDate = LocalDate.now();
    }

    public int calculateFine() {
        if (returnDate != null && returnDate.isAfter(dueDate)) {
            return returnDate.getDayOfYear() - dueDate.getDayOfYear();
        }
        return 0;
    }
}