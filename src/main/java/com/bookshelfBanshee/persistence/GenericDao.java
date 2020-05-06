package com.bookshelfBanshee.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
//the T means that it will deal with different types
public class GenericDao<T> {
    //this will hold the type of the object we are dealing with
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }


    /**
     * Gets by id.
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the by id
     */
    public <T>T getById(int id) {
        Session session = getSession();
        //have to cast the type of object
        T entity = (T)session.get(type, id);
        session.disconnect();
        session.clear();
        session.close();
        logger.debug(session.isOpen());
        session = null;
        logger.info("Entity Retrieved: {}", entity);
        return entity;
    }

    /**
     * Save or update.
     *
     * @param entity the entity
     */
    public void saveOrUpdate(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.disconnect();
        session.clear();
        session.close();
        session = null;
        logger.info("Updated entity: {}", entity);
    }

    /**
     * Insert int.
     *
     * @param entity the entity
     * @return the int
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.disconnect();
        session.clear();
        session.close();
        session = null;
        logger.info("Inserted entity: {}", entity);
        return id;
    }

    /**
     * Delete.
     *
     * @param entity the entity
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.disconnect();
        session.clear();
        session.close();
        session = null;
        logger.info("Deleted entity: {}", entity);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
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
        session.clear();
        session.close();
        session = null;

        logger.info("Retrieved all entities");

        return entities;
    }


    /**
     * Gets by property equal.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property equal
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for Entity with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> entities;
        try {
            entities = session.createQuery( query ).getResultList();
        } catch(IllegalArgumentException e) {
            logger.error(e);
            return null;
        }

        session.disconnect();
        session.clear();
        session.close();
        session = null;
        return entities;
    }


    /**
     * Gets by property like.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<T> getByPropertyLike(String propertyName, String value) {

        Session session = getSession();

        logger.debug("Searching for Entity with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<T> entities;
        try {
            entities = session.createQuery( query ).getResultList();
        } catch(IllegalArgumentException e) {
            logger.error(e);
            return null;
        }

        session.disconnect();
        session.clear();
        session.close();
        session = null;
        return entities;
    }

}
