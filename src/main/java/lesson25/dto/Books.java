package lesson25.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Getter
@Setter
@ToString()
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "db", name = "books2")
public class Books {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "ISBN", nullable = false, unique = true)
    @CsvBindByName
    private long ISBN;
    @Column(name = "title", nullable = false)
    @CsvBindByName
    private String title;
    @Column(name = "link", nullable = false, columnDefinition = "TEXT")
    @CsvBindByName
    private String link;
    @Column(name = "pages", nullable = false)
    @CsvBindByName
    private int pages;
    @Column(name = "attributes")
    @CsvBindByName
    private String attributes;
    @Transient
    @CsvBindByName()
    private int authors_id;
    @ManyToOne
    @JoinColumn(name = "authors_id")
    private Authors authors;
}
