package truc;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;


public class Controller {

    public Scene scene;

    // All the fxml elements
    @FXML
    public Pane pane;
    @FXML
    public Label label;
    @FXML
    public TextField username;
    @FXML
    public PasswordField password;
    @FXML
    public TextField textfield;
    @FXML
    public CheckBox checkbox;
    @FXML
    public Button button;

    public final String login = "constance_prevot";
    public final String code = "Fall_2023!";

    // Dummy controller for the FXML file
    public Controller() {
    }

    // The FXML file will call this method when being created (after the constructor),
    // it will set the right password fields and set the button action
    @FXML
    public void initialize() {
        changeVisibility();

        button.setOnAction(buttonEvent -> {
            if (username.getText().equals(login) && (password.getText().equals(code) || textfield.getText().equals(code))) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        });
    }

    // When the checkbox is clicked, the event will be triggered
    @FXML
    public void handleCheckbox() {
        changeVisibility();
    }

    // Changes the visibility of the password field
    private void changeVisibility() {
        checkbox.setOnAction(checkboxEvent -> {
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
}