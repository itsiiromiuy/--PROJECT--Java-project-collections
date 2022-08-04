package Project02.Service;

import Project02.Bean.Book;

/**
 * This class is used for the management of Customer objects,
 * Internally uses an array of Customer object type as a property
 * and use this array as storage for Customer objects
 * It is the management module of the object and provides multiple methods for CustomerView
 * Call, it can also be said that it is a service module that provides underlying data support services
 */
public class BookList {
    /**
     * Internally encapsulates a Book[] to provide addition, deletion, modification and query operations for Book data
     */
    private Book[] books;
    private int Count = 0;       // record the number of saved customer objects


    /**
     * @param totalCount : Specifies the maximum space for the BookList array to store data
     * @Description constructor, used to initialize the customers array
     */
    public BookList(int totalCount) {
        books = new Book[totalCount];
        //total = 0;
    }


    /**
     * @param index
     * @param editBooks
     * @return replace success true
     * @Description replaces the array element at the specified index
     */
    public boolean replaceBook( int index, Book editBooks) {
        if(index < 0 || index >= Count) {
            return false;
        }
        books[index] = editBooks;
        return true;
    }


    /**
     * @param newBook
     * @return Returns true if the addition is successful; false indicates that the array is full and cannot be added
     * @Description adds the parameter customer after the last customer object record in the group
     */
    public boolean addNewBooks(Book newBook) {
        if (Count == books.length) {
            grow();
        }
        books[Count] = newBook;
        Count++;
        return true;
    }

    private void grow() {
        //System.out.println("Expansion array....");
        // 1) Expansion array: Create a new array with a larger capacity than the original
        int newLen = books.length * 3 / 2;
        if (newLen <= 1) {
            newLen = 2;
        }
        Book[] newArr = new Book[newLen];
        // 2) Copy all elements in the old array to the new array in turn
        for(int i = 0; i < books.length; i++) {
            newArr[i] = books[i];
        }
        // 3) old array reference points to new array
        books = newArr;
    }

    /**
     * @param index specifies the index position of the deleted object in the array
     * @return Returns true if the deletion is successful; false indicates that the index is invalid and cannot be deleted
     * @Description deletes the customer object record at the index specified by the parameter index from the array
     */
    public boolean deleteBooks(int index) {
        if (index < 0 || index >= Count) {
            return false;
        }
        // 1) Dispose of the subscript position to be deleted as empty
        books[index] = null;
        // 2) Starting from the subscript position to be deleted, copy the adjacent elements on the right to the left in turn
        //** i < count -1 Prevent subscript out of bounds
        for (int i = index; i <Count - 1; i++) {
            books[i] = books[i + 1];
        }
        // 3) Dispose of the previous most significant element position as a hole 4) Adjust the counter
        /*customers[total-1]=null
         * total--;*/
        books[--Count] = null; // Reduce before use
        return true;

    }

    /**
     * @Description Get an array of all customers objects
     * @return newCustomer
     */
    public Book[] getAllBooks() {
        // 1) Create a new array, the capacity is the counter
        Book[] newArr = new Book[Count];
        // 2) Save all valid objects in the internal array in turn in the new array
        for(int i = 0; i <Count ; i++) {
            newArr[i] = this.books[i];
        }
        // 3) return new array
        return newArr;
    }

    /**
     * @Description : Returns the customer object record at the index position specified by the parameter index
     * @param index specifies the index position of the customer object to be obtained in the array
     * @return Customer object that encapsulates customer information
     */
    public Book getBook(int index) {
        if (index < 0 || index >= Count) {
            return null;
        }
        return this.books[index];
    }

}


