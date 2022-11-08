package com.sistema.ayudantes.sistayudantes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        Controller c= new Controller();
        c.cargarMaterias("cuantificador-grupo1.csv");
        c.cargarPostulantes("orden-merito.csv");
        c.imprimirPostulantesxMateria();
        c.imprimirTotalPostulates();        
    }
}