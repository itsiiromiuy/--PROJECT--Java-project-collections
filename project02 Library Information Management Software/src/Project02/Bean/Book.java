package Project02.Bean;

public class Book {
    // it distinguishable from other books
    private String title;         // Title of a book
    private String subject;       // Subject to which a book is related!
    private String author;        // Author of book!
    private String press;
    private String edition;

    public Book() {
    }

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
