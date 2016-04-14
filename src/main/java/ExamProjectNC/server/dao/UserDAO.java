package ExamProjectNC.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ExamProjectNC.shared.models.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

@Repository("UserDAO")
public class UserDAO extends AbstractJpaDAO<Long, User> {

    @PersistenceContext(unitName = "ProjectPersistenceUnit")
    EntityManager entityManager;

    @Override
    @Transactional
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    @Transactional
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


}
