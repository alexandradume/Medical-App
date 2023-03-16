package com.example.demo1.controllers;

import com.example.demo1.FeedbackController;
import com.example.demo1.HelloApplication;
import com.example.demo1.domain.Programare;
import com.example.demo1.repo.*;
import com.example.demo1.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

public class ClientController {
    private Service service;
    private String username;
    @FXML
    private ComboBox combo;
    @FXML
    private TableView<Programare> table;
    @FXML
    private TableColumn<Programare,Integer> pret;
    @FXML
    private TableColumn<Programare,String> username2;
    @FXML
    private TableColumn<Programare,String> locatie;
    @FXML
    private TableColumn<Programare, LocalDate> dataProgramare;
    @FXML
    private TableColumn<Programare, LocalTime> timpProgramare;
    @FXML
    private DatePicker date;

    private final ObservableList<Programare> model1 = FXCollections.observableArrayList();
    ObservableList<String> specializari = FXCollections.observableArrayList("dermatolog", "oftalmolog", "pediatru", "internist", "cardiolog", "urolog", "hematolog", "endocrinolog", "ginecolog");

    ObservableList<String> motivatie = FXCollections.observableArrayList("nu mai pot ajunge la timp", "nu mai am nevoie de programare");
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField ora;

    @FXML
    private Label label;

    @FXML
    private Label uuu;
    public void setService(Service service, String username) {
        this.service = service;
        initModel(username);
        this.username = username;
        label.setText(username);
        combo.setItems(specializari);
        comboBox.setItems(motivatie);

    }


    @FXML
    public void initialize() {

        username2.setCellValueFactory(new PropertyValueFactory<>("username2"));
        locatie.setCellValueFactory(new PropertyValueFactory<>("locatie"));
        dataProgramare.setCellValueFactory(new PropertyValueFactory<>("dataProgramare"));
        timpProgramare.setCellValueFactory(new PropertyValueFactory<>("timpProgramare"));
        pret.setCellValueFactory(new PropertyValueFactory<>("pret"));

        table.setItems(model1);

    }





    private void initModel(String user) {
        System.out.println(label.getText());
        Iterable<Programare> entities = service.getProgramariForClients(user);
        List<Programare> items = stream(entities.spliterator(), false).collect(Collectors.toList());
        model1.setAll(items);

    }

    public void addProgramare(ActionEvent actionEvent) {
        int rezultat = service.addProgramare(username, combo.getValue().toString(), date.getValue(), Time.valueOf(ora.getText()).toLocalTime());
        if(rezultat == 1)
            uuu.setText("Nu exista aceasta specializare in orasul tau.");
        if(rezultat == -1)
            uuu.setText("Ora nu este disponibila");
    }

    public void refreshMethod(ActionEvent actionEvent) {
        initModel(username);
    }


    public void delete(ActionEvent actionEvent) {

        Programare programare  = table.getSelectionModel().getSelectedItem();
        service.removeProgramare(programare.getId());
    }

    public void fereastraNoua(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("informationClients.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 230, 300);
        Stage stage = new Stage();
        stage.setTitle("Informatii!");
        stage.setScene(scene);
        InfromationClientsController controller = fxmlLoader.getController();
        //controller.setService(new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB()), username);
        stage.show();
    }

    public void feedback(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("feedback.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 250, 250);
        Stage stage = new Stage();
        stage.setTitle("Home!");
        stage.setScene(scene1);
        FeedbackController controller = fxmlLoader.getController();
        controller.setService(new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB(), new NotaDB()));
        stage.show();}

}


