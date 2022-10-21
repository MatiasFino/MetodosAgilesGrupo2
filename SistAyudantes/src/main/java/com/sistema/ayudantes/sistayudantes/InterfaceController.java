package com.sistema.ayudantes.sistayudantes;

import javafx.application.Platform;
import javafx.beans.value.ObservableSetValue;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.paint.*;
import javafx.util.Callback;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

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
    private TableColumn<Materia,String> subjectsColumn = new TableColumn<Materia,String>("Materias");

    private  ObservableList<Materia> s = FXCollections.observableList(createStringList());


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //se transforma una lista de un objeto en una observableArrayList
        subjectsTable.setItems(s);
        //TableColumn<Materia, String> subjectsColumn = new TableColumn<Materia, String>("Materias");
        TableColumn<Materia,String> estadoMateria= new TableColumn<Materia,String>("Estado");
        subjectsTable.setMinSize(842, 345);
        subjectsTable.setMaxSize(842, 1200);

        subjectsColumn.setMinWidth(assistantsTable.getMinWidth());
        subjectsColumn.setMaxWidth(assistantsTable.getMaxWidth());
        subjectsColumn.setCellValueFactory(new PropertyValueFactory<Materia, String>("nombre")); //nombre es la varible de la clase materia
        estadoMateria.setCellValueFactory(new PropertyValueFactory<Materia,String>("Estado"));
        //configuramos las columnas para que sepan de donde sacar la informacion
        subjectsColumn.setMinWidth(subjectsTable.getMaxWidth()/2);
        estadoMateria.setMaxWidth(subjectsTable.getMaxWidth());
        estadoMateria.setMinWidth(subjectsTable.getMinWidth()/2);
        subjectsTable.getColumns().addAll(subjectsColumn,estadoMateria);
        colorear(subjectsColumn);
        contarEstado();
        colorearEstado(estadoMateria);
    }


    public void contarEstado(){
        for(int i = 0; i < subjectsList.size();i++){
            subjectsList.get(i).estadoMateria();
        }
    }


    public int get_cantidad(String nombre) {
        for (int i = 0; i < subjectsList.size(); i++) {
            if (subjectsList.get(i).getNombre().equals(nombre)) {
                return subjectsList.get(i).cantAyudantesActuales();
            }
        }
        return 0;
    }


    public int get_cantidad_necesario(String nombre){
        for (int i = 0; i < subjectsList.size(); i++) {
            if (subjectsList.get(i).getNombre().equals(nombre)) {
                return subjectsList.get(i).getAyudantesNecesarios();
            }
        }
        return 0;
    }

    public void colorear(TableColumn<Materia,String> columna) {
        columna.setCellFactory(column -> {
            return new TableCell<Materia,String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        if (get_cantidad(item) < get_cantidad_necesario(item)) {
                            setStyle("-fx-background-color: yellow");
                        }
                        if (get_cantidad(item)==0){
                            setStyle("-fx-background-color: RED");
                        }
                        if (get_cantidad(item)==get_cantidad_necesario(item)){
                            setStyle("-fx-background-color: green");
                        }
                    }
                    setText(item);

                }
            };
        });
    }


    public void colorearEstado(TableColumn<Materia,String> columna) {
        columna.setCellFactory(column -> {
            return new TableCell<Materia,String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        if (item.equals("Incompleto")) {
                            setStyle("-fx-background-color: yellow");
                        }
                        if (item.equals("Sin candidatos")){
                            setStyle("-fx-background-color: RED");
                        }
                        if (item.equals("Completo")){
                            setStyle("-fx-background-color: green");
                        }
                    }
                    setText(item);

                }
            };
        });
    }

    public ArrayList<Materia> createStringList(){
        subjectsList = new ArrayList<>();
        Materia m1 = new Materia("Prog 1");
        m1.setAyudantesNecesarios(3); // en esta linea indico la cantidad de ayudantes que necesita la materia
        m1.addAyudante(new Ayudante("Luca","Alumno","langoni@gmail.com","Langoni"));
        m1.addAyudante(new Ayudante("Dario","Alumno","dario@gmail.com","Benedetto"));
        m1.addAyudante(new Ayudante("Alan","Alumno","discoteca@gmail.com","Varela"));
        Materia m2 = new Materia("Analisis 1");
        m2.setAyudantesNecesarios(4);
        m2.addAyudante(new Ayudante("Miguel","Alumno","borja@gmail.com","Borja"));
        m2.addAyudante(new Ayudante("Franco","Alumno","franco@gmail.com","Armani"));
        m2.addAyudante(new Ayudante("Ezequiel","Alumno","Eze@gmail.com","Barco"));
        Materia m3 = new Materia("Objetos");
        m3.setAyudantesNecesarios(5);
        m3.addAyudante(new Ayudante("Lionel","Alumno","Messi@gmail.com","Messi"));
        m3.addAyudante(new Ayudante("Leandro","Alumno","Paredes@gmail.com","Paredes"));
        Materia m8 = new Materia("Analisis 2");
        m8.setAyudantesNecesarios(5);
        Materia m9 = new Materia("Analisis 3");
        m9.setAyudantesNecesarios(5);
        Materia m10 = new Materia("Analisis 4");
        m10.setAyudantesNecesarios(5);
        Materia m11 = new Materia("Analisis 5");
        m11.setAyudantesNecesarios(5);
        Materia m12 = new Materia("Analisis 6");
        m12.setAyudantesNecesarios(3);
        Materia m13 = new Materia("Analisis 7");
        m13.setAyudantesNecesarios(3);
        Materia m14 = new Materia("Analisis 8");
        m14.setAyudantesNecesarios(5);
        subjectsList.add(m1);
        subjectsList.add(m2);
        subjectsList.add(m3);
        subjectsList.add(m8);
        subjectsList.add(m9);
        subjectsList.add(m10);
        subjectsList.add(m11);
        subjectsList.add(m12);
        subjectsList.add(m13);
        subjectsList.add(m14);
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
                    TableColumn<Ayudante,Label> assistantsColumn = new TableColumn<>("Nombre");
                    TableColumn<Ayudante,Label> asistApellido = new TableColumn<>("Apellido");
                    TableColumn<Ayudante,Label> emailAyudante = new TableColumn<>("Email");
                    TableColumn<Ayudante,Label> tipoAyudante = new TableColumn<>("tipo");
                    assistantsTable.setMinSize(800, 345);
                    assistantsTable.setMaxSize(842, 800);
                    assistantsColumn.setCellValueFactory(new PropertyValueFactory<Ayudante,Label>("nombre"));
                    asistApellido.setCellValueFactory(new PropertyValueFactory<Ayudante,Label>("apellido"));
                    emailAyudante.setCellValueFactory(new PropertyValueFactory<Ayudante,Label>("email"));
                    tipoAyudante.setCellValueFactory(new PropertyValueFactory<Ayudante,Label>("tipo"));
                    assistantsColumn.setMinWidth(assistantsTable.getMinWidth()/4);
                    asistApellido.setMinWidth(assistantsTable.getMinWidth()/4);
                    emailAyudante.setMinWidth(assistantsTable.getMinWidth()/4);
                    tipoAyudante.setMinWidth(assistantsTable.getMinWidth()/4);
                    assistantsTable.getColumns().addAll(assistantsColumn,asistApellido,tipoAyudante,emailAyudante);
                    nameSubject.setText(subjectsList.get(i).getNombre());
                    cantidadAyudantia.setText(subjectsList.get(i).getNombre() + " posee "+ subjectsList.get(i).cantAyudantesActuales()+" de "+subjectsList.get(i).getAyudantesNecesarios()+" ayudantes necesarios");
                }
            }
        }
    }
}