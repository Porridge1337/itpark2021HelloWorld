package lesson24.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import lesson24.dto.Books;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BooksProvider {

    private static Path BOOK_PATH = Paths.get("./src/main/resources/lesson24/Books.csv");


    public List<Books> getBooks() throws Exception {
        try (Reader reader = Files.newBufferedReader(BOOK_PATH)) {
            List<Books> allBooks = new ArrayList<>();
            CsvToBean<Books> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Books.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            allBooks = csvToBean.parse();
            eraseCSVFile(BOOK_PATH);
            return allBooks;
        }
    }

    private void eraseCSVFile(Path path) {
        try (Reader reader = Files.newBufferedReader(path)) {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> allElements = csvReader.readAll();
            for (int i = 1; i < allElements.size(); i++) {
                allElements.remove(i);
            }
            FileWriter sw = new FileWriter(path.toString());
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(allElements);
            writer.close();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

}
