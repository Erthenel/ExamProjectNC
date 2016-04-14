package main;


/*
Тестовый класс для GroupService
 */

import ExamProjectNC.server.dao.*;
import ExamProjectNC.shared.models.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestGroupDAOSH {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        AbstractJpaDAO groupDAO = context.getBean(AbstractJpaDAO.class);

        //тестируем методы здесь


        context.close();
    }

}
