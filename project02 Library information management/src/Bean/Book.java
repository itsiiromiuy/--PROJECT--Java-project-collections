package Bean;

/**
 * @Description: The Book class represents an entity that encapsulates customer information.
 * It contains the following attributes:
 * - String name: The name of the customer.
 * - char gender: The gender of the customer.
 * - int age: The age of the customer.
 * - String phone: The phone number of the customer.
 * - String email: The email address of the customer.
 *
 * The class provides getter and setter methods for each attribute, allowing access and modification of book information.
 * It also offers a constructor to initialize the book object with the required attributes.
 */
public class Book {
    private String title;         // Title of a book
    private String subject;       // Subject to which a book is related!
    private String author;        // Author of book!
    private String press;        // Press of book!
    private String edition;        // Edition of book!


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Book(String title, String subject, String author, String press, String edition) {
        this.title = title;
        this.subject = subject;
        this.author = author;
        this.press = press;
        this.edition = edition;


    }
    public String getDetails() {
        return title + "\t" + subject + "\t" + author + "\t" + press + "\t" + edition;
    }

}

