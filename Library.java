import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }

    public void registerUser(User user) { users.add(user); }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }

    public User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    public boolean issueBook(String isbn, int userId) {
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);
        if (book != null && user != null && !book.isIssued()) {
            user.borrowBook(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn, int userId) {
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);
        if (book != null && user != null && book.isIssued()) {
            user.returnBook(book);
            return true;
        }
        return false;
    }

    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
