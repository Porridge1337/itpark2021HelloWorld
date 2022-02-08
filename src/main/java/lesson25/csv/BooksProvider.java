package lesson25.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import lesson25.dto.Books;
import lombok.experimental.UtilityClass;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@UtilityClass
public class BooksProvider {

    private static Path BOOK_PATH = Paths.get("./src/main/resources/lesson25/Books.csv");


    public List<Books> getBooks() throws IOException {
        try (Reader reader = Files.newBufferedReader(BOOK_PATH)) {
            List<Books> allBooks = new ArrayList<>();
            CsvToBean<Books> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Books.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            allBooks = csvToBean.parse();
           // eraseCSVFile(BOOK_PATH);
            return allBooks;
        }
    }

    private void eraseCSVFile(Path path) {
        try (Reader reader = Files.newBufferedReader(path)) {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> allElements = csvReader.readAll();
            for (Iterator<String[]> iterator = allElements.iterator(); iterator.hasNext(); ) {
                String[] element = iterator.next();
                if (!element[0].equals("ISBN")) {
                    iterator.remove();
                }
            }
            clearCSV(allElements, path);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private void clearCSV(List<String[]> elements, Path path) {
        try (FileWriter sw = new FileWriter(path.toString())) {
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(elements);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
