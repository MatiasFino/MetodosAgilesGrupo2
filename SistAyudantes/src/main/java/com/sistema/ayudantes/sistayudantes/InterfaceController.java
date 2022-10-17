package com.sistema.ayudantes.sistayudantes;

import javafx.application.Platform;
import javafx.beans.value.ObservableSetValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InterfaceController implements Initializable {
    @FXML private AnchorPane subjectsPanel;
    @FXML private AnchorPane principalPanel;
    @FXML private AnchorPane assistantsPanel;
    @FXML private Label nameSubject;
    @FXML private Label cantidadAyudantia;
    @FXML private TableView<Materia> subjectsTable;
    @FXML private TableView<Ayudante> assistantsTable;
    @FXML private Text txtNotification = new Text("Notifications");
    private ArrayList<Materia> subjectsList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Materia> s = FXCollections.observableList(createStringList());
        subjectsTable.setItems(s);
        TableColumn<Materia,String> subjectsColumn = new TableColumn<>("Materias");
        subjectsTable.setMinSize(405,215);
        subjectsTable.setMaxSize(405,215);
        subjectsColumn.setMinWidth(assistantsTable.getMinWidth());
        subjectsColumn.setMaxWidth(assistantsTable.getMaxWidth());
        subjectsColumn.setCellValueFactory(new PropertyValueFactory<Materia,String>("nombre"));
        subjectsColumn.setMinWidth(subjectsTable.getMaxWidth());
        subjectsTable.getColumns().addAll(subjectsColumn);
    }

    public ArrayList<Materia> createStringList(){
        subjectsList = new ArrayList<>();
        Materia m1 = new Materia("Prog 1");
        m1.setAyudantesNecesarios(3); // en esta linea indico la cantidad de ayudantes que necesita la materia
        m1.addAyudante(new Ayudante("Langoni"));
        m1.addAyudante(new Ayudante("Benedetto"));
        m1.addAyudante(new Ayudante("Varela"));
        Materia m2 = new Materia("Analisis 1");
        m2.setAyudantesNecesarios(4);
        m2.addAyudante(new Ayudante("Borja"));
        m2.addAyudante(new Ayudante("Armani"));
        m2.addAyudante(new Ayudante("Barco"));
        Materia m3 = new Materia("Objetos");
        m3.setAyudantesNecesarios(5);
        m3.addAyudante(new Ayudante("Messi"));
        m3.addAyudante(new Ayudante("Paredes"));
        m3.addAyudante(new Ayudante("Romero"));
        subjectsList.add(m1);
        subjectsList.add(m2);
        subjectsList.add(m3);
        return subjectsList;
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


    public void onViewAssistantsChoiceClicked(MouseEvent event){
        if(subjectsTable.getSelectionModel().isEmpty()){
            txtNotification.setVisible(true);
            txtNotification.setText("Por favor, seleccione una materia de la lista para ver sus ayudantes designados");
        }
        else {
            txtNotification.setVisible(false);
            subjectsPanel.setVisible(false);
            principalPanel.setVisible(false);
            assistantsPanel.setVisible(true);
            for(int i=0;i<subjectsList.size();i++) {
                if (subjectsTable.getSelectionModel().getSelectedItem().equals(subjectsList.get(i))) {
                    ObservableList<Ayudante> a = FXCollections.observableArrayList(subjectsList.get(i).getAyudantes());
                    assistantsTable.getColumns().clear();
                    assistantsTable.setItems(a);
                    TableColumn<Ayudante,String> assistantsColumn = new TableColumn<>("Ayudantes");
                    assistantsTable.setMinSize(405,215);
                    assistantsTable.setMaxSize(405,215);
                    assistantsColumn.setMinWidth(assistantsTable.getMinWidth());
                    assistantsColumn.setMaxWidth(assistantsTable.getMaxWidth());
                    assistantsColumn.setCellValueFactory(new PropertyValueFactory<Ayudante,String>("nombre"));
                    assistantsColumn.setMinWidth(assistantsTable.getMaxWidth());
                    assistantsTable.getColumns().addAll(assistantsColumn);
                    nameSubject.setText(subjectsList.get(i).getNombre());
                    cantidadAyudantia.setText(subjectsList.get(i).getNombre() + " posee "+ subjectsList.get(i).cantAyudantesActuales()+" de "+subjectsList.get(i).getAyudantesNecesarios()+" ayudantes necesarios");
                }
            }
        }
    }

}