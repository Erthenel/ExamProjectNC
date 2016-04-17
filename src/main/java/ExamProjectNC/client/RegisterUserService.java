
package ExamProjectNC.client;

import ExamProjectNC.shared.model.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/registerUserService")
public interface RegisterUserService extends RemoteService {
    void register(User user);
}
