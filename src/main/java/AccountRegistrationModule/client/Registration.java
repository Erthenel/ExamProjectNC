package AccountRegistrationModule.client;

import AccountRegistrationModule.shared.model.User;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Registration implements EntryPoint {

    private Set<String> formField=new HashSet<String>();

    private RegisterUserServiceAsync registerUserService = GWT.create(RegisterUserService.class);
    private PopupPanel popupPanel = new PopupPanel();
    private Label titleLabel=new Label("Registration");
    private Label labelName = new Label("Enter your Name");
    private Label labelSurname = new Label("Enter your Surname");
    private TextBox userName = new TextBox();
    private TextBox userSurname = new TextBox();
    private Label labelUserPassword = new Label("Enter your Password");
    private PasswordTextBox userPassword = new PasswordTextBox();
    private Label labelUserPasswordRepeat = new Label("Confirm your Password");
    private PasswordTextBox userPasswordRepeat = new PasswordTextBox();
    private Label labelUserEmail = new Label("Enter your Email");
    private TextBox userEmail = new TextBox();
    private Label labelChooseRole = new Label("Choose your Role");
    private RadioButton radio1 = new RadioButton("radioGroup", "Teacher");
    private RadioButton radio2 = new RadioButton("radioGroup", "Student");
    private VerticalPanel verticalPanel = new VerticalPanel();
    private Button button = new Button("Submit");
    private Button buttonDuplicate = new Button("Submit");
    private String specialEvents= new String();


    private void initWidgets(){
        //INITIALIZATION-------------------------------------------------------------->>>>>>>>
        popupPanel.hide();
        popupPanel.center();
        popupPanel.setAutoHideEnabled(true);
        popupPanel.setAnimationEnabled(true);
        popupPanel.setTitle("Attention!");

        verticalPanel.setStyleName("form",true);
        titleLabel.setStyleName("form-title",true);
        verticalPanel.add(titleLabel);
        radio2.setValue(true);

        verticalPanel.add(labelName);
        labelName.setStyleName("form-label",true);
        verticalPanel.add(userName);
        userName.setStyleName("form-control",true);
        userName.getElement().setPropertyString("placeholder","Name");
        verticalPanel.add(labelSurname);
        labelSurname.setStyleName("form-label",true);
        verticalPanel.add(userSurname);
        userSurname.setStyleName("form-control",true);
        userSurname.getElement().setPropertyString("placeholder","Surname");

        verticalPanel.add(labelUserPassword);
        labelUserPassword.setStyleName("form-label",true);
        verticalPanel.add(userPassword);
        userPassword.setStyleName("form-control",true);
        userPassword.getElement().setPropertyString("placeholder","Password");

        verticalPanel.add(labelUserPasswordRepeat);
        labelUserPasswordRepeat.setStyleName("form-label",true);
        verticalPanel.add(userPasswordRepeat);
        userPasswordRepeat.setStyleName("form-control",true);
        userPasswordRepeat.getElement().setPropertyString("placeholder","Confirm Password");
        verticalPanel.add(labelUserEmail);
        labelUserEmail.setStyleName("form-label",true);
        verticalPanel.add(userEmail);
        userEmail.setStyleName("form-control",true);
        userEmail.getElement().setPropertyString("placeholder","Email");

        verticalPanel.add(labelChooseRole);
        labelChooseRole.setStyleName("form-label",true);
        verticalPanel.add(radio1);
        radio1.setStyleName("form-label",true);

        labelChooseRole.setStyleName("form-label",true);
        verticalPanel.add(radio2);
        radio2.setStyleName("form-label",true);

        radio2.setPixelSize(100,100);
        radio2.getElement();
        button.setStyleName("btn");
        button.setStyleName("disabled", true);

        buttonDuplicate.setStyleName("btn2");

        verticalPanel.add(button);
        verticalPanel.add(buttonDuplicate);
        verticalPanel.addStyleName("form");

        RootPanel.get().add(verticalPanel);

    }

    private void initHandlers(){
        //HANDLERS------------------------------------------------------------------------>>>>>>>>>>>>

        popupPanel.addCloseHandler(new CloseHandler<PopupPanel>() {
            public void onClose(CloseEvent<PopupPanel> event) {
                popupPanel.hide();
                popupPanel.clear();
            }
        });

        userName.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {

                if (!userName.getValue().trim().matches("[A-Za-zА-Яа-я]{2,20}")) {
                    popupPanel.show();
                    popupPanel.add(new Label("Name consists of restricted symbols!"));
                    userName.removeStyleName("light_green");
                    userName.setStyleName("light_yellow",true);
                    openSubmitButton("userName",false);
                } else {
                    userName.removeStyleName("light_yellow");
                    userName.setStyleName("light_green",true);
                    openSubmitButton("userName",true);
                }
            }
        });

        userSurname.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                if (!userSurname.getValue().trim().matches("[A-Za-zА-Яа-я]{2,20}")) {
                    popupPanel.show();
                    popupPanel.add(new Label("Surname consists of restricted symbols!"));
                    userSurname.removeStyleName("light_green");
                    userSurname.setStyleName("light_yellow",true);
                    openSubmitButton("userSurname",false);
                } else {
                    userSurname.removeStyleName("light_yellow");
                    userSurname.setStyleName("light_green",true);
                    openSubmitButton("userSurname",true);
                }
            }
        });
        userPassword.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                if ((userPassword.getValue().length()>30)) {
                    popupPanel.show();
                    popupPanel.add(new Label("Password's max length is 30 symbols only!"));
                    userPassword.removeStyleName("light_green");
                    userPassword.setStyleName("light_yellow",true);
                    openSubmitButton("userPassword",false);
                } else if (!(userPassword.getValue().matches(".*[A-Z].*")&((userPassword.getValue().matches(".*[a-z].*"))&((userPassword.getValue().matches(".*[0-9].*")))))) {
                    popupPanel.show();
                    popupPanel.add(new Label("Your password must contain at least 1 uppercase, 1 lowercase letter and 1 digit!"));
                    userPassword.removeStyleName("light_green");
                    userPassword.setStyleName("light_yellow",true);
                    openSubmitButton("userPassword",false);
                } else if (userPassword.getValue().length()<5){
                    popupPanel.show();
                    popupPanel.add(new Label("At least 5 symbols are required in a password!"));
                    userPassword.removeStyleName("light_green");
                    userPassword.setStyleName("light_yellow",true);
                    openSubmitButton("userPassword",false);
                } else {
                    userPassword.removeStyleName("light_yellow");
                    userPassword.setStyleName("light_green",true);
                    openSubmitButton("userPassword",true);
                }
            }
        });
        userPasswordRepeat.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                if (!userPassword.getValue().equals(userPasswordRepeat.getValue())){
                    popupPanel.show();
                    popupPanel.add(new Label("Passwords do not match. Confirm it once more."));
                    userPasswordRepeat.removeStyleName("light_green");
                    userPasswordRepeat.setStyleName("light_yellow",true);
                    openSubmitButton("userPasswordRepeat",false);
                } else {
                    userPasswordRepeat.removeStyleName("light_yellow");
                    userPasswordRepeat.setStyleName("light_green",true);
                    openSubmitButton("userPasswordRepeat",true);
                }

            }
        });
        userEmail.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                if (!userEmail.getValue().matches("^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(?:aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$")) {
                    popupPanel.show();
                    popupPanel.add(new Label("Your email is incorrect. Check it once more."));
                    userEmail.removeStyleName("light_green");
                    userEmail.setStyleName("light_yellow",true);
                    openSubmitButton("userEmail",false);
                } else {
                    userEmail.removeStyleName("light_yellow");
                    userEmail.setStyleName("light_green",true);
                    openSubmitButton("userEmail",true);
                }
            }
        });

        //Async callbacks------------------------------------------------------------------------>>>>>>>>>>>>
        final AsyncCallback<List<String>> callback = new AsyncCallback<List<String>>() {
            public void onFailure(Throwable caught) {
               // Window.alert(caught.getMessage());
              //  popupPanel.show();
                //popupPanel.add(new Label(caught.getMessage()));
            }

            public void onSuccess(List<String> list) {
                if (list.isEmpty()) {

                    popupPanel.show();
                    popupPanel.setStyleName("popUpBlock");
                    popupPanel.add(new Label("Registration successfully completed!"));

                } else {
                    String gatherAns = new String();
                    gatherAns+=specialEvents;
                    specialEvents=new String();
                    for (String ans:list) {
                        gatherAns+="\n"+ans;
                    }
                    popupPanel.show();
                    popupPanel.setStyleName("popUpBlock");
                    popupPanel.add(new Label("You have following mistakes:\n"+gatherAns));
                    //добавить кнопку
                    // Window.alert("You have following mistakes:"+gatherAns);
                }
            }
        };

        //MAIN SUBMIT REGISTRATION BUTTON
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent clickEvent) {
                if (!userPassword.getValue().equals(userPasswordRepeat.getValue()))
                    specialEvents+="\n Passwords do not match. Confirm it once more.";

                int role = radio1.getValue() ? 1 : 2;
                registerUserService.register(
                        new User(userEmail.getValue(), userPassword.getValue(), userName.getValue()+" "+userSurname.getValue(), role),
                        callback);
                button.setStyleName("btn");
            }
        });

    }

    private void openSubmitButton(String fieldName,boolean status){
        if (status==true) formField.add(fieldName);
        else formField.remove(fieldName);

        if (formField.toArray().length==5) {
            button.removeStyleName("disabled");
            buttonDuplicate.setStyleName("disabled", true);
        }
        else {
            button.setStyleName("disabled",true);
            buttonDuplicate.removeStyleName("disabled");
        }
    }

    public void onModuleLoad() {
        initWidgets();
        initHandlers();

    }
}
