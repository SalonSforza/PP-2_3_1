package pp.dao;

import pp.model.User;

import java.util.List;

public interface UserDao {
    public void persist(User user);
    public User findById(long id);
    public List<User> findAll();
    public void deleteByID(long id);
    public void update(User user);

}
