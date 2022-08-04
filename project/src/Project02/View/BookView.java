package Project02.View;

import Project02.Bean.Book;
import Project02.Service.BookList;
import Project02.Utils.BMUtility;

public class BookView {
    public BookList bookList = new BookList(10);

    public void enterMainMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("-----------------Welcome to " +
                    "Yui Reading Management Sysyem-----------------\n" +
                    "Following Functionalist are available");
            System.out.println("1 Add books");
            System.out.println("2 Modify books");
            System.out.println("3 Delete Books");
            System.out.println("4 View All Books in Library");
            System.out.println("5 Logout");
            System.out.print(" Please Select(1-5)：_");

            char menu = BMUtility.readMenuSelection();

            switch (menu) {

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
                    System.out.println("Exit？Y/N");
                    char isExit = BMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        System.out.println("Stay Foolish, Stay Hungry");
                        return;
                    }
                    break;
            }
        }
    }

    private void addNewBooks() {
        System.out.println(" ---------------------addNewBooks---------------------");
        System.out.print("\nEnter Title：");
        //Get the name data entered by the user from the keyboard by calling the method of the tool class
        String title = BMUtility.readString(20);
        System.out.print("\nEnter Subject:");
        String subject = BMUtility.readString(20);
        System.out.print("\nEnter Author：");
        String author = BMUtility.readString(20);
        System.out.println("\nEnter Press：");
        String press = BMUtility.readString(20);
        System.out.println("\nEnter Edition：");
        String edition = BMUtility.readString(20);
        // Add this object to the manager again by calling its method
        Book books = new Book(title, subject, author, press, edition);

        boolean flag = bookList.addNewBooks(books);
        if (flag) {
            System.out
                    .println("---------------------New Books Already Store in the Listing---------------------");
        } else {
            System.out.println("----------------Error in operation, please try again-----------------");
        }
        listAllBooks();
    }
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


        private void listAllBooks () {
            System.out.println("---------------------------allBookListing" + "---------------------------");
            System.out.println("bookID\ttitle\tsubject\tauthor\tpress\tedition");
            Book[] allBookListing = bookList.getAllBooks();
            // Get an array of all valid objects from the manager, loop through the array, print the output
            if (allBookListing.length == 0) {
                System.out.println("emptyBookListing！");
            } else {
                for (int i = 0; i < allBookListing.length; i++) {
                    System.out.println(i + 1 + "\t" + allBookListing[i].getDetails());
                }


            }
        }
    }

