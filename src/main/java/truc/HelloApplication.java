package truc;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);

        TextField username = new TextField("Username");
        username.setPadding(new Insets(10, 10, 10, 10));
        username.setPrefSize(50, 10);

        Button button = new Button("Sign in");
        button.setPadding(new Insets(10, 10, 10, 10));

        final TextField textField = new TextField();
        textField.setPrefSize(50, 10);
        textField.setManaged(false);
        textField.setVisible(false);
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        password.setPadding(new Insets(10, 10, 10, 10));

        CheckBox checkBox = new CheckBox("Show/Hide password");
        checkBox.setPadding(new Insets(10, 10, 10, 10));
        textField.managedProperty().bind(checkBox.selectedProperty());
        textField.visibleProperty().bind(checkBox.selectedProperty());
        textField.textProperty().bindBidirectional(password.textProperty());
        EventHandler eh = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (event.getSource() instanceof CheckBox) {
                    if (checkBox.isSelected()) {
                        grid.getChildren().clear();
                        grid.add(username, 0, 0);
                        grid.add(textField, 0, 1);
                        grid.add(button, 0, 2);
                        grid.add(checkBox, 0, 3);
                    } else {
                        grid.getChildren().clear();
                        grid.add(username, 0, 0);
                        grid.add(password, 0, 1);
                        grid.add(button, 0, 2);
                        grid.add(checkBox, 0, 3);
                    }
                }
            }
        };
        checkBox.setOnAction(eh);

        grid.add(username, 0, 0);
        grid.add(password, 0, 1);
        grid.add(button, 0, 2);
        grid.add(checkBox, 0, 3);

        Scene scene = new Scene(grid, 500, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}