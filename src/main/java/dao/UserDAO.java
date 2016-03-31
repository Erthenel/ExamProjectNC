package dao;

import java.util.List;

import model.User;
import model.Exam;

public interface UserDAO {

    void save(User p);

    List<User> list();


}
