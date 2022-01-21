package lesson20;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.util.Random;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@XmlRootElement
public class Employee {

    @XmlAttribute(name = "ID")
    private final String id;
    @NonNull
    private String login;
    @NonNull
    private String fullName;
    @NonNull
    private String subdivision;
    @NonNull
    private String city;
    @NonNull
    private String position;
    @NonNull
    private String salary;

    public Employee() {
        this(String.valueOf(new Random().nextInt(10000)), "none",
                "none", "none", "none",
                "none", "0");
    }


}
