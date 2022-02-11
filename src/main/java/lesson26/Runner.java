package lesson26;

import lesson26.config.SpringConfig;
import lesson26.json.CbrInfoProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.text.ParseException;

public class Runner {
    public static void main(String[] args) throws ParseException, IOException, IllegalAccessException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CbrInfoProvider info = context.getBean(CbrInfoProvider.class);
        info.printCurrencyValue("GBP");

    }
}
