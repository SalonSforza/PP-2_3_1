package pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp.dao.UserDao;
import pp.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void persist(User user) {
        userDao.persist(user);
    }

    @Override
    public Optional<User> findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteByID(id);
    }

    @Override
    public void update(User user, long id) {
        Optional<User> u = userDao.findById(id);
        u.ifPresent(x -> x.setName(user.getName()));
        u.ifPresent(x -> x.setAge(user.getAge()));
        userDao.update(user);
    }
}
