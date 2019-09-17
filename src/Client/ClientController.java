package Client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ClientController implements ClientListener {

    @FXML
    TextField chatname, password;

    @FXML
    TextArea messageBox;

    public TextArea chatroom;

    private Client client;

    public void initialize() {
        client = new Client(this);
        Thread threadClient = new Thread(client);
        threadClient.start();
    }

    public void sendTekst(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            client.sendTekstChatServer(password.getText(), chatname.getText(), messageBox.getText());
            messageBox.clear();
        }
    }

    @Override
    public void updateTextArea(String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                chatroom.appendText(message + "\n");
            }
        });
    }
}
