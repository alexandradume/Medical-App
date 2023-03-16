package com.example.demo1;

import com.example.demo1.controllers.HelloController;
import com.example.demo1.repo.*;
import com.example.demo1.service.Service;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 250);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        HelloController controller = fxmlLoader.getController();
        controller.setService(new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB(), new NotaDB()));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}