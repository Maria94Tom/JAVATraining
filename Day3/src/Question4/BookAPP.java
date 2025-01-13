//package Question4;
///*
//Write an application to read a file data.txt containing data like (actually it is a record of an book consisting of
//id, isbn, title, author and price)
//file contain data like
//books.txt
//121:A234:java:raj:456
//102:S234:c++:ekta:567
//1. read the file and populate records in an LinkedList of books
//2. write BookApp
//3. write method searchBook(book id)
//4. write method sellBook(String isbn, int noOfCopies)
//5. write method purchaseBook(String isbn,int noOfCopies)
//6. if Not sufficient book throw exception NotSufficientBookException
// */
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.LinkedList;
//
//class NotSufficientBookException extends Exception {
//
//    public NotSufficientBookException(String notSufficientBook) {
//        super(notSufficientBook);
//    }
//}
//
//public class BookAPP {
//    public static void main(String[] args)  {
//        Book b = new Book(1, "ISBN1", "Book1", 100);
//        LinkedList<Book> llb = new LinkedList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] bookDetails = line.split(":");
//                llb.add(new Book(Integer.parseInt(bookDetails[0]), bookDetails[1], bookDetails[2], Integer.parseInt(bookDetails[3])));
//            }
//            System.out.println("the book details is");
//            for (Book book : llb) {
//                System.out.println(book);
//
//
//            }
//            b.searchBook(121);
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//}