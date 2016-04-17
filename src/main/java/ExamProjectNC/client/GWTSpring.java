package ExamProjectNC.client;

import ExamProjectNC.server.dao.UserDAO;
import ExamProjectNC.shared.model.User;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GWTSpring implements EntryPoint {

    private TestServiceAsync testService = GWT.create(TestService.class);

    private TextBox nameTextBox = new TextBox();
    private Label greetingLabel = new Label("Hello, GWT!");

    private TextBox userFullname = new TextBox();
    private PasswordTextBox userPassword = new PasswordTextBox();
    private TextBox userEmail = new TextBox();

    private RadioButton radio1 = new RadioButton("radioGroup", "Преподаватель");
    private RadioButton radio2 = new RadioButton("radioGroup", "Студент");
    private VerticalPanel verticalPanel = new VerticalPanel();
    private Button button = new Button();

    public void onModuleLoad() {
        RootPanel.get().add(nameTextBox);
        RootPanel.get().add(greetingLabel);
        verticalPanel.add(userFullname);
        verticalPanel.add(userPassword);
        verticalPanel.add(userEmail);
        verticalPanel.add(radio1);
        verticalPanel.add(radio2);
        verticalPanel.add(button);
        RootPanel.get().add(verticalPanel);


        final AsyncCallback<String> callback = new AsyncCallback<String>() {
            public void onFailure(Throwable caught) {
                greetingLabel.setText("ERROR!");
            }

            public void onSuccess(String result) {
                greetingLabel.setText(result);

            }
        };

        final AsyncCallback<Void> callback1 = new AsyncCallback<Void>() {
            public void onFailure(Throwable caught) {
                userFullname.setText(caught.getMessage());
            }

            public void onSuccess(Void aVoid) {
                Window.alert("Аррррррррррррррррррррр");
                userFullname.setText("success!");
            }
        };

        nameTextBox.addKeyUpHandler(new KeyUpHandler() {
            public void onKeyUp(KeyUpEvent keyUpEvent) {
                testService.greet(nameTextBox.getText(), callback);
            }
        });

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                greetingLabel.setText("hey");
                User user = new User(userEmail.getValue(), userPassword.getValue(), userFullname.getValue(), 1);
                testService.test(user, callback1);
            }
        });



    }
}
