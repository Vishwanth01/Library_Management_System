import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Transaction> transactions = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added!");
    }

    public void addUser(User u) {
        users.add(u);
        System.out.println("User registered!");
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available!");
            return;
        }

        for (Book b : books) {
            b.display();
        }
    }

    public void searchBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                b.display();
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void issueBook(int bookId, int userId) {
        for (Book b : books) {
            if (b.id == bookId && !b.issued) {
                b.issued = true;
                transactions.add(new Transaction(bookId, userId));
                System.out.println("Book issued!");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    public void returnBook(int bookId) {
        for (Transaction t : transactions) {
            if (t.bookId == bookId && t.returnDate == null) {
                t.returnBook();

                for (Book b : books) {
                    if (b.id == bookId) {
                        b.issued = false;
                    }
                }

                int fine = t.calculateFine();
                System.out.println("Returned! Fine: ₹" + fine);
                return;
            }
        }
        System.out.println("Transaction not found!");
    }
}