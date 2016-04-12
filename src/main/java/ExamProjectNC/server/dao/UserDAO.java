package ExamProjectNC.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ExamProjectNC.shared.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository("UserDAO")
public class UserDAO extends AbstractJpaDAO<Long, UserDTO> {

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
