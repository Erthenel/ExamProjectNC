
package ExamProjectNC.server;

import ExamProjectNC.client.TestService;
import org.springframework.stereotype.Service;


@Service("testService")
public class TestServiceImpl implements TestService {


    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}