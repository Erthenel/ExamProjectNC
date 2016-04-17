package ExamProjectNC.server.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractJpaDAO<K, E>  {

    protected Class<E> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractJpaDAO() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }
    @Transactional
    public void persist(E entity) {
        getSession().persist(entity);
    }

    @Transactional
    public void delete(E entity) {
        getSession().delete(entity);
    }

    @Transactional
    public void update(E entity) {
        getSession().update(entity);
    }

    /*
    You should use Merge() if you are trying to update objects that were at one point detached from the session,
    especially if there might be persistent instances of those objects currently associated with the session.
    Otherwise, using SaveOrUpdate() in that case would result in an exception.
    merge() does the following:
    *if there is a persistent instance with the same identifier currently associated with the session,
     copy the state of the given object onto the persistent instance
    *if there is no persistent instance currently associated with the session,
     try to load it from the database, or create a new persistent instance
     the persistent instance is returned the given instance does not become associated with the session, it remains detached
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public E merge(E entity) {
        return (E) getSession().merge(entity);
    }

    /*saveOrUpdate() does the following:
    *if the object is already persistent in this session, do nothing
    *if another object associated with the session has the same identifier, throw an exception
    *if the object has no identifier property, save() it
    *if the object's identifier has the value assigned to a newly instantiated object, save() it
    *if the object is versioned (by a <version> or <timestamp>), and the version property value is the same value assigned to
     a newly instantiated object, save() it
    *otherwise update() the object */
    @Transactional
    public void SaveOrUpdate(E entity){getSession().saveOrUpdate(entity);}

    @SuppressWarnings("unchecked")
    @Transactional
    public E findById(int id) {
        return (E) getSession().load(entityClass, id);}

    @Transactional
    public E flush(E entity) {
        getSession().flush();
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<E> findAll() {
        String queryStr = "SELECT h FROM " + entityClass.getName() + " h";
        Query query = getSession().createQuery(queryStr);
        List<E> resultList = query.list();
        return resultList;
    }

    @Transactional
    public Integer deleteAll() {
        String queryStr = "DELETE FROM " + entityClass.getName() + " h";
        Query query = getSession().createQuery(queryStr);
        return query.executeUpdate();
    }

    public abstract void setSessionFactory(SessionFactory sessionFactory);
    public abstract SessionFactory getSessionFactory();
    protected abstract Session getSession();
}
