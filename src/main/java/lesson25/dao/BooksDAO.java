package lesson25.dao;

import lesson25.dto.Authors;
import lesson25.dto.Books;
import lesson25.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BooksDAO {


    public void addBooks(List<Books> booksList) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            for (Books book : booksList) {
                session.save(book);
            }
            transaction.commit();
        }
    }

    public void addBook(Books book) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }
    }

    public List<Books> findBooksByAuthor(String author) {
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Authors> searchAuthorQuery = session.createQuery("from Authors where author =: name", Authors.class);
            searchAuthorQuery.setParameter("name", author);
            Authors queryAuthor = searchAuthorQuery.getSingleResult();
            Query<Books> searchBooksQuery = session.createQuery("from Books where authors.id =: author_id", Books.class);
            searchBooksQuery.setParameter("author_id", queryAuthor.getId());
            List<Books> searchedBooks = searchBooksQuery.getResultList();
            transaction.commit();
            return searchedBooks;
        }
    }

}
