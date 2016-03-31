package main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.*;
import model.*;

/*
Тестовый класс для GroupDAO
 */
public class TestGroupDAOSH {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        GroupDAO groupDAO = context.getBean(GroupDAO.class);

        //тестируем методы здесь


        context.close();
    }

}
