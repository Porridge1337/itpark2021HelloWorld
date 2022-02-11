package lesson26.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyCache {
    Map<String, Valuta> currencyCache;

    public Valuta printСurrencyInfo(String currency) {
        return this.currencyCache.get(currency.toUpperCase(Locale.ROOT));
    }

}
