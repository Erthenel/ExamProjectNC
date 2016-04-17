package ExamProjectNC.server.dao;
import ExamProjectNC.shared.model.Examined;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("ExaminedDAO")
public class ExaminedDAO extends AbstractJpaDAO<Long, Examined> {

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
        return this.sessionFactory.getCurrentSession();
    }

}