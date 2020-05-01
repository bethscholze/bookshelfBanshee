package com.bookshelfBanshee.persistence;

import com.mchange.v2.c3p0.C3P0Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//the T means that it will deal with different types
public class GenericDao<T> {
    //this will hold the type of the object we are dealing with
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());
//    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

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
        session.disconnect();
        session.close();
        logger.info("Entity Retrieved: {}", entity);
        return entity;
    }

    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.disconnect();
        session.close();
        logger.info("Updated entity: {}", entity);
    }

    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.disconnect();
        session.close();
        logger.info("Inserted entity: {}", entity);
        return id;
    }

    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.disconnect();
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
        session.disconnect();
        session.close();

        logger.info("Retrieved all entities");

        return entities;
    }


    public List<T> getByPropertyEqual(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for Entity with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entities = session.createQuery(query).getResultList();
        session.disconnect();
        session.close();
        return entities;
    }


    public List<T> getByPropertyLike(String propertyName, String value) {
//        Session session = sessionFactory.openSession();
        Session session = getSession();

        logger.debug("Searching for Entity with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entities = session.createQuery( query ).getResultList();
        session.disconnect();
        session.close();
        return entities;
    }

}
