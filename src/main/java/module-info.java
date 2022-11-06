module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens truc to javafx.fxml;
    exports truc;
}