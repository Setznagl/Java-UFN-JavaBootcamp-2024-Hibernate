package JPA.DAO;

import JPA.Model.Categoria;
import JPA.Model.Livro;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CategoriaDAO {
    private SessionFactory local_factory = HibernateUtil.getSessionFactory();

    public List<Categoria> findAll() {
        try (Session tmp_session = local_factory.openSession()) {
            return tmp_session.createQuery("from Categoria ").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Não foi possível encontrar todas as categorias" + e.getMessage());
        }
    }

    public void save(Categoria categoria_parametro) {
        Transaction transaction = null;
        try (Session tmp_session = local_factory.openSession()) {
            transaction = tmp_session.beginTransaction();
            tmp_session.persist(categoria_parametro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao gravar" + e.getMessage());
        }
    }

    public void delete(Categoria categoria_parametro) {
        Transaction transaction = null;
        try (Session tmp_session = local_factory.openSession()) {
            transaction = tmp_session.beginTransaction();
            tmp_session.delete(categoria_parametro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new HibernateException("Erro ao deletar" + e.getMessage());
        }
    }

    public Categoria findById(int id) {
        try (Session tmp_session = local_factory.openSession()) {
            return tmp_session.get(Categoria.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new HibernateException("Erro ao buscar" + e.getMessage());
        }
    }

    public void update(Categoria categoria_parametro) {
        Transaction transaction = null;
        try (Session tmp_session = local_factory.openSession()) {
            transaction = tmp_session.beginTransaction();
            tmp_session.update(categoria_parametro);
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
