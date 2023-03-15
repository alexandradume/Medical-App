package com.example.demo1;

import com.example.demo1.repo.ClientDB;
import com.example.demo1.repo.DateProgramariDB;
import com.example.demo1.repo.DoctorDB;
import com.example.demo1.repo.ProgramareDB;
import com.example.demo1.service.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private CheckBox doctorCheck;

    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;


    private Service service;

    @FXML
    private Label label;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void signIn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("SignIn!");
        stage.setScene(scene);
        SignInController controller = fxmlLoader.getController();
        controller.setService(new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB()));
        stage.show();
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void logIn(ActionEvent actionEvent) throws IOException {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        boolean truth = doctorCheck.isSelected();
        if (truth) {
            boolean isCorrect = service.validate(username, password);
            if (isCorrect) {
                label.setText("");
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("doctor.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 700, 245);
                Stage stage = new Stage();
                stage.setTitle("Home!");
                stage.setScene(scene);
                DoctorController controller = fxmlLoader.getController();
                controller.setService(new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB()), username);
                stage.show();
            }
            else{
                label.setText("Datele nu sunt corecte!");
            }
        }
        if(!truth){
            boolean isCorrect = service.validateClient(username, password);
            if (isCorrect) {
                label.setText("");
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("client.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 850, 280);
                Stage stage = new Stage();
                stage.setTitle("Home!");
                stage.setScene(scene);
                ClientController controller = fxmlLoader.getController();
                controller.setService(new Service(new ClientDB(), new DoctorDB(), new ProgramareDB(), new DateProgramariDB()), username);
                stage.show();}
            else{
                label.setText("Datele nu sunt corecte!");
            }

        }
    }


}