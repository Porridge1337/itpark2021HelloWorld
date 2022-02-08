package lesson25.dao;

import lesson25.dto.Books;
import lesson25.hibernate.HibernateUtil;
import lesson25.dto.Authors;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
            if (!authorIsExist(author.getAuthor())) {
                session.save(author);
            }
            transaction.commit();
        }
    }

    public void addAuthors(List<Authors> authorsList) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            for (Authors author : authorsList) {
                if (!authorIsExist(author.getAuthor())) {
                    session.save(author);
                }
            }
            transaction.commit();
        }
    }

    public boolean authorIsExist(String author) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            boolean result = true;
            Transaction transaction = session.beginTransaction();
            Query<Authors> searchQuery = session.createQuery("from Authors where author =: name", Authors.class);
            searchQuery.setParameter("name", author);
            if (searchQuery.list().isEmpty()) {
                result = false;
            }
            transaction.commit();
            return result;
        }
    }
}
