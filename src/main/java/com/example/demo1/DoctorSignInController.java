package com.example.demo1;

import com.example.demo1.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DoctorSignInController {

    Service service;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField parolaTF;
    @FXML
    private TextField numeTF;
    @FXML
    private ComboBox comboBox;

    @FXML
    private ComboBox comboBox2;

    @FXML
    private Label label;

    ObservableList<String> orase = FXCollections.observableArrayList("Brasov", "Cluj-Napoca","Bucuresti");
    ObservableList<String> specializari = FXCollections.observableArrayList("dermatolog", "oftalmolog", "pediatru", "internist", "cardiolog", "urolog", "hematolog", "endocrinolog", "ginecolog");

    public void setService(Service service) {
        this.service = service;
        comboBox.setItems(orase);
        comboBox2.setItems(specializari);
    }

    public void signIn(ActionEvent actionEvent) {
        String name = numeTF.getText();
        String username = usernameTF.getText();
        String password= parolaTF.getText();
        String city= (String) comboBox.getValue();
        String speciality = (String) comboBox2.getValue();
        System.out.println(name);
        System.out.println(username);
        System.out.println(city);
        System.out.println(password);
        System.out.println(speciality);
        int truth = service.addDoctor(username,password,name,city,speciality);
        if(truth == 0)
            label.setText("Successful sign up");
        if(truth == -1)
            label.setText("Some fields are empty");
        if(truth == 1)
            label.setText("This username is already used");

    }
}

