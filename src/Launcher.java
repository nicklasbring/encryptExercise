import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
            //Starter min server gui
            Parent server = FXMLLoader.load(getClass().getClassLoader().getResource("Server/ServerFxml.fxml"));
            primaryStage.setTitle("Server");
            primaryStage.setScene(new Scene(server, 600, 400));
            primaryStage.setX(900);
            primaryStage.setY(300);
            primaryStage.show();

            //Starter min første klient
            Stage secondaryStage = new Stage();
            Parent client = FXMLLoader.load(getClass().getClassLoader().getResource("Client/ClientFxml.fxml"));
            secondaryStage.setTitle("Client");
            secondaryStage.setScene(new Scene(client, 600, 400));
            secondaryStage.setX(0);
            secondaryStage.setY(300);
            secondaryStage.show();

            //Starter klient nummer 2 med 10 milisekunders dalay for at forhindre connectionproblemer til serveren
            TimeUnit.MILLISECONDS.sleep(10);
            Stage thirdStage = new Stage();
            Parent client2 = FXMLLoader.load(getClass().getClassLoader().getResource("Client2/Client2Fxml.fxml"));
            thirdStage.setTitle("Client2");
            thirdStage.setScene(new Scene(client2, 600, 400));
            thirdStage.setX(0);
            thirdStage.setY(300);
            thirdStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
