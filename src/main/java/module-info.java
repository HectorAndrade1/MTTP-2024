module com.example.mttp2024 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;


    opens com.example.mttp2024.vistacontroller to javafx.fxml;
    exports com.example.mttp2024;
}