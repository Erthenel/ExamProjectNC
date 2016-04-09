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

    public void addExam(Exam exam) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(exam);
        transaction.commit();
        session.close();
    }

    public void updateExam(int exam_id, Exam exam) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(exam);
        transaction.commit();
        session.close();
    }

    public Exam getExamById(int exam_id) {
        Session session = this.sessionFactory.openSession();
        Exam exam = (Exam) session.load(Exam.class, exam_id);
        session.close();
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<Exam> getAllExams() {
        Session session = this.sessionFactory.openSession();
        List  exams = session.createCriteria(Exam.class).list();
        session.close();
        return exams;
    }

    public void deleteExam(Exam exam) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(exam);
        transaction.commit();
        session.close();
    }
}

