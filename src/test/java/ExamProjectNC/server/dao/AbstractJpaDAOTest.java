package ExamProjectNC.server.dao;

import ExamProjectNC.shared.models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;


public class AbstractJpaDAOTest {
    @org.junit.Test
    public void persist() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO = context.getBean(UserDAO.class);
        User user = new User();
        user.setUser_fullName("Roman Smirnov");
        user.setUser_email("email2@mail.ru");
        user.setUser_password("Password2");
        user.setUser_role(1);
        userDAO.persist(user);
    }
/*
    @org.junit.Test
    public void remove() throws Exception {

    }

    @org.junit.Test
    public void refresh() throws Exception {

    }

    @org.junit.Test
    public void merge() throws Exception {

    }

    @org.junit.Test
    public void findById() throws Exception {

    }

    @org.junit.Test
    public void flush() throws Exception {

    }

    @org.junit.Test
    public void findAll() throws Exception {

    }

    @org.junit.Test
    public void removeAll() throws Exception {

    }

    @org.junit.Test
    public void getEntityManager() throws Exception {

    }
*/
}