package pp.dao;

import pp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    public void persist(User user);
    public Optional<User> findById(long id);
    public List<User> findAll();
    public void deleteByID(long id);
    public void update(User user);

}
