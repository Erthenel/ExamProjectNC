package PersonalOfficeModule.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

class FirstItem extends Composite implements ClickHandler {
    private Label label = new Label("First Item pressed");
    private TextBox textBox = new TextBox();
    private Button button = new Button("Press Me!");

    FirstItem() {
        VerticalPanel panel = new VerticalPanel();
        panel.add(label);
        panel.add(textBox);
        panel.add(button);
        initWidget(panel);
        button.addClickHandler(this);
    }

    public void onClick(ClickEvent clickEvent) {
        Object sender = clickEvent.getSource();
        if (sender == button) {
            Window.alert("Вы ввели: "+textBox.getText());
        }
    }
}
