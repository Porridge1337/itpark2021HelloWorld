package lesson27.config;

import lesson27.service.AnotherDAOService;
import lesson27.service.DAOService;
import lesson27.service.impl.AnotherDAOServiceImpl;
import lesson27.service.impl.DaoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@ComponentScan("lesson27")
public class AppConfig {

    @Bean
    public DAOService daoService() {
        return new DaoServiceImpl(anotherDAOService());
    }

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
    public AnotherDAOService anotherDAOService() {
        return new AnotherDAOServiceImpl();
    }

}
