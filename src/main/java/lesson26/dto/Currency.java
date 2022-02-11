package lesson26.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {

    @JsonProperty("AUD")
    private Valuta aud;
    @JsonProperty("AZN")
    private Valuta azn;
    @JsonProperty("GBP")
    private Valuta gbp;
    @JsonProperty("AMD")
    private Valuta amd;
    @JsonProperty("BYN")
    private Valuta byn;
    @JsonProperty("BGN")
    private Valuta bgn;
    @JsonProperty("BRL")
    private Valuta brl;
    @JsonProperty("HUF")
    private Valuta huf;
    @JsonProperty("HKD")
    private Valuta hkd;
    @JsonProperty("DKK")
    private Valuta dkk;
    @JsonProperty("USD")
    private Valuta usd;
    @JsonProperty("EUR")
    private Valuta eur;
    @JsonProperty("INR")
    private Valuta inr;
    @JsonProperty("KZT")
    private Valuta kzt;
    @JsonProperty("CAD")
    private Valuta cad;
    @JsonProperty("KGS")
    private Valuta kgs;
    @JsonProperty("CNY")
    private Valuta cny;
    @JsonProperty("MDL")
    private Valuta mdl;
    @JsonProperty("NOK")
    private Valuta nok;
    @JsonProperty("PLN")
    private Valuta pln;
    @JsonProperty("RON")
    private Valuta ron;
    @JsonProperty("XDR")
    private Valuta xdr;
    @JsonProperty("SGD")
    private Valuta sgd;
    @JsonProperty("TJS")
    private Valuta tjs;
    @JsonProperty("TRY")
    private Valuta turkishLira;
    @JsonProperty("TMT")
    private Valuta tmt;
    @JsonProperty("UZS")
    private Valuta uzs;
    @JsonProperty("UAH")
    private Valuta uah;
    @JsonProperty("CZK")
    private Valuta czk;
    @JsonProperty("SEK")
    private Valuta sek;
    @JsonProperty("CHF")
    private Valuta chf;
    @JsonProperty("ZAR")
    private Valuta zar;
    @JsonProperty("KRW")
    private Valuta krw;
    @JsonProperty("JPY")
    private Valuta jpy;

}
