
package ExamProjectNC.server.dao;
import ExamProjectNC.shared.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("UserDAO")
public class UserDAO extends AbstractJpaDAO<Long,User> {

    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    protected Session getSession(){
        Session session=this.sessionFactory.getCurrentSession();
        if (!session.getTransaction().isActive()) session.beginTransaction();
        return this.sessionFactory.getCurrentSession();
    }

}
