package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements Runnable {

    private Socket socket;
    private int port = 8000;
    private String serverIP = "localhost";
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private ClientListener clientListener;
    private Cipher cipher;
    private String password;


    Client(ClientListener clientListener) {
        this.clientListener = clientListener;
    }

    //Run method that runs on a thread
    @Override
    public void run() {
        try {
            //Trying to connect to server
            socket = new Socket(serverIP, port);



            //Initializing input and outputstreams to communicate with server
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());

            //Endless loop that updates the textArea in the gui with request from the server
            MessageInfo messageInfo;


            while (true){
                messageInfo = (MessageInfo) input.readObject();
                cipher = new Cipher(messageInfo.getKode());
                messageInfo.setBesked(cipher.decrypt(messageInfo.getBesked()));
                clientListener.updateTextArea(messageInfo.getAfsender() + ": " + messageInfo.getBesked());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendTekstChatServer(String password, String afsender, String message) {
        try {
            String encryptedMessage = cipher.encrypt(message);
            output.writeObject(new MessageInfo(password, afsender, encryptedMessage));
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

