package ExamProjectNC.server.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;

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
        getEntityManager().persist(entity);
    }

    @Transactional
    public void remove(E entity) {
        getEntityManager().remove(entity);
    }

    @Transactional
    public void refresh(E entity) {
        getEntityManager().refresh(entity);
    }

    @Transactional
    public E merge(E entity) {
        return getEntityManager().merge(entity);
    }

    @Transactional
    public E findById(K id) {
        return getEntityManager().find(entityClass, id);
    }

    @Transactional
    public E flush(E entity) {
        getEntityManager().flush();
        return entity;
    }

    @Transactional
    public List<E> findAll() {
        String queryStr = "SELECT h FROM " + entityClass.getName() + " h";
        Query query = getEntityManager().createQuery(queryStr, entityClass);
        List<E> resultList = query.getResultList();
        return resultList;
    }

    @Transactional
    public Integer removeAll() {
        String queryStr = "DELETE FROM " + entityClass.getName() + " h";
        Query query = getEntityManager().createQuery(queryStr);
        return query.executeUpdate();
    }

    protected abstract EntityManager getEntityManager();

}
