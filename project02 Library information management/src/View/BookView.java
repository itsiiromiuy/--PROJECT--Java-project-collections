package View;
import Service.BookList;
/**
 * @Description: A user interface display module responsible for handling interface logic. It displays menus, receives user input, and calls the relevant methods of BookList.
 */


public class BookView {
    private BookList bookList = new BookList(10);
    /**
     * @Description: Display the main menu and receive user input
     * @return The user input
     */
    public void enterMainMenu() {
        boolean loopFlag = true;
        do {

            System.out.println("Welcome to the library information management system!");
            System.out.println("\t1 Add a new book");
            System.out.println("\t2 Modify a book");
            System.out.println("\t3 Delete a book");
            System.out.println("\t4 List all books");
            System.out.println("\t5 Exit the system");
            System.out.print("Please enter your choice: ");
        }while (loopFlag);
        
    }
    /**
     * @Description: Display the menu for adding a new book and receive user input
     * @return The user input
     */
    public void addNewBook() {


    }
    /**
     * @Description: Display the menu for modifying a book and receive user input
     * @return The user input
     */
    public void modifyBook() {

    }
    /**
     * @Description: Display the menu for deleting a book and receive user input
     * @return The user input
     */
    public void deleteBook() {

    }
    /**
     * @Description: Display the menu for listing all books and receive user input
     * @return The user input
     */
    private void listAllBooks() {

    }
    /**
     * @Description: Display the menu for exiting the system and receive user input
     * @return The user input
     */
    public void exitSystem() {

    }


