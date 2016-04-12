package ExamProjectNC.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ExamProjectNC.shared.dto.ExamDTO;
import org.springframework.stereotype.Repository;

@Repository("ExamDAO")
public class ExamDAO extends AbstractJpaDAO<Long, ExamDTO> {

    @PersistenceContext(unitName = "ProjectPersistenceUnit")
    EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}