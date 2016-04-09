package dao;

import model.Exam;

import java.util.Collection;
import java.sql.SQLException;
import java.util.List;

public interface ExamDAO {
    public void addExam(Exam exam);

    public void updateExam(int exam_id, Exam exam);

    public Exam getExamById(int exam_id);

    public List<Exam> getAllExams();

    public void deleteExam(Exam exam);
}


