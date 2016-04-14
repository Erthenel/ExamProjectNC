package ExamProjectNC.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ExamProjectNC.shared.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("GroupDAO")
public class GroupDAO extends AbstractJpaDAO<Long, Group> {

    @PersistenceContext(unitName = "ProjectPersistenceUnit")
    EntityManager entityManager;

    @Override
    @Transactional
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    @Transactional
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
