module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    opens com.example.demo1.domain;
    exports com.example.demo1.controllers;
    opens com.example.demo1.controllers to javafx.fxml;
}