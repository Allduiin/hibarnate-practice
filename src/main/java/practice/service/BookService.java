package practice.service;

import java.util.List;
import practice.dao.GenericDao;
import practice.model.Author;
import practice.model.Book;
import practice.model.Genre;

public interface BookService extends GenericDao<Book> {
    Book getBookByTitle(String title);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByGenre(Genre genre);
}
