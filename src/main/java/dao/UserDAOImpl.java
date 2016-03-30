package dao;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.*;

public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> userList = session.createQuery("from model.User").list();
        session.close();
        return userList;
    }

    public void addExam(Exam exam) {
        Session session = null;
        session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(exam);
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public List<Exam> list2() {
        Session session = this.sessionFactory.openSession();
        List<Exam> examList = session.createQuery("from model.Exam").list();
        session.close();
        return examList;
    }
}


