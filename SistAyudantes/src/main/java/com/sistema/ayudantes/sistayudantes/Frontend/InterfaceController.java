package com.sistema.ayudantes.sistayudantes.Frontend;

import com.sistema.ayudantes.sistayudantes.API.APIRequest;
import com.sistema.ayudantes.sistayudantes.API.DataInterfaces.IAyudante;
import com.sistema.ayudantes.sistayudantes.API.DataInterfaces.IMateria;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private TableColumn<Materia,String> estadoMateria= new TableColumn<Materia,String>("Estado");

    private  ObservableList<Materia> s = FXCollections.observableList(createStringList());

    public InterfaceController() throws IOException {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            subjectsTable.setItems(FXCollections.observableList(createStringList()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //TableColumn<Materia, String> subjectsColumn = new TableColumn<Materia, String>("Materias");
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
        actualizarVista();
    }

    public void actualizarVista(){
                //se transforma una lista de un objeto en una observableArrayList
                try {
                    subjectsTable.setItems(FXCollections.observableList(createStringList()));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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
                return subjectsList.get(i).ayudantesAsignados;
            }
        }
        return 0;
    }


    public int get_cantidad_necesario(String nombre){
        for (int i = 0; i < subjectsList.size(); i++) {
            if (subjectsList.get(i).getNombre().equals(nombre)) {
                return subjectsList.get(i).ayudantesNecesarios;
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

    public ArrayList<Materia> createStringList() throws IOException {
        subjectsList = new ArrayList<>();
        List<IMateria> materias = APIRequest.getMaterias();
        for(IMateria materia : materias) {
            subjectsList.add(new Materia(materia.id, materia.nombre, materia.ayudantesAsignados, materia.ayudantesNecesarios));
        }
        return subjectsList;
    }

    public ArrayList<Ayudante> ayudantesAsignados(String idMateria) throws IOException {
        ArrayList<Ayudante> ayudantesAsignados = new ArrayList<>();
        List<IAyudante> ayudantes = APIRequest.getAyudantes(idMateria);
        for(IAyudante ayudante : ayudantes) {
            ayudantesAsignados.add(new Ayudante(ayudante.nombre, ayudante.tipo, ayudante.email, ayudante.apellido));
        }
        return ayudantesAsignados;
    }

    public void onExitButtonClicked(MouseEvent event){ //SALE DE LA INTERFAZ
        Platform.exit();
        System.exit(0);
    }

    public void onSubjectsButtonClicked(MouseEvent event){ //PASA A LA SECCION DE MATERIAS
        actualizarVista();
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
        actualizarVista();
        subjectsPanel.setVisible(true);
        principalPanel.setVisible(false);
        assistantsPanel.setVisible(false);
    }

    public void onRefreshButtonClicked(MouseEvent event){ //Refresh
        actualizarVista();
    }


    public void onViewAssistantsChoiceClicked(MouseEvent event) throws IOException {
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
                    ObservableList<Ayudante> a = FXCollections.observableArrayList(ayudantesAsignados(subjectsList.get(i).id));
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
                    cantidadAyudantia.setText(subjectsList.get(i).getNombre() + " posee "+ subjectsList.get(i).ayudantesAsignados+" de "+subjectsList.get(i).ayudantesNecesarios+" ayudantes necesarios");
                }
            }
        }
    }
}