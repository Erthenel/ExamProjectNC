package main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.*;
import model.*;

/*
Тестовый класс для ExamDAO
 */
public class TestExamDAOSH {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        ExamDAO examDAO = context.getBean(ExamDAO.class);

        //тестируем методы здесь


        Exam exam = new Exam();
        exam.setExam_subject("math");
        //текущая дата
        exam.setExam_date(new Date(new java.util.Date().getTime()));
        exam.setExam_theme("my_theme");
        Group group = new Group();
        group.setGroup_id(3);
        group.setGroup_name("third");
        /*
        exam.setGroup(group);
        User teacher = new User();
        teacher.setUser_id(1);
        exam.setTeacher(teacher);

        */
        examDAO.addExam(exam);



        context.close();


        context.close();
    }
}
