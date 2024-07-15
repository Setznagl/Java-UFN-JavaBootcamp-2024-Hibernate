package JPA;

import JPA.DAO.CategoriaDAO;
import JPA.DAO.HibernateUtil;
import JPA.DAO.LivroDAO;
import JPA.Model.Categoria;
import JPA.Model.Livro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session tmp_session = sf.openSession();
        tmp_session.beginTransaction();

        CategoriaDAO c = new CategoriaDAO();

        Categoria tmp_categoria = Categoria.builder().
                id(2).
                nome("Clássicos").build();


        tmp_session.merge(tmp_categoria);
        tmp_session.getTransaction().commit();
        tmp_session.close();
        sf.close();
    }
}

/*
public static void main(String[] args) {
    Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Session tmp_session = sf.openSession();
    tmp_session.beginTransaction();

    CategoriaDAO c = new CategoriaDAO();

    Categoria tmp_categoria = Categoria.builder()
            .id(2)
            .nome("Lançamento")
            .build();

    // Use merge() em vez de persist()
    tmp_session.merge(tmp_categoria);

    tmp_session.getTransaction().commit();
    tmp_session.close();
    sf.close();
}
 */