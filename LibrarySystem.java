import java.io.*;
import java.util.*;

public class LibrarySystem {
    private static List<User> users = new ArrayList<>();
    private static List<Book> books = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static User loggedInUser;

    public static void main(String[] args) {
        loadUsers();
        loadBooks();
        login();
    }

    private static void loadUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                users.add(new User(data[0], data[1], data[2], data[3]));
            }
        } catch (IOException e) {
            System.out.println("Error loading users.txt");
        }
    }

    private static void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                books.add(new Book(data[0], data[1], data[2], Boolean.parseBoolean(data[3])));
            }
        } catch (IOException e) {
            System.out.println("Error loading books.txt");
        }
    }

    private static void login() {
        System.out.println("Welcome to the Library Management System!");
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();

            for (User u : users) {
                if (u.name.equals(username) && u.getPassword().equals(password)) {
                    loggedInUser = u;
                    System.out.println("Login successful! Welcome, " + u.name);
                    menu();
                    return;
                }
            }
            System.out.println("Invalid credentials. Attempts left: " + (3 - attempt));
        }
        System.out.println("Too many failed attempts. Exiting...");
    }

    private static void menu() {
        while (true) {
            System.out.println("\n1. View All Books\n2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                for (Book b : books) b.displayBookDetails();
            } else if (choice == 2) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
