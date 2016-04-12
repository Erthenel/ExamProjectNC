package ExamProjectNC.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ExamProjectNC.shared.dto.GroupDTO;
import org.springframework.stereotype.Repository;

@Repository("GroupDAO")
public class GroupDAO extends AbstractJpaDAO<Long, GroupDTO> {

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
