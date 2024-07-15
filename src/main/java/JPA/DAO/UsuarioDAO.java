package JPA.DAO;

import JPA.Model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioDAO {
    private SessionFactory factory = HibernateUtil.getSessionFactory();

    public List<Usuario> findAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Usuario").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Não foi possível encontrar todos os Departamentos " + e.getMessage());
        }
    }

    public void save(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao gravar novo Departamento " + e.getMessage());
        }
    }

    public void delete(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao deletar Departamento " + e.getMessage());
        }
    }

    public Usuario findById(int id) {
        try (Session session = factory.openSession()) {
            return session.get(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao buscar Departamento " + e.getMessage());
        }
    }

    public void update(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao atualizar Departamento " + e.getMessage());
        }
    }
}
