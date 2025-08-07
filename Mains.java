import java.util.Scanner;

public class Mains {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell", "ISBN001"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "ISBN002"));
        library.registerUser(new User("Alice", 1));
        library.registerUser(new User("Bob", 2));

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Library Menu:");
            System.out.println("1. List all books");
            System.out.println("2. List all users");
            System.out.println("3. Issue a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.listBooks();
                    System.out.println();
                    break;
                case 2:
                    library.listUsers();
                     System.out.println();

                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to issue: ");
                    String issueIsbn = scanner.next();
                    System.out.print("Enter User ID: ");
                    int issueUserId = scanner.nextInt();
                    if (library.issueBook(issueIsbn, issueUserId)) {
                        System.out.println("Book issued successfully.");
                    } else {
                        System.out.println("Issue failed. Book may already be issued or user/book not found.");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.next();
                    System.out.print("Enter User ID: ");
                    int returnUserId = scanner.nextInt();
                    if (library.returnBook(returnIsbn, returnUserId)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Return failed. Book may not be issued or user/book not found.");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting the Library System.");
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
            }
        } while (choice != 5);

        scanner.close();
    }
}

