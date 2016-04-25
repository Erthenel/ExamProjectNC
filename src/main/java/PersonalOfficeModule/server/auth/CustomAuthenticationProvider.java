package PersonalOfficeModule.server.auth;

import java.util.HashMap;
import java.util.Map;

import AccountRegistrationModule.server.dao.UserDAO;
import AccountRegistrationModule.shared.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomAuthenticationProvider implements AuthenticationProvider {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    UserDAO userDAO=context.getBean(UserDAO.class);

    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String user_email = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();


        User user=userDAO.findByFieldName("user_email",user_email);




        if (user!=null) {
            if (user.getUser_email() == null)
                throw new UsernameNotFoundException("User with this email is not found");
            String storePass = user.getUser_password();
            if (!storePass.equals(password))
                throw new BadCredentialsException("invalid password");
            Authentication customAuthentication = new CustomUserAuthentication(
                    "ROLE_USER", authentication);
            customAuthentication.setAuthenticated(true);
            return customAuthentication;
        } else {
            throw new UsernameNotFoundException("Your email or password is wrong!");
        }
    }

    public boolean supports(Class<? extends Object> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
