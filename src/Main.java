import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Library library = new Library();
        
        // add some books
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        
        System.out.println("======================================");
        System.out.println("  WELCOME TO THE LIBRARY SYSTEM");
        System.out.println("======================================");
        
        // create user with validation
        String name = "";
        while (name.trim().isEmpty()) {
            System.out.print("Please enter your name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty. Please try again.");
            }
        }
        User user = new User(name);
        System.out.println("\nHello, " + user.getName() + "! Welcome to our library.");
        
        int choice = 0;
        do {
            displayMenu();
            choice = getUserChoice();
            
            switch (choice) {
                case 1:
                    library.viewBooks();
                    pressEnterToContinue();
                    break;
                case 2:
                    String borrowTitle = getValidString("Enter book title to borrow: ");
                    user.borrowBook(library, borrowTitle);
                    pressEnterToContinue();
                    break;
                case 3:
                    String returnTitle = getValidString("Enter book title to return: ");
                    user.returnBook(library, returnTitle);
                    pressEnterToContinue();
                    break;
                case 4:
                    System.out.println("\nThank you for using the Library Management System. Goodbye, " + user.getName() + "!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    pressEnterToContinue();
            }
        } while (choice != 4);
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n======================================");
        System.out.println("          LIBRARY MENU");
        System.out.println("======================================");
        System.out.println("1. View All Books");
        System.out.println("2. Borrow a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Exit System");
        System.out.println("======================================");
    }
    
    private static int getUserChoice() {
        int choice = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Enter your choice (1-4): ");
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    validInput = true;
                } else {
                    System.out.println("Error: Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
            } finally {
                scanner.nextLine(); // Clear the input
            }
        }
        
        return choice;
    }
    
    private static String getValidString(String prompt) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Input cannot be empty. Please try again.");
            }
        }
        return input;
    }
    
    private static void pressEnterToContinue() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
