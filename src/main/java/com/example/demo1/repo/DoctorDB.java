package com.example.demo1.repo;

import com.example.demo1.domain.Client;
import com.example.demo1.domain.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDB extends AbstractDBRepository<String, Doctor> {

    @Override
    protected PreparedStatement getSaveStatement(Connection connection, Doctor entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO doctori (username,parola,nume,oras,specializare) VALUES (?,?,?,?,?)");
        statement.setString(1, entity.getUsername());
        statement.setString(2, entity.getParola());
        statement.setString(3, entity.getNume());
        statement.setString(4, entity.getOras());
        statement.setString(5, entity.getSpecializare());
        return statement;
    }

    @Override
    protected PreparedStatement getRemoveStatement(Connection connection, String integer) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection connection,  Doctor entity,  Doctor newEntity) throws SQLException {
        return null;
    }


    @Override
    protected String getTable() {
        return "doctori";
    }

    @Override
    protected Doctor createEntity(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("username");
        String parola = resultSet.getString("parola");
        String nume = resultSet.getString("nume");
        String oras = resultSet.getString("oras");
        String specializare = resultSet.getString("specializare");


        Doctor client = new Doctor(username,parola,nume,oras,specializare);
        return client;




    }

    @Override
    public Doctor findOne(String integer) {
        return null;
    }
}




