package com.sistema.ayudantes.sistayudantes;

import com.sistema.ayudantes.sistayudantes.API.APIEndpoints;
import Email.EmailService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sistema de Ayudantes Interinos");
        stage.setScene(scene);
        stage.show();
    }

    
    public static void main(String[] args) throws IOException {
        APIEndpoints.configureRoutes();
        launch();
        EmailService mailService = new EmailService();
        Controller c= new Controller(mailService);
        c.cargarMaterias("cuantificador-grupo1.csv");
        c.cargarPostulantes("orden-merito.csv");
        c.imprimirPostulantesxMateria();
        c.imprimirTotalPostulates();
        c.asignarAyudantes();
    }
}