package main;


/*
Тестовый класс для ExaminedService
 */

import ExamProjectNC.server.dao.*;
import ExamProjectNC.shared.dto.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestExaminedDAOSH {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        AbstractJpaDAO examinedDAO = context.getBean(AbstractJpaDAO.class);

        //тестируем методы здесь


        context.close();
    }

}
