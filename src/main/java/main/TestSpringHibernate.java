package main;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDAO;
import model.*;

public class TestSpringHibernate {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserDAO userDAO = context.getBean(UserDAO.class);

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
        //close resources
        context.close();
    }


}
