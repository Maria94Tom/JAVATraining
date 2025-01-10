package AssignmentQ2;

import java.util.Scanner;

public class BookStore {
    private int SIZE;
    private String bookStoreName;
    private Book[] books;

    //Book[]: This specifies that books is an array of Book objects. In Java, arrays are a collection of elements of a particular type (in this case, Book), and this array will hold the references to Book objects.
    public BookStore(String bookStoreName, int size) {
        SIZE = size;
        this.bookStoreName = bookStoreName;
        this.books = new Book[SIZE];
        init();
    }

    private void init() {
        books[0] = new Book("C++", "GK", "1111111", 4);
        books[1] = new Book("C", "a23332bc", "22222222", 20);
        books[2] = new Book("Python", "rtyttred", "333333", 8);
        // books[3]=new Book("head first core java", "foo", "50545A12", 20);
        //  books[4]=new Book("spring in action", "bar", "14545A12", 10);
    }

    public void sell(String bookTitle, int noOfCopies) {
        boolean found = false;
        for (int i = 0; i < SIZE; i++) {
            if (books[i].getBookTitle().equals(bookTitle)) {
                if (books[i].getNumOfCopies() > noOfCopies) {
                    books[i].setNumOfCopies(books[i].getNumOfCopies() - noOfCopies);
                    found = true;
                    System.out.println(noOfCopies + "copies of the book sold successfully" + books[i].getNumOfCopies() + "is now present in the store");
                } else if (books[i].getNumOfCopies() < noOfCopies) {
                    System.out.println("Only" + books[i].getNumOfCopies() + "is present in the store,and selling those copies.");
                    books[i].setNumOfCopies(0);
                    System.out.println(books[i].getNumOfCopies());
                    found = true;
                } else if (books[i].getNumOfCopies() == 0) {
                    System.out.println("Out of stock");
                }

            }

        }

        if (found == false) {
            System.out.println("Book is not present");
        }
    }

    public void order(String ISBN, int noOfCopiesOrder) {
        boolean found = false;

        // Loop through the books array to check if the book with the given ISBN exists
        for (int i = 0; i < SIZE; i++) {
            // Check if the current book is not null and its ISBN matches
            if (books[i] != null && books[i].getIsbn().equals(ISBN)) {  // Use .equals() for string comparison
                // Update the number of copies if the book is found
                books[i].setNumOfCopies(books[i].getNumOfCopies() + noOfCopiesOrder);
                found = true;
                break; // Exit the loop once the book is found and updated
            }
        }

        // If the book was not found, add a new entry (or handle it appropriately)
        if (!found) {
            System.out.println("Book not found in store. Adding a new entry.");

            // Find the first available slot or handle dynamically resizing the array
            for (int i = 0; i < SIZE; i++) {
                if (books[i] == null) {
                    books[i] = new Book("Title", "Author", ISBN, 5);
                    break;
                }
            }
            System.out.println("Books present in the store.");
            for (int i = 0; i < SIZE; i++) {
                if(books[i]!=null){
                    System.out.println(books[i].displayBookTitle());
                }

            }


        }
    }
}