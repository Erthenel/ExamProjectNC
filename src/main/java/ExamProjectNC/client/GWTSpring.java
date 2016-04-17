package ExamProjectNC.client;

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

public class GWTSpring implements EntryPoint {

    private RegisterUserServiceAsync registerUserService = GWT.create(RegisterUserService.class);

    private TextBox userFullname = new TextBox();
    private PasswordTextBox userPassword = new PasswordTextBox();
    private TextBox userEmail = new TextBox();

    private RadioButton radio1 = new RadioButton("radioGroup", "Teacher");
    private RadioButton radio2 = new RadioButton("radioGroup", "Student");
    private VerticalPanel verticalPanel = new VerticalPanel();
    private Button button = new Button("Log in");


    public void onModuleLoad() {
        verticalPanel.add(userFullname);
        verticalPanel.add(userPassword);
        verticalPanel.add(userEmail);
        verticalPanel.add(radio1);
        verticalPanel.add(radio2);
        verticalPanel.add(button);
        RootPanel.get().add(verticalPanel);


        final AsyncCallback<Void> callback = new AsyncCallback<Void>() {
            // выводит в поле имени сообщение об ошибке
            public void onFailure(Throwable caught) {
                userFullname.setText(caught.getMessage());
            }

            public void onSuccess(Void aVoid) {
                Window.alert("Вы успешно прошли регистрацию");
            }
        };

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                //int role = (radio1.isSelected);
                User user = new User(userEmail.getValue(), userPassword.getValue(), userFullname.getValue(), 1);
                registerUserService.register(user, callback);
            }
        });


    }
}
