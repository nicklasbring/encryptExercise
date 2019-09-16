package Client2;

import Client.ClientListener;
import Client.MessageInfo;

import java.io.*;
import java.net.Socket;

public class Client2 implements Runnable {

    private Socket socket;
    private int port = 8000;
    private String serverIP = "localhost";
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private ClientListener clientListener;


    public Client2(ClientListener clientListener) {
        this.clientListener = clientListener;
    }

    //Run method that runs on a thread
    @Override
    public void run() {
        try {
            //Trying to connect to server
            Socket socket = new Socket(serverIP, port);

            //Initializing input and outputstreams to communicate with server
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());

            //Endless loop that updates the textArea in the gui with request from the server
            MessageInfo messageInfo;
            while (true){
                messageInfo = (MessageInfo) input.readObject();
                clientListener.updateTextArea(messageInfo.getAfsender() + ": " + messageInfo.getBesked());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendTekstChatServer(String afsender, String message) {
        try {
            output.writeObject(new MessageInfo(afsender, message));
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

