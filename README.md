# Library Management System

A simple Java console application for managing a library's books and user interactions. This system allows users to view available books, borrow books, and return them.

## Features

- **User Authentication**: Users can enter their name to access the library system
- **Book Management**: View the collection of books in the library
- **Borrowing System**: Users can borrow available books
- **Return System**: Users can return previously borrowed books
- **Input Validation**: Robust input validation including:
  - Prevention of empty user names and book titles
  - Menu selection validation (numbers 1-4 only)
  - Type checking to handle non-numeric inputs gracefully
  - Input buffer management to prevent scanner issues
- **User-Friendly Interface**: Clear menu options and navigational prompts

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line terminal or IDE that supports Java

## Project Structure

```
LibraryManagementSystem/
├── src/
│   ├── Book.java        # Book class with properties and methods
│   ├── Library.java     # Library class for managing book collection
│   ├── User.java        # User class for interaction with the library
│   └── Main.java        # Main application with UI and program flow
└── README.md            # Project documentation
```

## Classes

### Book Class
Represents a book with properties such as title, author, and availability status.

### Library Class
Manages the collection of books and provides methods to add, borrow, and return books.

### User Class
Represents a library user who can borrow and return books.

### Main Class
Contains the main program logic and user interface.

## Installation & Setup

1. Clone the repository or download the source files
2. Navigate to the project directory
3. Compile the Java files:

```bash
cd src
javac *.java
```

4. Run the application:

```bash
java Main
```

## Usage

1. **Starting the Application**:
   - Run the application as described above
   - Enter your name when prompted

2. **Viewing Books**:
   - Select option 1 from the menu
   - View the list of all books in the library with their availability status

3. **Borrowing a Book**:
   - Select option 2 from the menu
   - Enter the title of the book you want to borrow
   - The system will confirm if the book was successfully borrowed or not

4. **Returning a Book**:
   - Select option 3 from the menu
   - Enter the title of the book you want to return
   - The system will confirm if the book was successfully returned

5. **Exiting the Application**:
   - Select option 4 from the menu to exit

## Sample Execution

```
======================================
  WELCOME TO THE LIBRARY SYSTEM
======================================
Please enter your name: John

Hello, John! Welcome to our library.

======================================
          LIBRARY MENU
======================================
1. View All Books
2. Borrow a Book
3. Return a Book
4. Exit System
======================================
Enter your choice (1-4): 1

Books in the Library:
- The Hobbit by J.R.R. Tolkien (Available)
- 1984 by George Orwell (Available)
- To Kill a Mockingbird by Harper Lee (Available)

Press Enter to continue...
```

## Input Validation

The application includes validation for:
- Empty user names
- Invalid menu selections
- Empty book titles
- Type mismatches (entering text when a number is expected)

## OOP Concepts Used

This project demonstrates several key Object-Oriented Programming principles:

### 1. Encapsulation

Encapsulation is implemented throughout the project by making instance variables private and providing controlled access through methods:

- **Book Class**: The `title`, `author`, and `isAvailable` fields are private, with getter methods providing read access.
  ```java
  private String title;
  private String author;
  private boolean isAvailable;
  
  public String getTitle() { return title; }
  public String getAuthor() { return author; }
  ```

- **Library Class**: The books collection is encapsulated, and external code can only modify it through the `addBook`, `borrowBook`, and `returnBook` methods.

- **User Class**: The name field is encapsulated with private access and a getter method.

### 2. Abstraction

Abstraction is used to hide implementation details and show only necessary functionality:

- **Library Class**: The `borrowBook` method abstracts the process of finding a book and changing its status.
  ```java
  public void borrowBook(String title) {
      // Implementation details are hidden from the user of this method
      // They only need to provide a title, not worry about how the borrowing works
  }
  ```

- **Main Class**: The `getUserChoice()` method abstracts input validation logic from the main program flow.

### 3. Object Composition

Composition is used to establish relationships between objects:

- **Library Class** contains a collection of **Book** objects:
  ```java
  private ArrayList<Book> books;
  ```

- **User** interacts with **Library** objects through its methods:
  ```java
  public void borrowBook(Library library, String title) {
      library.borrowBook(title);
  }
  ```

### 4. Single Responsibility Principle

Each class has a single responsibility:

- **Book Class**: Responsible only for book-related information and status
- **Library Class**: Responsible for managing the collection of books
- **User Class**: Responsible for user actions and interactions
- **Main Class**: Responsible for the user interface and program flow

### 5. Method Overriding

The `toString()` method from Object class is overridden in the Book class to provide a custom string representation:

```java
@Override
public String toString() {
    return title + " by " + author + (isAvailable ? " (Available)" : " (Borrowed)");
}
```

### 6. Modularity and Reusability

- The classes are designed to be modular and reusable
- The separation of concerns allows for easier maintenance and extension
- Each class can be tested independently

## Future Improvements

Potential enhancements for the system:
- Database integration for persistent storage
- Multiple users with unique IDs
- More book details (ISBN, genre, publication date)
- Admin functionality for adding/removing books
- Search functionality by author or genre

## License

This project is open source and available under the MIT License.

## Contributing

Contributions to improve the Library Management System are welcome:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

## Issues and Support

If you encounter any problems or have suggestions, please:

- Create an issue in the GitHub repository
- Provide detailed steps to reproduce the issue
- Include information about your environment (Java version, OS, etc.)
