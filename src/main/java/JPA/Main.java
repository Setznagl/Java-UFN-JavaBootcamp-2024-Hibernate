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

        LivroDAO l = new LivroDAO();
        Livro tmp_livro = Livro.builder().
                isbn(1234567890123L).
                nome("Crime e Castigo").
                categoria("Clássico").
                quantidade(5).build();
        LivroDAO.save(tmp_livro);

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

