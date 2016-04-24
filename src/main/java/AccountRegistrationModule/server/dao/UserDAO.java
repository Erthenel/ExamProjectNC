
package AccountRegistrationModule.server.dao;
import AccountRegistrationModule.shared.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

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
        else session.getTransaction().commit();
        return this.sessionFactory.getCurrentSession();
    }

}
