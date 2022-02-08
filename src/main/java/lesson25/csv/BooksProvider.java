package lesson25.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lesson25.dao.AuthorsDAO;
import lesson25.dto.Authors;
import lesson25.dto.Books;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@UtilityClass
public class BooksProvider {

    private static final Path BOOK_PATH = Paths.get("./src/main/resources/lesson25/Books.csv");
    private final AuthorsDAO dao = new AuthorsDAO();

    public List<Books> getBooks() throws IOException {
        try (Reader reader = Files.newBufferedReader(BOOK_PATH)) {
            List<Books> allBooks;
            CsvToBean<Books> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Books.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            allBooks = csvToBean.parse();
            for (Books book : allBooks) {
                Authors authors = dao.findAuthorById(book.getAuthors_id());
                book.setAuthors(authors);
            }
            return allBooks;
        }
    }
}
