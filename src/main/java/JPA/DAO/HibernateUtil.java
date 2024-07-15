package JPA.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    /*Session Factory é a configuração necessária para abrir as Sessions e Transactions*/
    private static SessionFactory sessionFactory = buildSessionFactory();

    /*Cria uma nova Configuration, com base nas informações do hibernate.cfg.xml*/
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError("Erro ao configurar o Hibernate" + e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
