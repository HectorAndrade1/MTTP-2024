module com.example.mttp2024 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    exports com.example.mttp2024.models;

    opens com.example.mttp2024 to javafx.fxml;
    exports com.example.mttp2024;
}