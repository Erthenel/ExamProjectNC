package PersonalOfficeModule.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/authenticationService")
public interface AuthService extends RemoteService {
    String retrieveUserEmail();
    String retrieveUserFullName();
    int retrieveUserRole();
    String logoutRedirect();
}