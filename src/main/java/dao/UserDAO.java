package dao;

import java.util.List;

import model.User;
import model.Exam;

public interface UserDAO {

    public void addExam(Exam exam);
    void save(User p);

     List<User> list();

    List<Exam> list2();

}
