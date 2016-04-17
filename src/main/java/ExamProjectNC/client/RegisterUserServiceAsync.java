
package ExamProjectNC.client;

import ExamProjectNC.shared.model.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegisterUserServiceAsync {
    void register(User user, AsyncCallback<Void> callback);
}

