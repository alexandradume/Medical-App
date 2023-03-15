package com.example.demo1.controllers;

import com.example.demo1.service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClientSignInController {


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
    private Label label;

    ObservableList<String> orase = FXCollections.observableArrayList("Brasov", "Cluj-Napoca","Bucuresti");

    public void setService(Service service) {
        this.service = service;
        comboBox.setItems(orase);
    }

    public void signIn(ActionEvent actionEvent) {
        String name = numeTF.getText();
        String username = usernameTF.getText();
        String password= parolaTF.getText();
        String city= (String) comboBox.getValue();
        /*System.out.println(name);
        System.out.println(username);
        System.out.println(city);
        System.out.println(password);*/
        int truth = service.addClient(username,password,name,city);
        if(truth == 0)
            label.setText("Successful sign up");
        if(truth == -1)
            label.setText("Some fields are empty");
        if(truth == 1)
            label.setText("This username is already used");

    }
}
