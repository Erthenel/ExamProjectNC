package PersonalOfficeModule.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthServiceAsync {
    void retrieveUserEmail(AsyncCallback<String> async);

    void retrieveUserFullName(AsyncCallback<String> async);

    void retrieveUserRole(AsyncCallback<Integer> async);

    void logoutRedirect(AsyncCallback<String> async);
}
