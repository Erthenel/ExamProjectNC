package PersonalOfficeModule.server;


import PersonalOfficeModule.client.TestService;

import AccountRegistrationModule.server.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("greetingService")
public class TestServiceImpl implements TestService {

   @Autowired
    UserDAO userDAO;

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}