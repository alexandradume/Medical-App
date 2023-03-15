package com.example.demo1.controllers;

import com.example.demo1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class InfromationClientsController {
    public void ginecologieButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ginecologie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 250);
        Stage stage = new Stage();
        stage.setTitle("Ginecologie!");
        stage.setScene(scene);
        //InfromationClientsController controller = fxmlLoader.getController();
        //controller.setService(new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB()), username);
        stage.show();
    }

    public void dermatologieButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dermatologie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 250);
        Stage stage = new Stage();
        stage.setTitle("Dermatologie!");
        stage.setScene(scene);
        stage.show();
    }

    public void oftalmolgieButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oftalmologie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 250);
        Stage stage = new Stage();
        stage.setTitle("Oftalmologie!");
        stage.setScene(scene);
        stage.show();
    }
    public void pediatrieButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pediatrie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 250);
        Stage stage = new Stage();
        stage.setTitle("Pediatrie!");
        stage.setScene(scene);
        stage.show();
    }

    public void interneButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("interne.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 250);
        Stage stage = new Stage();
        stage.setTitle("Interne!");
        stage.setScene(scene);
        stage.show();
    }

    public void cardiologieButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cardiologie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 250);
        Stage stage = new Stage();
        stage.setTitle("Cardiologie!");
        stage.setScene(scene);
        stage.show();
    }

    public void urologieButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("urologie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 250);
        Stage stage = new Stage();
        stage.setTitle("Urologie!");
        stage.setScene(scene);
        stage.show();
    }

    public void hematologieButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hematologie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 250);
        Stage stage = new Stage();
        stage.setTitle("Hematologie!");
        stage.setScene(scene);
        stage.show();
    }

    public void endocrinologieButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("endocrinologie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 250);
        Stage stage = new Stage();
        stage.setTitle("Endocrionolgie!");
        stage.setScene(scene);
        stage.show();
    }
}
