package ExamProjectNC.server.services;

import ExamProjectNC.server.dao.UserDAO;
import ExamProjectNC.shared.model.User;
import ExamProjectNC.shared.services.SchedulerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchedulerServiceImplTest {
    @Autowired
    private SchedulerService schedulerService;
    @Test
    public void persistUserDAO() throws Exception {
        User user = new User();
        user.setUser_fullName("Roman Smirnov");
        user.setUser_email("email2@mail.ru");
        user.setUser_password("Password2");
        user.setUser_role(1);

        try{
            schedulerService.test();
        }catch (Exception e){
            System.out.println("Error!:(");
            e.printStackTrace();
        }
    }

}