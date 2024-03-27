package com.example.mttp2024;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sugerencia menu kevin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),854,480);
        Image imagen=new Image("imagenes/logo_chiquito-removebg-preview.png");
        stage.getIcons().add(imagen);
            stage.setTitle("ORGANIZADOR DE TAREAS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}