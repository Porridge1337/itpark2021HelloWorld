package lesson24;

import lesson24.csv.BooksProvider;
import lesson24.dao.BooksDAO;
import lesson24.dto.Books;

import java.util.List;

public class Runner {

    public static void main(String[] args) throws Exception {
        BooksDAO booksDAO = new BooksDAO();
        List<Books> books = new BooksProvider().getBooks();

        booksDAO.fillBooks(books);
        booksDAO.deleteBook(2);
        List<Books> booksFromDAO = booksDAO.findById(0);
        System.out.println(booksFromDAO);
    }


}
