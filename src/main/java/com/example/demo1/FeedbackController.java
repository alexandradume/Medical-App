package com.example.demo1;

import com.example.demo1.service.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FeedbackController {
    @FXML
    public TextField descriere;
    @FXML
    public TextField medie;
    @FXML
    public TextField nota;

    private Service service;
    public void setService(Service service) {
        this.service= service;
        this.medie.setText(String.valueOf(service.medie()));
    }

    public void sendFeedback(ActionEvent actionEvent) {
        service.addNota(Integer.valueOf(nota.getText()),descriere.getText());
        nota.setText("");
        descriere.setText("");
        this.medie.setText(String.valueOf(service.medie()));


    }
}
