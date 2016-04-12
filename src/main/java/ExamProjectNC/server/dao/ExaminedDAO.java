package ExamProjectNC.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ExamProjectNC.shared.dto.ExaminedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ExaminedDAO")
public class ExaminedDAO extends AbstractJpaDAO<Long, ExaminedDTO> {

    @PersistenceContext(unitName = "ProjectPersistenceUnit")
    EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}