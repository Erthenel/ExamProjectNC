package ExamProjectNC.client;

import ExamProjectNC.shared.model.User;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

public interface SchedulerServiceAsync {
    void test(User user, AsyncCallback<Void> async);
}
