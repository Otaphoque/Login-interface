package truc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();

        // I swear, if I have to deal with Location is not set one more time, I'm going to scream (╯°□°）╯︵ ┻━┻
        loader.setLocation(new URL("file:/Users/constance/IdeaProjects/Login/src/main/resources/ui/login.fxml"));
        Pane content = loader.load();

        // Creates the scene et tout
        Scene scene = new Scene(content, 500, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}