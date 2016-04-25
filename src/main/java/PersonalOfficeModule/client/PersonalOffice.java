package PersonalOfficeModule.client;

import PersonalOfficeModule.client.Student_Items.ThirdItem;
import PersonalOfficeModule.client.Teacher_Items.FirstItem;
import PersonalOfficeModule.client.Teacher_Items.SecondItem;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class PersonalOffice implements EntryPoint {

    private TestServiceAsync testService = GWT.create(TestService.class);
    private AuthServiceAsync authService=GWT.create(AuthService.class);


    private MenuBar menuBar = new MenuBar();
    private HorizontalPanel horizontalPanel = new HorizontalPanel();
    private HorizontalPanel horizontalDynamicPanel = new HorizontalPanel();

    private VerticalPanel verticalPanel=new VerticalPanel();
    private Label userFullName=new Label();
    private Label userRole=new Label();
    private Label helloLabel = new Label("Hello! Press the button on menu");

    private Button buttonLogOut=new Button();

    //Dynamic components
    private FirstItem firstItem;
    private SecondItem secondItem;
    private ThirdItem thirdItem;

    public void onModuleLoad() {

        final Command firstCommand = new Command() {
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
        Command thirdCommand = new Command() {
            public void execute() {
                thirdItem = new ThirdItem();
                horizontalDynamicPanel.clear();
                horizontalDynamicPanel.add(thirdItem);
            }
        };

        //Teacher's items and components
        final MenuItem menuItem1=new MenuItem("First Item", firstCommand);
        final MenuItem menuItem2= new MenuItem("Second Item", secondCommand);

        //Student's items and components
        final MenuItem menuItem3=new MenuItem("Third Item", thirdCommand);


        authService.retrieveUserFullName(new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            public void onSuccess(String result) {
                userFullName.setText("Welcome, "+result+"!");

            }
        });

        authService.retrieveUserRole(new AsyncCallback<Integer>() {
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            public void onSuccess(Integer result) {
                if (result==1){
                    menuBar.addItem(menuItem1);
                    menuBar.addItem(menuItem2);
                    userRole.setText("User group: Teacher");
                } else if (result==2) {
                    menuBar.addItem(menuItem3);
                    userRole.setText("User group: Student");
                } else Window.alert("Error! You are not registered in the system");
            }
        });

        verticalPanel.add(userFullName);
        verticalPanel.add(userRole);
        buttonLogOut.setText("Log out");
        verticalPanel.add(buttonLogOut);

        horizontalPanel.add(menuBar);
        horizontalDynamicPanel.add(helloLabel);

        RootPanel.get().add(verticalPanel);
        RootPanel.get().add(horizontalPanel);
        RootPanel.get().add(horizontalDynamicPanel);


        buttonLogOut.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
             authService.logoutRedirect(new AsyncCallback<String>() {
                 public void onFailure(Throwable caught) {
                     Window.alert("log-out failure");
                 }

                 public void onSuccess(String result) {
                     Window.Location.assign("http://"+Window.Location.getHost()+result);
                 }
             });
            }
        });


    }
}