package lesson26.json.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson26.dto.CbrDailyInfo;
import lesson26.dto.Currency;
import lesson26.dto.Valuta;
import lesson26.json.CbrInfoProvider;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class CbrInfoProviderImpl implements CbrInfoProvider {

    private static final String CBR_RUL = "https://www.cbr-xml-daily.ru/daily_json.js";
    private CbrDailyInfo cbrInfo;
    private ObjectMapper mapper = new ObjectMapper();
    private Map<String, BigDecimal> cache = new HashMap<>();

    public CbrInfoProviderImpl() throws IOException, IllegalAccessException {
        getCbrDailyInfo();
        fillCache();
    }

    @Override
    public void printCurrencyValue(String currency){
        System.out.println(cache.get(currency));
    }

    private CbrDailyInfo getCbrDailyInfo() throws IOException {
        cbrInfo = mapper.readValue(getUrl(), CbrDailyInfo.class);
        return cbrInfo;
    }

    private URL getUrl() throws MalformedURLException {
        return new URL(CBR_RUL);
    }

    private void fillCache() throws IllegalAccessException {
        Class<Currency> currencyClass = Currency.class;
        Field[] declaredFields = currencyClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field modelField = declaredFields[i];
            modelField.setAccessible(true);
            Valuta valuta = (Valuta) modelField.get(cbrInfo.getValute());
            cache.put(valuta.getCharCode(), valuta.getValue());
        }
    }


}
