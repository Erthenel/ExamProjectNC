package ExamProjectNC.server.services;

import ExamProjectNC.client.TestService;
import ExamProjectNC.server.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {

    @Autowired
    UserDAO userDAO;

    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
