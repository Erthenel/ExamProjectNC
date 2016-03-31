package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Exam;

public class ExamDAOImpl implements ExamDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addExam(Exam exam) throws SQLException {
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.save(exam);
            session.getTransaction().commit();
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, e.getMessage(), "Input error", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateExam(Long exam_id, Exam exam) throws SQLException {
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.update(exam);
            session.getTransaction().commit();
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, e.getMessage(), "Update error", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Exam getExamById(Long exam_id) throws SQLException {
        Session session = null;
        Exam exam = null;
        try {
            session = this.sessionFactory.openSession();
            exam = (Exam) session.load(Exam.class, exam_id);
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, e.getMessage(), "FindBy error", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return exam;
    }

    public void deleteExam(Exam exam) throws SQLException {


    }


    public Collection getAllExams() throws SQLException {
        Session session = null;
        List exams = new ArrayList<Exam>();
        try {
            session = this.sessionFactory.openSession();
            exams = session.createCriteria(Exam.class).list();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage(), "FindBy error", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Exam> list() {
        Session session = this.sessionFactory.openSession();
        List<Exam> examList = session.createQuery("from model.Exam").list();
        session.close();
        return examList;
    }
}
