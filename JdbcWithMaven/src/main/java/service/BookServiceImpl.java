package service;

import repository.Book;
import repository.BookDao;
import repository.BookDaoImp;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao=new BookDaoImp();


    @Override
    public List<Book> getAllBooks() {

        return bookDao.getAllBooks();
    }

    @Override
    public Book addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteBook(id);

    }

    @Override
    public void updateBook(int id, Book book) {
        bookDao.updateBook(id,book);

    }

    @Override
    public List<Book> getBookById(int id) {
        return  bookDao.getBookById(id);
    }
}
