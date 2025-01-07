/*
Q2. Create a book store application which will help a book store to keep the record of its books. For
each book, the application will have the Book Title, Book Author, Book ISBN along with the
number of copies for each book. The system will allow you to display all books, order new/existing
books and sell books. With sell or order of existing books, number of copies will decrease/increase.
With order of new book, a new book entry will be added to the system.
Here is what you need to do.
 1) Create the following Book class.
Book
String bookTitle String
author String ISBN
int numOfCopies
Book(String, String, String, int)
void display()
Here is what you need to do.
 1) Create the following Book class.
 2) display() method will display the book info in “Title – Author – ISBN – Quantity” format.
2) Create another class “BookStore” which should contain all the book objects. For now use an
array of Book type and assume you can have maximum 10 different books but each could have
multiple copies.
a. sell(String, int) method will search for the book in books array using the bookTitle value. If the
book is found in the list, number of copies will decrease. If the book is not found a message should
display that book is not found
b. order(String, int) method will order book for the book store. You have to handle both new book
and existing book scenario.
i. First search for the book in “books” array using the isbn value.
ii. If the book is found in the list (which means the book already exists in the system), number of
copies will increase.
iii. If the book is not found (which means the book does not exists in the system and you need to
order new book), a new book entry will be added to the books array.
c. display() method will display info of all books in “books” array “Title – Author – ISBN –
Quantity” format. Use Book class’s display() method to display each book’s info.
3) Now create class “BookStoreApp” which should contain the main method. In main method
create an object of BookStore class and then Test the different functionality of BookStore
*/

package AssignmentQ2;

public class AssignmentDay2Q2 {
    public static void main(String[] args) {

    }
}
