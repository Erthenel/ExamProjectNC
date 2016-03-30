package dao;

import java.util.List;

import model.User;

public interface UserDAO {

    void save(User p);

     List<User> list();

}
