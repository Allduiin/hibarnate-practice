package practice.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import practice.dao.GenreDao;
import practice.exceptions.DataProcessingException;
import practice.lib.Dao;
import practice.model.Genre;
import practice.util.HibernateUtil;

@Dao
public class GenreDaoImpl implements GenreDao {

    @Override
    public Genre add(Genre genre) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(genre);
            transaction.commit();
            session.save(genre);
            return genre;
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
