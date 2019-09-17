package Client2;

import Client.ClientListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Client2Controller implements ClientListener {


    @FXML
    TextField chatname, password;

    @FXML
    TextArea messageBox, chatroom;

    Client2 client;

    public void initialize() {
        client = new Client2(this);
        Thread threadClient = new Thread(client);
        threadClient.start();

        password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                client.setPassword(newValue);
            }
        });
    }

    public void sendTekst(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            client.sendTekstChatServer(password.getText(), chatname.getText(), messageBox.getText());
            messageBox.clear();
        }
    }

    @Override
    public void updateTextArea(String message) {
        chatroom.appendText(message + "\n");
    }
}
