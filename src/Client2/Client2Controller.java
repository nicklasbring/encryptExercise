package Client2;

import Client.ClientListener;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Client2Controller implements ClientListener {

    @FXML
    TextField chatname;

    @FXML
    TextArea messageBox;

    public TextArea chatroom;

    Client2 client;

    public void initialize() {
        client = new Client2(this);
        Thread threadClient = new Thread(client);
        threadClient.start();
    }

    public void sendTekst(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            client.sendTekstChatServer(chatname.getText(), messageBox.getText());
            messageBox.clear();
        }
    }

    @Override
    public void updateTextArea(String message) {
        chatroom.appendText(message + "\n");
    }
}
