package View;
import Bean.Book;
import Service.BookList;
import Project02.Utils.BMUtility;

/**
 * @Description: A user interface display module responsible for handling interface logic. It displays menus, receives user input, and calls the relevant methods of BookList.
 */


public class BookView {
    private BookList bookList = new BookList(10);

    public BookView(){
        Book book = new Book("Dune", "Science Fiction", "Frank Herbert", "Chilton Books", "August 1965");
        bookList.addBooks(book);
    }
}
    /**
     * @Description: Display the main menu and receive user input
     * @return The user input
     */
    public void enterMainMenu() {
        boolean loopFlag = true;
        while (loopFlag){

            System.out.println("Welcome to the library information management system!");
            System.out.println("\t1 Add a new book");
            System.out.println("\t2 Modify a book");
            System.out.println("\t3 Delete a book");
            System.out.println("\t4 List all books");
            System.out.println("\t5 Exit the system");
            System.out.print("Please enter your choice: ");

            char menuSelection = BMUtility.readMenuSelection();

            switch(menuSelection){
                case '1':
                    addNewBooks();
                    break;
                case '2':
                    modifyBooks();
                    break;
                case '3':
                    deleteBooks();
                    break;
                case '4':
                    listAllBooks();
                    break;
                case '5':
                    System.out.println("Are you sure you want to exit the system? (Y/N)");
                    char isExit = BMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        System.out.println("Thank you for using the library information management system!");
                        return;
                    }
                    break;
            }
        }
    }
    /**
     * @Description: Display the menu for adding a new book and receive user input
     * @return The user input
     */
    private void addNewBooks() {
        System.out.println(" ---------------------addNewBooks---------------------");
        System.out.print("Please enter the book name: ");
        String title = BMUtility.readString(20);
        System.out.print("Please enter the book subject: ");
        String subject = BMUtility.readString(20);
        System.out.print("Please enter the book author: ");
        String author = BMUtility.readString(20);
        System.out.print("Please enter the book press: ");
        String press = BMUtility.readString(20);
        System.out.print("Please enter the book edition: ");
        String edition = BMUtility.readString(20);

        // Create a Book object, and add it to the book list
        Book book = new Book(title, subject, author, press, edition);
         boolean isSuccess = bookList.addBooks(book);
        if (isSuccess) {
            System.out.println("The book is successfully added!");
        } else {
            System.out.println("The book list is full and the book cannot be added!");
        }
    }
    /**
     * @Description: Display the menu for modifying a book and receive user input
     * @return The user input
     */
    private void modifyBooks () {
        System.out.println(" ---------------------modifyBooks---------------------");
        Book modifyBookIndex;
        int userInput;
        for (; ; ) {
            System.out.print("Please select the number of the book to be modified (-1 to Exit : ");
            userInput = BMUtility.readInt();
            //If it is -1, do not delete, return in advance
            if (userInput == -1) {
                return;
            }
            ///If the target object is empty, print the output number error, if it is not empty, jump out of the for loop
            modifyBookIndex = bookList.getBook(userInput - 1);
            //If the target object is empty, print the output number error, if it is not empty, jump out of the for loop
            if (modifyBookIndex == null) {
                System.out.println("Unable to find the specified customer");
            } else {
                break;
            }

        }
        //Unconditionally modify the book property of the target object
        System.out.println("Title(" + modifyBookIndex.getTitle() + ")");
        String title = BMUtility.readString(10, modifyBookIndex.getTitle());
        System.out.println("Subject(" + modifyBookIndex.getSubject() + ")");
        String subject = BMUtility.readString(10, modifyBookIndex.getSubject());
        System.out.println("Author(" + modifyBookIndex.getAuthor() + ")");
        String author = BMUtility.readString(10, modifyBookIndex.getAuthor());
        System.out.println("Mail(" + modifyBookIndex.getPress() + ")");
        String press = BMUtility.readString(10, modifyBookIndex.getPress());
        System.out.println("Phone(" + modifyBookIndex.getEdition() + ")");
        String edition = BMUtility.readString(10, modifyBookIndex.getEdition());
        Book newBook = new Book(title, subject, author, press, edition);

        bookList.replaceBook(userInput - 1, newBook);

    }
    /**
     * @Description: Display the menu for deleting a book and receive user input
     * @return The user input
     */
    private void deleteBooks () {
        System.out.println(" ---------------------deleteBooks---------------------");
        listAllBooks();
        int userInput;
        System.out.print("Please select the number of the book to be modified (-1 to Exit : ");
        //Get the number entered by the user from the keyboard
        userInput = BMUtility.readInt();
        if (userInput == -1) {
            return;
        }
        System.out.println("Confirm whether to delete(Y/N) : ");
        char confirmDelete = BMUtility.readConfirmSelection();
        if (confirmDelete == 'Y') {
            //Call the manager's method to complete the deletion
            boolean flag = bookList.deleteBooks(userInput - 1);
            if (flag) {
                System.out.println("---------------------delete complete---------------------");
            } else {
                System.out.println("--------------------Delete failed, reason: wrong ID---------------------");
            }
        }
        listAllBooks();
    }
    /**
     * @Description: Display the menu for listing all books and receive user input
     * @return The user input
     */
    private void listAllBooks() {
        System.out.println(" ---------------------listAllBooks---------------------");

        int total = bookList.getTotal();
        if (total == 0) {
            System.out.println("There are no books in the library.");
        } else {
            System.out.println("Book ID\tBook Name\tBook Subject\tBook Author\tBook Press\tBook Edition");
            Book[] books = bookList.getAllBooks();
            for (int i = 0; i < total; i++) {
                Book book = books[i];
                System.out.println((i + 1) + '\t' + book.getTitle() + '\t' + book.getSubject() + '\t' + book.getAuthor() + '\t' + book.getPress() + '\t' + book.getEdition());
            }
        }
    }
}


