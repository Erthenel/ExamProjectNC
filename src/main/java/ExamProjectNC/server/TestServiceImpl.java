
package ExamProjectNC.server;

import ExamProjectNC.client.TestService;
import ExamProjectNC.server.dao.UserDAO;
import ExamProjectNC.shared.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private UserDAO userDAO;

    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    public void test(User user) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserDAO userDAO = context.getBean(UserDAO.class);
        userDAO.persist(user);
        System.out.println(userDAO.findById(1));
        context.close();

    }
}