package ExamProjectNC.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ExamProjectNC.shared.models.Examined;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ExaminedDAO")
public class ExaminedDAO extends AbstractJpaDAO<Long, Examined> {

    @PersistenceContext(unitName = "ProjectPersistenceUnit")
    EntityManager entityManager;

    @Override
    @Transactional
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @PersistenceContext
    @Transactional
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}