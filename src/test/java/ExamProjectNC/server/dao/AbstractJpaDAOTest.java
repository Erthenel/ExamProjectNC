package ExamProjectNC.server.dao;

import ExamProjectNC.shared.model.*;
import org.hibernate.annotations.SourceType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class AbstractJpaDAOTest {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    UserDAO userDAO = context.getBean(UserDAO.class);
    /*
    Test for adding values in a 'user' table
     */
    @org.junit.Test
    public void persist() throws Exception {
        User user = new User();
        user.setUser_fullName("Roman Smirnov");
        user.setUser_email("email2@mail.ru");
        user.setUser_password("Password2");
        user.setUser_role(1);
        userDAO.persist(user);
        System.out.println("and the user is "+userDAO.findById(3).getUser_fullName());
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
    }

    @org.junit.Test
    public void findById() throws Exception {
        System.out.println("and the user is "+userDAO.findById(1).getUser_fullName());
    }

    @org.junit.Test
    public void findAll() throws Exception {
        List<User> list=userDAO.findAll();
        for (User user:list) {
            System.out.println(user.toString());
        }

    }
    @org.junit.Test
    public void deleteAll() throws Exception {
        System.out.println("Result of deleting "+userDAO.deleteAll());
    }

}