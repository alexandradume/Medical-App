package com.example.demo1.controllers;

import com.example.demo1.HelloApplication;
import com.example.demo1.domain.Programare;
import com.example.demo1.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static java.util.stream.StreamSupport.stream;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorController {
    private Service service;
    private String username;
    @FXML
    private TableView<Programare> table;
    @FXML
    private TableColumn<Programare,String> locatie;
    @FXML
    private TableColumn<Programare, LocalDate> dataProgramare;
    @FXML
    private TableColumn<Programare, LocalTime> timpProgramare;

    private final ObservableList<Programare> model1 = FXCollections.observableArrayList();

    ObservableList<String> motivatie = FXCollections.observableArrayList("nu mai pot ajunge la timp", "am o alta programare atunci");
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label label;
    public void setService(Service service, String username) {
        this.service = service;
        initModel(username);
        this.username = username;
        label.setText(username);
        comboBox.setItems(motivatie);

    }


    @FXML
    public void initialize() {


        locatie.setCellValueFactory(new PropertyValueFactory<>("locatie"));
        dataProgramare.setCellValueFactory(new PropertyValueFactory<>("dataProgramare"));
        timpProgramare.setCellValueFactory(new PropertyValueFactory<>("timpProgramare"));
        table.setItems(model1);

    }





    private void initModel(String user) {
        System.out.println(label.getText());
        Iterable<Programare> entities = service.getProgramariForDoctor(user);
        List<Programare> items = stream(entities.spliterator(), false).collect(Collectors.toList());
        model1.setAll(items);

    }
    public void delete(ActionEvent actionEvent) {

        Programare programare  = table.getSelectionModel().getSelectedItem();
        service.removeProgramare(programare.getId());
    }
    public void refreshMethod(ActionEvent actionEvent) {
        initModel(username);
    }

    public void informatii(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("conferinte.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 370, 350);
        Stage stage = new Stage();
        stage.setTitle("Conferinte");
        stage.setScene(scene);
        stage.show();
    }

    public void afiseazaPoze(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("poze.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 460, 350);
        Stage stage = new Stage();
        stage.setTitle("Poze");
        stage.setScene(scene);
        stage.show();
    }
}
