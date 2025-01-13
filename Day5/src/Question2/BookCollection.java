package Question2;
/*
Q2. Create a class BookCollection which contains:
 1. the owner's name and an array of books that the owner has,
 2. toString( ) that outputs all the books in the BookCollection in a nice format.
 3. a method hasBook(Book b) which checks if the book b is contained in the array (we consider two books the same
if they have the same title and author).
 4. a method sort() that sorts the books in the array by the lexicographical order of the book title, and author.
Create your own BookCollection and check if you own a particular book:"Java in depth". Sort the BookCollection
and output the BookCollection.

 */

import java.util.ArrayList;
import java.util.Iterator;

public class BookCollection implements Comparable<BookCollection> {
    ArrayList<String> books = new ArrayList<String>();
    String ownerName;

    public BookCollection(String ownerName) {
        this.ownerName = ownerName;
//        books.add("Java in depth");
//        books.add("The C Programming Language");
//        books.add("The C++ Programming Language");
//        books.add("The C# Programming Language");
//        books.add("The Java Programming Language");
//        books.add("The C++ Programming Language");
        books.add("X");
        books.add("X");
        books.add("Z");
        books.add("D");
        books.add("B");
        books.add("A");
    }

    public String toString() {
        Iterator<String> itr = books.iterator();
        StringBuilder result = new StringBuilder();
//        while (itr.hasNext()) {
//            result= new StringBuilder(itr.next() + "\n");
//        }
//        return result.toString();
        for(String book : books) {
            result.append(book + "\n");
        }
        return result.toString();
    }
    public <books> boolean hasBook(books b) {
        for(String book : books) {
            if(book.equals(b)) {
                return true;
            }
        }
        return false;

    }
    private void sort() {
        books.sort(null);
        System.out.println("sorted books " + books);
    }


    @Override
    public int compareTo(BookCollection o) {
        // System.out.println(o);
        return this.ownerName.compareTo(o.ownerName);
    }

    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection("Maria Tom");
        System.out.println(bookCollection);
      boolean present= bookCollection.hasBook("Java in depth");
      if(present) {
          System.out.println("Book is present");
      } else {
          System.out.println("Book is not present");
      }
        bookCollection.sort();
    }


}
