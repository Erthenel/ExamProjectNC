package main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import dao.ExamDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.*;
import model.*;

/*
Тестовый класс для UserDAO
 */
public class TestUserDAOSH {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserDAO userDAO = context.getBean(UserDAO.class);
        //тестируем методы здесь

        //Тест метода save
        User user = new User();
        user.setUser_fullName("Stepan Ivanov");
        user.setUser_email("test2@ya.ru");
        user.setUser_password("test2Password");
        user.setUser_role(1);
        userDAO.save(user);
        System.out.println("User::"+user);

        List<User> list = userDAO.list();

        for(User u : list){
            System.out.println("User List::"+u.getUser_fullName());
        }

        context.close();
    }


}
