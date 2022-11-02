module com.sistema.ayudantes.sistayudantes {
    requires javafx.controls;
    requires javafx.fxml;
    requires spark.core;
    requires mongo.java.driver;
    requires gson;


    opens com.sistema.ayudantes.sistayudantes to javafx.fxml;
    exports com.sistema.ayudantes.sistayudantes;
    exports com.sistema.ayudantes.sistayudantes.API;
    opens com.sistema.ayudantes.sistayudantes.API to javafx.fxml;
}