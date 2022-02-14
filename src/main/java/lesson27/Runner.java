package lesson27;

import lesson27.config.AppConfig;
import lesson27.service.AnotherDAOService;
import lesson27.service.DAOService;
import lesson27.service.impl.AnotherDAOServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DAOService dao = context.getBean(DAOService.class);
        dao.save();
        AnotherDAOService anotherDAO = context.getBean(AnotherDAOService.class);
        anotherDAO.print();

    }

}
