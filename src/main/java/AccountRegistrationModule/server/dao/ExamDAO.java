package AccountRegistrationModule.server.dao;
import AccountRegistrationModule.shared.model.Exam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ExamDAO")
public class ExamDAO extends AbstractJpaDAO<Long, Exam> {

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
