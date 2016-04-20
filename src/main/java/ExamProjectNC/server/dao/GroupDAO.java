package ExamProjectNC.server.dao;
import ExamProjectNC.shared.model.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("GroupDAO")
public class GroupDAO extends AbstractJpaDAO<Long, Group> {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }

    @Override
    protected Session getSession(){
        Session session=this.sessionFactory.getCurrentSession();
        if (!session.getTransaction().isActive()) session.beginTransaction();
        else session.getTransaction().commit();
        return this.sessionFactory.getCurrentSession();
    }

}

