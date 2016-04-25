package PersonalOfficeModule.server;

import AccountRegistrationModule.server.dao.UserDAO;
import AccountRegistrationModule.shared.model.User;
import PersonalOfficeModule.client.AuthService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

@Service("authenticationService")
public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {
    private static final long serialVersionUID = 8394711806095967642L;

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    UserDAO userDAO=context.getBean(UserDAO.class);

    public String retrieveUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        if (authentication == null) {
            return "Not logged in!";
        } else {
            return (String) authentication.getPrincipal();
        }
    }

    public String retrieveUserFullName() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        if (authentication == null) {
            return "Not logged in!";
        } else {
            User user = userDAO.findByFieldName("user_email",(String) authentication.getPrincipal());
            return  user.getUser_fullName();
        }
    }

    public int retrieveUserRole(){
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (authentication == null) {
            System.out.println("Not logged in");
            return -1;
        } else {
            User user = userDAO.findByFieldName("user_email",(String) authentication.getPrincipal());
            return user.getUser_role();
        }
    }
    public String logoutRedirect () {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            SecurityContextHolder.clearContext();
        }
        return "/login?logout";
    }

}