
package ExamProjectNC.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/testService")
public interface TestService extends RemoteService {
    String greet(String name);
}
