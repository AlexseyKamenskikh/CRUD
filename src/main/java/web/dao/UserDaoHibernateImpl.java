package web.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserDaoHibernateImpl implements UserDao{

//    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
//    private static Map<Integer, User> userList = new HashMap<>();

    @PersistenceContext
    EntityManager entityManager;
//    public UserDaoHibernateImpl() {
//    }

//    static {
//        User user1 = new User("Tom Hardy", "tom@mail.com", "Great Britain");
//        user1.setId(AUTO_ID.getAndIncrement());
//        userList.put(user1.getId(), user1);
//        User user2 = new User("Chuck Norris", "chuck@mail.com", "USA");
//        user2.setId(AUTO_ID.getAndIncrement());
//        userList.put(user2.getId(), user2);
//        User user3 = new User("Anne Hathaway", "anna@mail.com", "USA");
//        user3.setId(AUTO_ID.getAndIncrement());
//        userList.put(user3.getId(), user3);
//    }

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {
        User userDelete = entityManager.find(User.class, id);
        entityManager.remove(userDelete);
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);

    }

}
