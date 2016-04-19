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

public class GWTSpring implements EntryPoint {

    private RegisterUserServiceAsync registerUserService = GWT.create(RegisterUserService.class);

    private Label labelFullName = new Label("Enter your full name");
    private TextBox userFullname = new TextBox();
    private Label labelUserPassword = new Label("Enter your password");
    private PasswordTextBox userPassword = new PasswordTextBox();
    private Label labelUserPasswordRepeat = new Label("Please repeat your password");
    private PasswordTextBox userPasswordRepeat = new PasswordTextBox();
    private Label labelUserEmail = new Label("Enter your email");
    private TextBox userEmail = new TextBox();
    private Label labelChooseRole = new Label("Choose your role");
    private RadioButton radio1 = new RadioButton("radioGroup", "Teacher");
    private RadioButton radio2 = new RadioButton("radioGroup", "Student");
    private VerticalPanel verticalPanel = new VerticalPanel();
    private Button button = new Button("Log in");


    public void onModuleLoad() {

        radio2.setValue(true);
        verticalPanel.add(labelFullName);
        verticalPanel.add(userFullname);
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


        final AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            public void onFailure(Throwable caught) {
                Window.alert(caught.getMessage());
            }

            public void onSuccess(Void aVoid) {
                Window.alert("Registration successfully completed");
            }
        };

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                if (userPassword.getValue().equals(userPasswordRepeat.getValue())){
                int role = radio1.getValue() ? 1 : 2;
                User user = new User(userEmail.getValue(), userPassword.getValue(), userFullname.getValue(), role);
                registerUserService.register(user, callback);}
                else Window.alert("Passwords do not match");
            }
        });


    }
}
