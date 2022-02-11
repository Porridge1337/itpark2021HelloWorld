package lesson26.service.cbr;

import lesson26.dto.CbrDailyInfo;

import java.io.IOException;

public interface CbrInfoProvider {
    CbrDailyInfo getCbrDailyInfo() throws IOException;
}
