package JPA;

import JPA.DAO.CategoriaDAO;
import JPA.DAO.HibernateUtil;
import JPA.DAO.LivroDAO;
import JPA.Model.Categoria;
import JPA.Model.Livro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session tmp_session = sf.openSession();
        tmp_session.beginTransaction();

        CategoriaDAO c = new CategoriaDAO();

        Categoria tmp_cat = Categoria.builder().
                id(1).
                livros(new ArrayList<Livro>()).
                nome("Clássicos").build();

        CategoriaDAO.save(tmp_cat);

        LivroDAO l = new LivroDAO();

        Livro tmp_livro = Livro.builder().
                isbn(123456789128L).
                nome("As Crônicas de Nárnia").
                categoria(CategoriaDAO.findById(1)).
                quantidade(6).build();

        Livro tmp_livro2 = Livro.builder().
                isbn(123456789188L).
                nome("O Senhor dos Aneis").
                categoria(CategoriaDAO.findById(1)).
                quantidade(2).build();

        LivroDAO.save(tmp_livro);
        LivroDAO.save(tmp_livro2);

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

