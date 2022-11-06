package truc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class Controller {

    // All the fxml elements
    @FXML public Pane pane;
    @FXML public Label label;
    @FXML public TextField username;
    @FXML public PasswordField password;
    @FXML public TextField textfield;
    @FXML public CheckBox checkbox;
    @FXML public Button button;

    // Dummy controller for the FXML file
    public Controller() {
    }

    // The FXML file will call this method (after the controller), it will set the right password fields
    @FXML public void initialize() {
        checkbox.setOnAction(event -> {
            if (checkbox.isSelected()) {
                password.setVisible(false);
                textfield.setVisible(true);
                textfield.setText(password.getText());
            } else {
                password.setVisible(true);
                textfield.setVisible(false);
                password.setText(textfield.getText());
            }
        });
    }

    // When the checkbox is clicked, the event will be triggered
    @FXML public void handleCheckbox() {
        checkbox.setOnAction(eh);
    }

    // Event Handler description
    EventHandler<ActionEvent> eh = new EventHandler<>() {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() instanceof CheckBox) {
                if (checkbox.isSelected()) {
                    buildTheBox(textfield);
                } else {
                    buildTheBox(password);
                }
            }
        }
    };

    // Clears the pane and adds the right password field
    private void buildTheBox(TextField textfield) {
        pane.getChildren().clear();
        pane.getChildren().add(label);
        username.setLayoutX(118);
        username.setLayoutY(42);
        pane.getChildren().add(username);
        username.setLayoutX(170);
        username.setLayoutY(103);
        pane.getChildren().add(textfield);
        textfield.setLayoutX(170);
        textfield.setLayoutY(148);
        pane.getChildren().add(checkbox);
        checkbox.setLayoutX(195);
        checkbox.setLayoutY(189);
        pane.getChildren().add(button);
        button.setLayoutX(223);
        button.setLayoutY(221);
    }
}
