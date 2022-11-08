package truc;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Controller {

    // All the fxml elements
    @FXML
    public Pane pane;
    @FXML
    public Label mainLabel;
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
    @FXML
    public Label label;

    public final String login = "constance";
    public final String code = "Fall_2023!";

    // Dummy constructor for the FXML file
    public Controller() {
    }

    // The FXML file will call this method when being created (after the constructor),
    // it will set the right password fields and set the button action
    @FXML
    public void initialize() {
        this.textfield.setVisible(false);
        this.label.setOpacity(0);
        this.checkbox.setText(" Show password");
        changeVisibility();

        button.setOnAction(buttonEvent -> {
            if (username.getText().equals(login) && (password.getText().equals(code) || textfield.getText().equals(code))) {
                System.out.println("yes");
            } else {
                this.handleAnimation();
                System.out.println("no");
            }
        });
    }

    // When the checkbox is clicked, the event will be triggered
    @FXML
    public void handleCheckbox() {
        changeVisibility();
    }

    // Handles the label that appears when the password is wrong
    private void handleAnimation() {
        this.label.setOpacity(1);
        FadeTransition transition = new FadeTransition();
        transition.setDuration(Duration.millis(500));
        transition.setFromValue(1);
        transition.setToValue(0);
        transition.setDelay(Duration.millis(1000));
        transition.setNode(label);
        transition.play();
    }

    // Changes the visibility of the password field
    private void changeVisibility() {
        checkbox.setOnAction(checkboxEvent -> {
            if (checkbox.isSelected()) {
                checkbox.setText(" Hide password");
                password.setVisible(false);
                textfield.setVisible(true);
                textfield.setText(password.getText());
            } else {
                checkbox.setText(" Show password");
                password.setVisible(true);
                textfield.setVisible(false);
                password.setText(textfield.getText());
            }
        });
    }
}