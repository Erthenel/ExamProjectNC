
package AccountRegistrationModule.client;

import AccountRegistrationModule.shared.model.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface RegisterUserServiceAsync {

    void register(User user, AsyncCallback<List<String>> async);

}

