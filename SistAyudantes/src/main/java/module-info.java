module com.sistema.ayudantes.sistayudantes {
    requires javafx.controls;
    requires javafx.fxml;
    requires spark.core;
    requires mongo.java.driver;
    requires org.json;
    requires com.fasterxml.jackson.databind;
    requires okhttp3;


    opens com.sistema.ayudantes.sistayudantes to javafx.fxml;
    exports com.sistema.ayudantes.sistayudantes;
    exports com.sistema.ayudantes.sistayudantes.API;
    opens com.sistema.ayudantes.sistayudantes.API to javafx.fxml;
    exports com.sistema.ayudantes.sistayudantes.API.DataInterfaces;
    opens com.sistema.ayudantes.sistayudantes.API.DataInterfaces to javafx.fxml;
}