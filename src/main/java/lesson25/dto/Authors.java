package lesson25.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "books")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "db", name = "authors")
public class Authors {

    @Id
    @CsvBindByName
    private long id;
    @Column(name = "author", unique = true)
    @CsvBindByName
    private String author;
    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private List<Books> books = new ArrayList<>();


}
