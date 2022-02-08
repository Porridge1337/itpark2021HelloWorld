package lesson25.dao;

import lesson25.dto.Authors;
import lesson25.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class AuthorsDAO {

    public Authors findAuthorById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Authors> searchQuery = session.createQuery("from Authors where id =: object", Authors.class);
            searchQuery.setParameter("object", id);
            List<Authors> authors = searchQuery.list();
            if (searchQuery.list().isEmpty()) {
                throw new NoSuchElementException("В базе данных объект Authors с id = " + id + " не найдено");
            }
            transaction.commit();
            return authors.get(0);
        }
    }

    public void addAuthor(Authors author) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            deleteAuthors();
            session.save(author);
            transaction.commit();
        }
    }

    public void addAuthors(List<Authors> authorsList) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            deleteAuthors();
            for (Authors author : authorsList) {
                session.save(author);
            }
            transaction.commit();
        }
    }

    public void deleteAuthors() {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Authors> allQuery = session.createQuery("from Authors", Authors.class);
            List<Authors> authors = allQuery.list();
            if (!authors.isEmpty()) {
                for (Iterator<Authors> iterator = authors.iterator(); iterator.hasNext(); ) {
                    Authors authors1 = iterator.next();
                    session.delete(authors1);
                }
            }
            transaction.commit();
        }
    }
}
