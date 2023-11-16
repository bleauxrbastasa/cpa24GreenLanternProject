module com.example.greenlantern {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.greenlantern to javafx.fxml;
    exports com.example.greenlantern;
}