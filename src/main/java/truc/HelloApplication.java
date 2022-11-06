package truc;

import javafx.application.Application;
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
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {

        // Creates the gridpane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);

        // Creates the username field
        TextField username = new TextField("Username");
        username.setPadding(new Insets(10, 10, 10, 10));
        username.setPrefSize(50, 10);

        // Creates the Sign-in Button
        Button button = new Button("Sign in");
        button.setPadding(new Insets(10, 10, 10, 10));

        // Creates the (visible) password field
        final TextField textField = new TextField();
        textField.setPrefSize(50, 10);
        textField.setManaged(false);
        textField.setVisible(false);

        // Creates the (invisible) password field
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        password.setPadding(new Insets(10, 10, 10, 10));

        // Creates the checkbox to set visible or invisible password
        CheckBox checkBox = new CheckBox("Show/Hide password");
        checkBox.setPadding(new Insets(10, 10, 10, 10));

        // Binds the two textfield for the password (invisible and visible)
        textField.managedProperty().bind(checkBox.selectedProperty());
        textField.visibleProperty().bind(checkBox.selectedProperty());
        textField.textProperty().bindBidirectional(password.textProperty());

        // Creates the event for when the checkbox is checked
        EventHandler<ActionEvent> eh = event -> {
            if (event.getSource() instanceof CheckBox) {
                if (checkBox.isSelected()) { // If it is checked, clear then add the visible password field
                    grid.getChildren().clear();
                    grid.add(username, 0, 0);
                    grid.add(textField, 0, 1);
                    grid.add(button, 0, 2);
                    grid.add(checkBox, 0, 3);
                } else { // If it is not checked, clear then add the invisible password field
                    grid.getChildren().clear();
                    grid.add(username, 0, 0);
                    grid.add(password, 0, 1);
                    grid.add(button, 0, 2);
                    grid.add(checkBox, 0, 3);
                }
            }
        };

        // Sets the event for the checkbox
        checkBox.setOnAction(eh);


        // Adds the elements to the grid
        grid.add(username, 0, 0);
        grid.add(password, 0, 1);
        grid.add(button, 0, 2);
        grid.add(checkBox, 0, 3);

        // Creates the scene et tout
        Scene scene = new Scene(grid, 500, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}