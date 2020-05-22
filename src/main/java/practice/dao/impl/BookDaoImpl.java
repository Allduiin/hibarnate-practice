package practice.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import practice.dao.BookDao;
import practice.exceptions.DataProcessingException;
import practice.lib.Dao;
import practice.model.Author;
import practice.model.Book;
import practice.model.Genre;
import practice.util.HibernateUtil;

@Dao
public class BookDaoImpl implements BookDao {

    @Override
    public Book add(Book book) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            session.save(book);
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Error adding cinema hall", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Book getBookByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return (Book) session.createQuery("FROM Book where title =: title")
                    .setParameter("title", title)
                    .getSingleResult();
        } catch (Exception e) {
            throw new DataProcessingException("Error getting Book by title", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("FROM Book where authors =: author")
                    .setParameter("author", author)
                    .list();
        } catch (Exception e) {
            throw new DataProcessingException("Error getting Book by author", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.createQuery("FROM Book where genre =: genre")
                    .setParameter("genre", genre)
                    .list();
        } catch (Exception e) {
            throw new DataProcessingException("Error getting Book by genre", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
