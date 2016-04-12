package main;

import java.util.List;

import ExamProjectNC.server.dao.*;
import ExamProjectNC.shared.dto.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;


/*
Тестовый класс для UserService
 */
public class TestUserDAOSH {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserDAO userDAO = new UserDAO();
        userDAO.setEntityManager((EntityManager) context.getBean("entityManagerFactory"));
        //тестируем методы здесь

        //Тест метода save

         /*  UserDTO user = new UserDTO();
        user.setUser_fullName("Stepan Ivanov");
        user.setUser_email("test2@ya.ru");
        user.setUser_password("test2Password");
        user.setUser_role(1);
        userDAO.save(user);
        System.out.println("UserDTO::"+user);
        UserDTO user_new = new UserDTO();
        user_new.setUser_fullName("Ivan Popov");
        user_new.setUser_email("email@mail.ru");
        user_new.setUser_password("Password");
        user_new.setUser_role(1);
        userDAO.save(user_new); */
        UserDTO user2 = new UserDTO();
        user2.setUser_fullName("Roman Smirnov");
        user2.setUser_email("email2@mail.ru");
        user2.setUser_password("Password2");
        user2.setUser_role(1);
        userDAO.persist(user2);
        userDAO.remove(user2);


       // List<UserDTO> list = userDAO.list();
/*
        for(UserDTO u : list){
            System.out.println("UserDTO List::"+u.getUser_fullName());
        }
*/
        context.close();
    }


}
