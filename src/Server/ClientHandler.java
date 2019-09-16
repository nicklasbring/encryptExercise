package Server;

import Client.MessageInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerListener listener;

    public ClientHandler(Socket socket, ObjectOutputStream output, ObjectInputStream input, ServerListener listener) {
        this.socket = socket;
        this.output = output;
        this.input = input;
        this.listener = listener;
    }

    @Override
    public void run() {

        MessageInfo messageInfo;

        while (true){
            try {
                messageInfo = (MessageInfo) input.readObject();

                listener.updateTextArea("Der blev skrevet en besked i chatrummet fra: "
                        + socket.getRemoteSocketAddress() + "\n");

                for (ClientHandler client : Server.clients){
                    client.getOutput().writeObject(messageInfo);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }
}
