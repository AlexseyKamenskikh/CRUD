package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoHibernateImpl;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Qualifier("getUserDao")
    @Autowired
    UserDao userDao;
//    UserDao userDao = new UserDaoHibernateImpl();


    @Override
    @Transactional
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional
    public void delete(int id){
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void edit(User user){
        userDao.edit(user);
    }

    @Override
    @Transactional
    public User getUserById(int id){
        return userDao.getUserById(id);
    }
}
