import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== WELCOME TO LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Show Books");
            System.out.println("4. Search Book by ID");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // clear invalid input
                continue;
            }

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String t = sc.nextLine();

                    System.out.print("Author: ");
                    String a = sc.nextLine();

                    lib.addBook(new Book(id, t, a));
                    break;

                case 2:
                    System.out.print("User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    lib.addUser(new User(uid, name));
                    break;

                case 3:
                    lib.showBooks();
                    break;

                case 4:
                    System.out.print("Book ID: ");
                    int searchId = sc.nextInt();
                    lib.searchBook(searchId);
                    break;

                case 5:
                    System.out.print("Book ID: ");
                    int b = sc.nextInt();
                    System.out.print("User ID: ");
                    int u = sc.nextInt();
                    lib.issueBook(b, u);
                    break;

                case 6:
                    System.out.print("Book ID: ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                    break;

                case 7:
                    System.out.println("Bye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}