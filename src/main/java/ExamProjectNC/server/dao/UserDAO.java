package ExamProjectNC.server.dao;

import ExamProjectNC.shared.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

@Repository("UserDAO")
public class UserDAO extends AbstractJpaDAO<Long,User> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    protected Session getSession(){
        Session session=this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        return this.sessionFactory.getCurrentSession();
    }

    //Getter and Setter for SessionFactory
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
