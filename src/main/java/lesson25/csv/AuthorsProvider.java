package lesson25.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lesson25.dto.Authors;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class AuthorsProvider {

    private static Path AUTHORS_PATH = Paths.get("./src/main/resources/lesson25/Authors.csv");

    public static List<Authors> getAuthors() throws IOException {
        try (Reader reader = Files.newBufferedReader(AUTHORS_PATH)) {
            List<Authors> allAuthors = new ArrayList<>();
            CsvToBean<Authors> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Authors.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            allAuthors = csvToBean.parse();
            // eraseCSVFile(BOOK_PATH);
            return allAuthors;
        }
    }

}
