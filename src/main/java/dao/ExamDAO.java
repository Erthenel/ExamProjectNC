package dao;

import model.Exam;

import java.util.Collection;
import java.sql.SQLException;
import java.util.List;

public interface ExamDAO {
    public void addExam(Exam exam) throws SQLException;

    public void updateExam(Long exam_id, Exam exam) throws SQLException;

    public Exam getExamBYId(Long exam_id) throws SQLException;

    public void deleteExam(Exam exam) throws SQLException;

    public Collection getAllExams() throws SQLException;

    List<Exam> list();
}

