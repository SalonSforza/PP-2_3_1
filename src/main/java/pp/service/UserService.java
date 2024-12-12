package pp.service;

import pp.model.User;

import java.util.List;

public interface UserService {
    public void save(User user);
    public User findById(int id);
    public List<User> findAll();
    public void delete(int id);
    public void update(User user);
}
