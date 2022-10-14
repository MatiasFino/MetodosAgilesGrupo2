package com.sistema.ayudantes.sistayudantes;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class InterfaceController {
    @FXML private Button subjectsButton;
    @FXML private AnchorPane subjectsPanel;
    @FXML private AnchorPane principalPanel;
    @FXML private AnchorPane assistantsPanel;
    public void onExitButtonClicked(MouseEvent event){ //SALE DE LA INTERFAZ
        Platform.exit();
        System.exit(0);
    }

    public void onSubjectsButtonClicked(MouseEvent event){ //PASA A LA SECCION DE MATERIAS
        subjectsPanel.setVisible(true);
        principalPanel.setVisible(false);
        assistantsPanel.setVisible(false);
    }

    public void onBackPrincipalPanelButtonClicked(MouseEvent event){
        subjectsPanel.setVisible(false);
        principalPanel.setVisible(true);
        assistantsPanel.setVisible(false);
    }

    public void onBackSubjectsPanelButtonClicked(MouseEvent event){
        subjectsPanel.setVisible(true);
        principalPanel.setVisible(false);
        assistantsPanel.setVisible(false);
    }
}