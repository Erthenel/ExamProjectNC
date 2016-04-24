
package AccountRegistrationModule.server;

import AccountRegistrationModule.client.RegisterUserService;
import AccountRegistrationModule.server.dao.UserDAO;
import AccountRegistrationModule.shared.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("registerUserService")
public class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    private UserDAO userDAO;

    public List<String> register(User user) {

        UniversalFieldVerifier ufv = new UniversalFieldVerifier();
        if (ufv.verify(user).isEmpty()) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            UserDAO userDAO = context.getBean(UserDAO.class);
            userDAO.persist(user);
            context.close();
        }
        return ufv.verify(user);
    }
}