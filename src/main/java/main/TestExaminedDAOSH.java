package main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import dao.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import model.*;

/*
Тестовый класс для ExaminedDAO
 */
public class TestExaminedDAOSH {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        ExaminedDAO examinedDAO = context.getBean(ExaminedDAO.class);

        //тестируем методы здесь


        context.close();
    }

}
