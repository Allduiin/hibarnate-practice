package practice.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import practice.dao.AuthorDao;
import practice.exceptions.DataProcessingException;
import practice.lib.Dao;
import practice.model.Author;
import practice.util.HibernateUtil;

@Dao
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public Author add(Author author) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
            session.save(author);
            return author;
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
}
