package com.sistema.ayudantes.sistayudantes;

import com.sistema.ayudantes.sistayudantes.API.APIEndpoints;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.AsignacionMateria.AsignacionMateriaDTO;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.AsignacionMateria.AsignacionMateriaCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.Materia.MateriaCollection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bson.Document;

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
        APIEndpoints.configureRoutes();
        launch();
    }
}