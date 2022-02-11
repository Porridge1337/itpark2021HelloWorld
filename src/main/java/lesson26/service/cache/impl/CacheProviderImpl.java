package lesson26.service.cache.impl;

import lesson26.dto.CbrDailyInfo;
import lesson26.dto.Currency;
import lesson26.dto.CurrencyCache;
import lesson26.dto.Valuta;
import lesson26.service.cache.CacheProvider;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CacheProviderImpl implements CacheProvider {

    @Override
    public CurrencyCache getCurrencyСache(CbrDailyInfo cbrDailyInfo) throws IllegalAccessException {
        Map<String, Valuta> currencyCache = new HashMap<>();
        Class<Currency> currencyClass = Currency.class;
        Field[] declaredFields = currencyClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field modelField = declaredFields[i];
            modelField.setAccessible(true);
            Valuta valuta = (Valuta) modelField.get(cbrDailyInfo.getValute());
            currencyCache.put(valuta.getCharCode(), valuta);
        }
        return new CurrencyCache(currencyCache);
    }
}
