package pp.service;

import pp.model.User;

import java.util.List;

public interface UserService {
    public void persist(User user);

    public User findById(long id);

    public List<User> findAll();

    public void deleteById(long id);

    public void update(User user);
}
