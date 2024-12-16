package pp.dao;

import pp.model.User;

import java.util.List;

public interface UserDao {
    public void persist(User user);
    public User findById(int id);
    public List<User> findAll();
    public void delete(int id);
    public void update(User user);

}
