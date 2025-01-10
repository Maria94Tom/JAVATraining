package Question4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class readFile {
    public static void main(String[] args) throws IOException {
        Book b = new Book(1,"ISBN1","Book1",100);
        LinkedList<Book> llb =new LinkedList<>();
      try( BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
          String line;
          while ((line = reader.readLine()) != null) {
              String[] bookDetails = line.split(":");
              llb.add(new Book(Integer.parseInt(bookDetails[0]), bookDetails[1], bookDetails[2], Integer.parseInt(bookDetails[3])));
          }
          System.out.println("the book details is");
          for (Book book : llb) {
              System.out.println(book);
          }
      }
    }

}