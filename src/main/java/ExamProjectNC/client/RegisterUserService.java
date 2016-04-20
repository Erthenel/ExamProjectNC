
package ExamProjectNC.client;

import ExamProjectNC.shared.model.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("springGwtServices/registerUserService")
public interface RegisterUserService extends RemoteService {
    List<String> register(User user);
}
