package com.bookshelfBanshee.persistence;

import com.bookshelfBanshee.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        logger.info("User Retrieved: {}", user);
        return user;
    }

    public void saveOrUpdate(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
        logger.info("Updated user: {}", user);
    }

    public int insert(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(user);
        transaction.commit();
        session.close();
        logger.info("Inserted user: {}", user);
        return id;
    }

    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
        logger.info("Deleted user: {}", user);
    }

    public List<User> getAll() {
        //get session out of session factory
        Session session = sessionFactory.openSession();
        //used for get all users, and ones with where clauses
        CriteriaBuilder builder = session.getCriteriaBuilder();
        //use it to create a query for a specific entity and specify on which class the query will execute
        CriteriaQuery<User> query = builder.createQuery(User.class);
        //like from portion of query
        Root<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();
        session.close();

        logger.info("Retrieved all users");

        return users;
    }

}
