package practice.service.impl;

import java.util.List;
import practice.dao.BookDao;
import practice.lib.Inject;
import practice.lib.Service;
import practice.model.Author;
import practice.model.Book;
import practice.model.Genre;
import practice.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Inject
    private BookDao bookDao;

    @Override
    public Book getBookByTitle(String title) {
        return bookDao.getBookByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookDao.getBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return bookDao.getBooksByGenre(genre);
    }

    @Override
    public Book add(Book book) {
        return bookDao.add(book);
    }
}
