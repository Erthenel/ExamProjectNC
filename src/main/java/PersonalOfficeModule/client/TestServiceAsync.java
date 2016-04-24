package PersonalOfficeModule.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TestServiceAsync {
    void greet(String name, AsyncCallback<String> callback);
}