public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Library library, String title) {
        System.out.println(name + " is trying to borrow \"" + title + "\"...");
        library.borrowBook(title);
    }

    public void returnBook(Library library, String title) {
        System.out.println(name + " is trying to return \"" + title + "\"...");
        library.returnBook(title);
    }
}
