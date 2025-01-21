package repository;

import factory.ConnectionFactory;

import java.sql.*;
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
//            Statement stmt=connection.createStatement();
//            stmt.executeUpdate("insert into Book values("+book.getId()+",'"+book.getIsbn()+"','"+book.getTitle()+"','"+book.getAuthor()+"',"+book.getPrice()+")");
       PreparedStatement stmt=connection.prepareStatement("insert into Book values(?,?,?,?,?)");
            stmt.setInt(1,book.getId());
            stmt.setString(2,book.getIsbn());
            stmt.setString(3,book.getTitle());
            stmt.setString(4,book.getAuthor());
            stmt.setDouble(5,book.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public void deleteBook(int id) {
        try{
//            Statement stmt=connection.createStatement();
//            stmt.executeUpdate("delete from Book where id="+id);
            PreparedStatement stmt=connection.prepareStatement("delete from Book where id=?");
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateBook(int id, Book book) {
        try{
//            Statement stmt=connection.createStatement();
//            stmt.executeUpdate("update Book set isbn='"+book.getIsbn()+"',title='"+book.getTitle()+"',author='"+book.getAuthor()+"',price="+book.getPrice()+" where id="+id);
       PreparedStatement stmt=connection.prepareStatement("update Book set isbn=?,title=?,author=?,price=? where id=?");
            stmt.setString(1,book.getIsbn());
            stmt.setString(2,book.getTitle());
            stmt.setString(3,book.getAuthor());
            stmt.setDouble(4,book.getPrice());
            stmt.setInt(5,id);
            stmt.executeUpdate();
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
