package lesson25;

import lesson25.dao.AuthorsDAO;
import lesson25.dao.BooksDAO;
import lesson25.dto.Books;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws IOException {
        AuthorsDAO authorsDAO = new AuthorsDAO();
        BooksDAO booksDAO = new BooksDAO();
        do{
            List<Books> booksFromDAO = booksDAO.findBooksByAuthor(getBooksByAuthor());
            System.out.println(booksFromDAO);
        } while (shouldContinue());

       /* List<Authors> authorsList = AuthorsProvider.getAuthors();
        authorsDAO.addAuthors(authorsList);
        List<Books> books = BooksProvider.getBooks();
        for (Iterator<Books> booksIterator = books.iterator(); booksIterator.hasNext(); ) {
            Books book = booksIterator.next();
            book.setAuthors(authorsList.get(0));
        }
        booksDAO.addBooks(books);*/
    }

    private static String getBooksByAuthor() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите автора: ");
        return sc.nextLine();
    }

    private static boolean shouldContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Нажмите 'q' для остановки ввода, для продолжения любой символ.");
        return !sc.nextLine().equals("q");
    }

}
