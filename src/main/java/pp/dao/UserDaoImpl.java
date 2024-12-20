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



    @Override
    public void persist(User user) {
        em.persist(user);
    }


    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }


    @Override
    public List<User> findAll() {
        TypedQuery <User> query = em.createQuery("from User", User.class);
        return query.getResultList();
    }


    @Override
    public void deleteByID(long id) {
       em.remove(findById(id));
    }


    @Override
    public void update(User user) {
        em.merge(user);
    }
}
