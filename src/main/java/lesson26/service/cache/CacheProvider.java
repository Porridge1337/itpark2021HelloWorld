package lesson26.service.cache;

import lesson26.dto.CbrDailyInfo;
import lesson26.dto.CurrencyCache;

public interface CacheProvider {

    CurrencyCache getCurrencyСache (CbrDailyInfo cbrDailyInfo) throws IllegalAccessException;

}
