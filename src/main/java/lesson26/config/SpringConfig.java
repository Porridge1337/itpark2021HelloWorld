package lesson26.config;

import lesson26.json.CbrInfoProvider;
import lesson26.json.impl.CbrInfoProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan("lesson26")
public class SpringConfig {

    @Bean
    public CbrInfoProvider cbrInfoProvider() throws IOException, IllegalAccessException {
        return new CbrInfoProviderImpl();
    }

}
