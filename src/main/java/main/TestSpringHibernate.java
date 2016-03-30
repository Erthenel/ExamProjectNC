package main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import dao.ExamDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDAO;
import model.*;

public class TestSpringHibernate {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserDAO userDAO = context.getBean(UserDAO.class);
       /*
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
        */
        //close resources
        //TEST EXAMDAO

        //ExamDAO examDAO=context.getBean(ExamDAO.class);
        Exam exam = new Exam();
        exam.setExam_date(new Date(123123));
        exam.setExam_subject("maths");
        exam.setExam_theme("unknown!");
        exam.setGroup_id(1);
        exam.setTeacher_id(1);


        userDAO.addExam(exam);
        System.out.println("Exam::" + exam.getExam_theme());

        List<Exam> list = userDAO.list2();

        for (Exam ex : list) {
            System.out.println("User List::" + ex.getExam_subject());
        }

        context.close();
    }


}
