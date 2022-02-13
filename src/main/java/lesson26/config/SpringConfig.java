package lesson26.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson26.service.cache.CacheProvider;
import lesson26.service.cache.impl.CacheProviderImpl;
import lesson26.service.cbr.CbrInfoProvider;
import lesson26.service.cbr.impl.CbrInfoProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("lesson26")
public class SpringConfig {

    @Bean
    public CbrInfoProvider cbrInfoProvider() {
        return new CbrInfoProviderImpl(objectMapper());
    }

    @Bean
    public CacheProvider cacheProvider() {
        return new CacheProviderImpl();
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }


}
