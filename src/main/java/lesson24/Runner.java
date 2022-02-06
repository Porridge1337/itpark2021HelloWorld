package lesson24;

import lesson24.csv.BooksProvider;
import lesson24.dao.BooksDAO;
import lesson24.dto.Books;

import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws Exception {
        BooksDAO booksDAO = new BooksDAO();
        List<Books> books = new BooksProvider().getBooks();

        booksDAO.fillBooks(books);
        do {
            List<Books> booksFromDAO = booksDAO.findByAuthor(getBooks());
            System.out.println(booksFromDAO);
        } while (shouldContinue());

    }

    private static String getBooks() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите автора: ");
        String city = sc.nextLine();
        return city;
    }

    private static boolean shouldContinue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Нажмите 'q' для остановки ввода, для продолжения любой символ.");
        if (!sc.nextLine().equals("q")) {
            return true;
        } else return false;
    }
}
