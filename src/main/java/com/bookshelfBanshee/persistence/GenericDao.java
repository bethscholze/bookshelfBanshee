package com.bookshelfBanshee.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

//the T means that it will deal with different types
public class GenericDao<T> {
    //this will hold the type of the object we are dealing with
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public GenericDao(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }


    public <T>T getById(int id) {
        Session session = getSession();
        //have to cast the type of object
        T entity = (T)session.get(type, id);
        session.close();
        logger.info("Entity Retrieved: {}", entity);
        return entity;
    }

    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
        logger.info("Updated entity: {}", entity);
    }

    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        logger.info("Inserted entity: {}", entity);
        return id;
    }

    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
        logger.info("Deleted entity: {}", entity);
    }

    public List<T> getAll() {
        //get session out of session factory
        Session session = getSession();
        //used for get all users, and ones with where clauses
        CriteriaBuilder builder = session.getCriteriaBuilder();
        //use it to create a query for a specific entity and specify on which class the query will execute
        CriteriaQuery<T> query = builder.createQuery(type);
        //like from portion of query
        Root<T> root = query.from(type);
        List<T> entities = session.createQuery(query).getResultList();
        session.close();

        logger.info("Retrieved all entities");

        return entities;
    }

    //add in the get by property methods to get books based on user id
}
