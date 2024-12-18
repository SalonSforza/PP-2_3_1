package pp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pp.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager em;


    @Transactional
    @Override
    public void persist(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public Optional <User> findById(long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Transactional
    @Override
    public List<User> findAll() {
        TypedQuery <User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void deleteByID(long id) {
        Optional<User> u = findById(id);
        u.ifPresent(x -> em.remove(x));
    }

    @Transactional
    @Override
    public void update(User user) {
        em.merge(user);
    }
}
