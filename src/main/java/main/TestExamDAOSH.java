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


        context.close();
    }
}
