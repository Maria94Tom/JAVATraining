package repository;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImp implements BookDao {
    private Connection connection;

    public BookDaoImp() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books=new ArrayList<>();
        try{
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Book");
            while (rs.next()){
             books.add(new Book(rs.getInt("id"),(rs.getString("isbn")),
                        rs.getString("title"),rs.getString("author"),rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book addBook(Book book) {
        try{
            Statement stmt=connection.createStatement();
            stmt.executeUpdate("insert into Book values("+book.getId()+",'"+book.getIsbn()+"','"+book.getTitle()+"','"+book.getAuthor()+"',"+book.getPrice()+")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public void deleteBook(int id) {
        try{
            Statement stmt=connection.createStatement();
            stmt.executeUpdate("delete from Book where id="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateBook(int id, Book book) {
        try{
            Statement stmt=connection.createStatement();
            stmt.executeUpdate("update Book set isbn='"+book.getIsbn()+"',title='"+book.getTitle()+"',author='"+book.getAuthor()+"',price="+book.getPrice()+" where id="+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Book> getBookById(int id) {
        List <Book> booksId=new ArrayList<>();
        try{
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from Book where id="+id);
            while (rs.next()){
                booksId.add( new Book(rs.getInt("id"),(rs.getString("isbn")),rs.getString("title"),rs.getString("author"),rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (List<Book>) booksId;
    }
}
