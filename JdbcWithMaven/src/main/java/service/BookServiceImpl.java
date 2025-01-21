package service;

import exceptions.BookNotFoundException;
import exceptions.DAOException;
import repository.Book;
import repository.BookDao;
import repository.BookDaoImp;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao=new BookDaoImp();


    @Override
    public List<Book> getAllBooks() {
        try {

            return bookDao.getAllBooks();
        }
        catch (DAOException e){
            throw new BookNotFoundException(e.getMessage());
        }
    }

    @Override
    public Book addBook(Book book) {
        try{
            return bookDao.addBook(book);
        }
        catch (DAOException e){
            throw new BookNotFoundException(e.getMessage());
        }

    }

    @Override
    public void deleteBook(int id) {
        try{
            bookDao.deleteBook(id);
        }
        catch (DAOException e){
            throw new BookNotFoundException(e.getMessage());
        }


    }

    @Override
    public void updateBook(int id, Book book) {
        try{
            bookDao.updateBook(id,book);
        }
        catch (DAOException e){
            throw new BookNotFoundException(e.getMessage());
        }


    }

    @Override
    public List<Book> getBookById(int id) {
        try{
            return bookDao.getBookById(id);
        }
        catch (DAOException e){
            throw new BookNotFoundException(e.getMessage());
        }

    }
}
