module com.sistema.ayudantes.sistayudantes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sistema.ayudantes.sistayudantes to javafx.fxml;
    exports com.sistema.ayudantes.sistayudantes;
}