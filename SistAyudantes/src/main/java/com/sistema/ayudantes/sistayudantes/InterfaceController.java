package com.sistema.ayudantes.sistayudantes;

import javafx.application.Platform;
import javafx.beans.value.ObservableSetValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InterfaceController implements Initializable {
    @FXML private AnchorPane subjectsPanel;
    @FXML private AnchorPane principalPanel;
    @FXML private AnchorPane assistantsPanel;
    @FXML private ComboBox subjects;
    @FXML private ComboBox assistants;
    @FXML private Label nameSubject;

    @FXML private Text cantidadAyudantia;



    private ArrayList<Materia> subjectsList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> subjectsName = createStringList();
        ObservableList<String> s = FXCollections.observableList(subjectsName);
        for(int i=0;i<subjectsName.size();i++){
            subjects.setItems(s);
        }
    }

    public ArrayList<String> createStringList(){
        subjectsList = new ArrayList<>();
        Materia m1 = new Materia("Prog 1");
        m1.setAyudantes(3); // en esta linea indico la cantidad de ayudantes que necesita la materia
        m1.addAyudante("Langoni");
        m1.addAyudante("Benedetto");
        m1.addAyudante("Varela");
        Materia m2 = new Materia("Analisis 1");
        m2.setAyudantes(4);
        m2.addAyudante("Borja");
        m2.addAyudante("Armani");
        m2.addAyudante("Barco");
        Materia m3 = new Materia("Objetos");
        m3.setAyudantes(5);
        m3.addAyudante("Messi");
        m3.addAyudante("Paredes");
        m3.addAyudante("Romero");
        subjectsList.add(m1);
        subjectsList.add(m2);
        subjectsList.add(m3);
        ArrayList<String> subjectsName = new ArrayList<>();
        for(int i=0;i<subjectsList.size();i++){
            subjectsName.add(subjectsList.get(i).getNombre());
        }
        return subjectsName;
    }

    public void onExitButtonClicked(MouseEvent event){ //SALE DE LA INTERFAZ
        Platform.exit();
        System.exit(0);
    }

    public void onSubjectsButtonClicked(MouseEvent event){ //PASA A LA SECCION DE MATERIAS
        subjectsPanel.setVisible(true);
        principalPanel.setVisible(false);
        assistantsPanel.setVisible(false);
    }

    public void onBackPrincipalPanelButtonClicked(MouseEvent event){ //VUELVE AL MENU
        subjectsPanel.setVisible(false);
        principalPanel.setVisible(true);
        assistantsPanel.setVisible(false);
    }

    public void onBackSubjectsPanelButtonClicked(MouseEvent event){ //VUELVE A LA LISTA DE MATERIAS
        subjectsPanel.setVisible(true);
        principalPanel.setVisible(false);
        assistantsPanel.setVisible(false);
    }

    public void onSubjectsChanged(ActionEvent event){
        subjectsPanel.setVisible(false);
        principalPanel.setVisible(false);
        assistantsPanel.setVisible(true);
        for(int i=0;i<subjectsList.size();i++) {
            if (subjects.getValue().equals(subjectsList.get(i).getNombre())) {
                ObservableList<String> a = FXCollections.observableList(subjectsList.get(i).getAyudantes());
                int cantidad_ayudantes_actual=a.size(); //esta linea cuenta la cantidad actual de ayudantes
                assistants.setItems(a);
                nameSubject.setText(subjectsList.get(i).getNombre());
                cantidadAyudantia.setText(subjectsList.get(i).getNombre() + " necesita una cantidad de "+subjectsList.get(i).cantidadAyudantes()+" ayudantes");


            }
        }
    }
}