
package ExamProjectNC.client;

import ExamProjectNC.shared.model.User;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TestServiceAsync {
    void greet(String name, AsyncCallback<String> callback);
    void test(User user, AsyncCallback<Void> callback);
}

