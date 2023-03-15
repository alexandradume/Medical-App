package com.example.demo1.controllers;

import com.example.demo1.HelloApplication;
import com.example.demo1.controllers.ClientSignInController;
import com.example.demo1.controllers.DoctorSignInController;
import com.example.demo1.repo.ClientDB;
import com.example.demo1.repo.DateProgramariDB;
import com.example.demo1.repo.DoctorDB;
import com.example.demo1.repo.ProgramareDB;
import com.example.demo1.service.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {


    private Service service;
    public void isDoctor(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("doctorSignIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("SignIn!");
        stage.setScene(scene);
        DoctorSignInController controller = fxmlLoader.getController();
        controller.setService(new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB()));
        stage.show();
    }

    public void isClient(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("clientSignIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("SignIn!");
        stage.setScene(scene);
        ClientSignInController controller = fxmlLoader.getController();
        controller.setService(new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB()));
        stage.show();
    }

    public void setService(Service service) {
        this.service = service;
    }
}
