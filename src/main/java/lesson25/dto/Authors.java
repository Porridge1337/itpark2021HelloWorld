package lesson25.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
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
    @GeneratedValue
    @CsvBindByName
    private long id;
    @Column(name = "author", unique = true)
    @CsvBindByName
    private String author;
    @OneToMany(mappedBy = "authors")
    private List<Books> books = new ArrayList<>();


}
