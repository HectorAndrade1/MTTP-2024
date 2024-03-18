module com.example.mttp2024 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mttp2024 to javafx.fxml;
    exports com.example.mttp2024;
}