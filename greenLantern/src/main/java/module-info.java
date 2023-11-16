module com.example.greenlantern {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.greenlantern to javafx.fxml;
    exports com.example.greenlantern;
}