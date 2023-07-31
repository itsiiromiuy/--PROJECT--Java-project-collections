package Service;
import Bean.Book;
/**
 * @Description: The BookList class serves as an efficient module for managing a collection of Book objects. It internally utilizes an array to store and organize the books, offering essential methods for adding, modifying, and deleting entries.
 */
public class BookList {
    private Book[] books; // An array of Book objects
    private int total = 0; // The number of books currently in the array

    /**
     * @Description: Constructor. Initialize the array with the specified size
     * @param totalBooks
     */
     public BookList(int totalBooks) {
        books = new Book[totalBooks]; // Initialize the array with the specified size
     }

    /**
     * @Description: Add a book to the array
     * @param book
     * @return true if the book is successfully added, false if the array is full
     */
    public boolean addBooks(Book book) {
       if (total >= books.length) {
            return false;
        }
        books[total] = book;
        total++;
        return true;
    }
    /**
     * @Description: Modify the book at the specified index
     * @param index
     * @param book
     * @return true if the book is successfully modified, false if the index is invalid
     */
    public boolean replaceBooks(int index, Book book) {
        if(index < 0 || index >= total) {
            return false;
        }
        // Modify the book at the specified index
        books[index] = book;
        return true;
    }
    /**
     * @Description: Delete the book at the specified index
     * @param index
     * @return true if the book is successfully deleted, false if the index is invalid
     */

    public boolean deleteBooks(int index) {
        if(index < 0 || index >= total) {
            return false;
        }

        for (int i = index; i < total - 1; i++) {
            books[i] = books[i + 1];
        }
        books[total - 1] = null;
        total--;
        return true;
    }
    /**
     * @Description: Get all books in the array
     * @return a Book[] array containing all books in the array
     */
    public Book[] getAllBooks() {
        // Create a new array with the same size as the current array
        Book[] newBooks =  new Book[total];
        for (int i = 0; i < total; i++) {
            newBooks[i] = books[i];
        }
        return newBooks;
    }
    /**
     * @Description: Get the book at the specified index
     * @param index
     * @return the book at the specified index, null if the index is invalid
     */
    public Book getBooks(int index) {
        if(index < 0 || index >= total) {
            return null;
        }
        return books[index];
    }
    /**
     * @Description: Get the number of books currently in the array
     * @return
     */
    public int getTotal() {
        return total;
    }

}
