package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;

public class Server implements Runnable{

    private ServerSocket server;
    private Socket socket;
    private int port = 8000;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private ServerListener listener;

    static Vector<ClientHandler> clients;

    public Server(ServerListener listener) {
        clients = new Vector<>();
        this.listener = listener;
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(port);

            Date date = new Date();
            listener.updateTextArea("Serveren er startet op: " + date.toString() + "\n");

            while (true) {
                socket = server.accept();
                listener.updateTextArea("Klient tilsluttet fra: " + "(" +  socket.getRemoteSocketAddress() + ")\n");

                //Data input og output for at skrive til klien og modtage data fra klienten
                output = new ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());

                ClientHandler client = new ClientHandler(socket, output, input, listener);
                Thread thread = new Thread(client);

                clients.add(client);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
