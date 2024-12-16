package pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp.dao.UserDao;
import pp.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void persist(User user) {
        userDao.persist(user);
    }

    @Override
    public User findById(long id) {
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
    public void update(User user) {
        userDao.update(user);
    }
}
