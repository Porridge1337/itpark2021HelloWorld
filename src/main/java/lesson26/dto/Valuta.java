package lesson26.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Valuta {

    @JsonProperty("ID")
    private String id;
    @JsonProperty("NumCode")
    private int numCode;
    @JsonProperty("CharCode")
    private String CharCode;
    @JsonProperty("Nominal")
    private BigInteger nominal;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Value")
    private BigDecimal value;
    @JsonProperty("Previous")
    private BigDecimal previous;

}
