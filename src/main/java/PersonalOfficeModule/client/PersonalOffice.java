package PersonalOfficeModule.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class PersonalOffice implements EntryPoint {

    private TestServiceAsync testService = GWT.create(TestService.class);


    private MenuBar menuBar = new MenuBar();
    private HorizontalPanel horizontalPanel = new HorizontalPanel();
    private HorizontalPanel horizontalDynamicPanel = new HorizontalPanel();
    private Label helloLabel = new Label("Hello! Press the button on menu");

    //Dynamic components
    private FirstItem firstItem;
    private SecondItem secondItem;

    public void onModuleLoad() {
        Command firstCommand = new Command() {
            public void execute() {
                firstItem = new FirstItem();
                horizontalDynamicPanel.clear();
                horizontalDynamicPanel.add(firstItem);
            }
        };
        Command secondCommand = new Command() {
            public void execute() {
                secondItem = new SecondItem();
                horizontalDynamicPanel.clear();
                horizontalDynamicPanel.add(secondItem);
            }
        };
        menuBar.addItem("First Item", firstCommand);
        menuBar.addItem("Second Item", secondCommand);
        horizontalPanel.add(menuBar);
        horizontalDynamicPanel.add(helloLabel);
        RootPanel.get().add(horizontalPanel);
        RootPanel.get().add(horizontalDynamicPanel);



        final AsyncCallback<String> callback = new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            public void onSuccess(String result) {
            }
        };

    }
}