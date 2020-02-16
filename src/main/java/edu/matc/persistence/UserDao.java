package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public User getById(int id) {
        return User;
    }

    public void saveOrUpdate(User user) {

    }

    public int insert(User user) {
        return 0;
    }

    public void delete(User user) {

    }

    public List<User> getAll() {

        return null;
    }

}
