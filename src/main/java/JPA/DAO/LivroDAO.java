package JPA.DAO;

import JPA.Model.Livro;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class LivroDAO {
    private static SessionFactory local_factory = HibernateUtil.getSessionFactory();

    public static List<Livro> findAll() {
        try (Session tmp_session = local_factory.openSession()) {
            return tmp_session.createQuery("from Livro ").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Não foi possível encontrar todos os livros" + e.getMessage());
        }
    }

    public static void save(Livro livro_parametro) {
        Transaction transaction = null;
        try (Session tmp_session = local_factory.openSession()) {
            transaction = tmp_session.beginTransaction();
            tmp_session.merge(livro_parametro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao gravar" + e.getMessage());
        }
    }

    public static void delete(Livro livro) {
        Transaction transaction = null;
        try (Session tmp_session = local_factory.openSession()) {
            transaction = tmp_session.beginTransaction();
            tmp_session.delete(livro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao deletar" + e.getMessage());
        }
    }

    public static Livro findById(int id) {
        try (Session tmp_session = local_factory.openSession()) {
            return tmp_session.get(Livro.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao buscar" + e.getMessage());
        }
    }

    public static void update(Livro livro) {
        Transaction transaction = null;
        try (Session tmp_session = local_factory.openSession()) {
            transaction = tmp_session.beginTransaction();
            tmp_session.update(livro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao atualizar" + e.getMessage());
        }
    }
}

