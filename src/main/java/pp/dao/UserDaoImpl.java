package pp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pp.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager em;


    @Transactional
    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        TypedQuery <User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void delete(int id) {
        em.remove(em.find(User.class, id));
    }

    @Transactional
    @Override
    public void update(User user) {
        em.merge(user);
    }
}
