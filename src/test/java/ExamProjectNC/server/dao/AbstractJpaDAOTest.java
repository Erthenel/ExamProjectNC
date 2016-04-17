package ExamProjectNC.server.dao;


import ExamProjectNC.shared.model.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AbstractJpaDAOTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    UserDAO userDAO = context.getBean(UserDAO.class);

    /*
    Test for adding values in a 'user' table*/
    @org.junit.Test
    public void persist() throws Exception {
        /*User user = new User();
        user.setUser_fullName("Roman Smirnov");
        user.setUser_email("email2@mail.ru");
        user.setUser_password("Password2");
        user.setUser_role(1);
        userDAO.persist(user);
        System.out.println("and the user is "+userDAO.findById(3).getUser_fullName());
        System.out.println(1);*/
    }

    /*
    Test for removing values from the 'user' table
     */

    @org.junit.Test
    public void delete() throws Exception {
        User user = new User();
        user.setUser_fullName("Roman Smirnov");
        user.setUser_email("email2@mail.ru");
        user.setUser_password("Password2");
        user.setUser_role(1);
        userDAO.delete(user);
        System.out.println(2);

    }
    @org.junit.Test
    public void update() throws Exception {
        //Adding previous record
        //this.persist();
        User user = new User();
        user.setUser_fullName("Roman Smirnoff");
        user.setUser_email("email2@mail.ru");
        user.setUser_password("Pas22");
        user.setUser_role(1);
        user.setUser_fullName("Roman Smirnov");
        userDAO.update(user);
        System.out.println(3);
    }

    @org.junit.Test
    public void findById() throws Exception {
        System.out.println("and the user is "+userDAO.findById(1).getUser_fullName());
        System.out.println(4);
    }

    @org.junit.Test
    public void findAll() throws Exception {
        List<User> list=userDAO.findAll();
        for (User user:list) {
            System.out.println(user.toString());
            System.out.println(5);
        }

    }
    @org.junit.Test
    public void deleteAll() throws Exception {
        System.out.println("Result of deleting "+userDAO.deleteAll());
        System.out.println(6);
    }

}
