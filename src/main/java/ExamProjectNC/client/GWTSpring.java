package ExamProjectNC.client;

import ExamProjectNC.shared.model.User;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.cellview.client.TextHeader;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;

public class GWTSpring implements EntryPoint {

    private RegisterUserServiceAsync registerUserService = GWT.create(RegisterUserService.class);

    private Label labelName = new Label("Enter your Name");
    private Label labelSurname = new Label("Enter your Surname");
    private TextBox userName = new TextBox();
    private TextBox userSurname = new TextBox();
    private Label labelUserPassword = new Label("Enter your Password");
    private PasswordTextBox userPassword = new PasswordTextBox();
    private Label labelUserPasswordRepeat = new Label("Please repeat your Password");
    private PasswordTextBox userPasswordRepeat = new PasswordTextBox();
    private Label labelUserEmail = new Label("Enter your Email");
    private TextBox userEmail = new TextBox();
    private Label labelChooseRole = new Label("Choose your Role");
    private RadioButton radio1 = new RadioButton("radioGroup", "Teacher");
    private RadioButton radio2 = new RadioButton("radioGroup", "Student");
    private VerticalPanel verticalPanel = new VerticalPanel();
    private Button button = new Button("Sign me up!");
    private String specialEvents= new String();

    public void onModuleLoad() {

        radio2.setValue(true);
        verticalPanel.add(labelName);
        verticalPanel.add(userName);
        verticalPanel.add(labelSurname);
        verticalPanel.add(userSurname);
        verticalPanel.add(labelUserPassword);
        verticalPanel.add(userPassword);
        verticalPanel.add(labelUserPasswordRepeat);
        verticalPanel.add(userPasswordRepeat);
        verticalPanel.add(labelUserEmail);
        verticalPanel.add(userEmail);
        verticalPanel.add(labelChooseRole);
        verticalPanel.add(radio1);
        verticalPanel.add(radio2);
        verticalPanel.add(button);
        verticalPanel.addStyleName("form");
        RootPanel.get().add(verticalPanel);


        final AsyncCallback<List<String>> callback = new AsyncCallback<List<String>>() {
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            public void onSuccess(List<String> list) {
                if (list.isEmpty()) {
                    Window.alert("Registration successfully completed");
                    Window.Location.replace("\\GWTSpring\\happyRegistry");
                } else {
                    String gatherAns = new String();
                    gatherAns+=specialEvents;
                    specialEvents=new String();
                    for (String ans:list) {
                        gatherAns+="\n"+ans;
                    }
                    Window.alert("You have following mistakes:"+gatherAns);
                }
            }
        };

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                if (!userPassword.getValue().equals(userPasswordRepeat.getValue()))
                specialEvents+="\nError. Passwords do not match.";

                int role = radio1.getValue() ? 1 : 2;
                registerUserService.register(
                        new User(userEmail.getValue(), userPassword.getValue(), userName.getValue()+" "+userSurname.getValue(), role),
                        callback);
            }
        });


    }
}
