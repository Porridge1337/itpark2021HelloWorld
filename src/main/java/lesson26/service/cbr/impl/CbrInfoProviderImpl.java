package lesson26.service.cbr.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson26.dto.CbrDailyInfo;
import lesson26.service.cbr.CbrInfoProvider;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@NoArgsConstructor
public class CbrInfoProviderImpl implements CbrInfoProvider {

    private static final String CBR_RUL = "https://www.cbr-xml-daily.ru/daily_json.js";
    private ObjectMapper mapper;

    @Autowired
    public CbrInfoProviderImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CbrDailyInfo getCbrDailyInfo() throws IOException {
        CbrDailyInfo cbrInfo = mapper.readValue(getUrl(), CbrDailyInfo.class);
        return cbrInfo;
    }

    private URL getUrl() throws MalformedURLException {
        return new URL(CBR_RUL);
    }

}
