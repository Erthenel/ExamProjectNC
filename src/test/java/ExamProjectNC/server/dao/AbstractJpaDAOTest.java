package ExamProjectNC.server.dao;

import ExamProjectNC.server.config.JPAConfig;
import ExamProjectNC.shared.dto.UserDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;


public class AbstractJpaDAOTest {
    @org.junit.Test
    public void persist() throws Exception {
        ApplicationContext ctx =new AnnotationConfigApplicationContext(JPAConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        UserDTO user = new UserDTO();
        user.setUser_fullName("Roman Smirnov");
        user.setUser_email("email2@mail.ru");
        user.setUser_password("Password2");
        user.setUser_role(1);
        userDAO.persist(user);
    }

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

}