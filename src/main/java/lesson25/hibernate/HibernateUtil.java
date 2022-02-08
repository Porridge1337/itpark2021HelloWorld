package lesson25.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final Configuration CONFIG;

    static {
        CONFIG = new Configuration();
        CONFIG.configure();
    }

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = CONFIG.buildSessionFactory();
        return sessionFactory;
    }
}
