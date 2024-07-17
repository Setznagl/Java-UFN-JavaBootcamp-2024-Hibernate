package JPA;

import JPA.DAO.HibernateUtil;
import JPA.DAO.LivroDAO;
import JPA.Model.Livro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Main {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session tmp_session = sf.openSession();
        tmp_session.beginTransaction();

        

        tmp_session.getTransaction().commit();
        tmp_session.close();
        sf.close();
    }
}

/*
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session tmp_session = sf.openSession();
        tmp_session.beginTransaction();
*/
/*
        tmp_session.getTransaction().commit();
        tmp_session.close();
        sf.close();
*/

