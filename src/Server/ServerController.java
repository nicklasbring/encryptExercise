package Server;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class ServerController implements ServerListener {

    @FXML
    TextArea serverInformation;

    Server server;

    public void initialize() {
        server = new Server(this);
        Thread threadServer = new Thread(server);
        threadServer.start();
    }

    @Override
    public void updateTextArea(String message) {
                serverInformation.appendText(message + "\n");
    }
}
