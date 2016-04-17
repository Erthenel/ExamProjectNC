package ExamProjectNC.server;


import ExamProjectNC.client.SchedulerService;
import ExamProjectNC.shared.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import ExamProjectNC.server.dao.*;

@Service("schedulerService")
public class SchedulerServiceImpl implements SchedulerService{
    @Autowired
    UserDAO userDAO;

    @Autowired
    GroupDAO groupDAO;

    @Autowired
    ExamDAO examDAO;

    @Autowired
    ExaminedDAO examinedDAO;

    public void test() {
        System.out.println("hello there!");
    }

    public void test(User user) {
        System.out.println("hello there!22222");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserDAO userDAO = context.getBean(UserDAO.class);
        userDAO.persist(user);
        context.close();

    }
}
