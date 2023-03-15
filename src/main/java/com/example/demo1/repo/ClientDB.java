package com.example.demo1.repo;

import com.example.demo1.domain.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDB extends AbstractDBRepository<String, Client> {

    @Override
    protected PreparedStatement getSaveStatement(Connection connection, Client entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO clientii (username,parola,nume,oras) VALUES (?,?,?,?)");
        statement.setString(1, entity.getUsername());
        statement.setString(2, entity.getParola());
        statement.setString(3, entity.getNume());
        statement.setString(4, entity.getOras());
        return statement;
    }

    @Override
    protected PreparedStatement getRemoveStatement(Connection connection, String integer) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection connection,  Client entity,  Client newEntity) throws SQLException {
        return null;
    }


    @Override
    protected String getTable() {
        return "clientii";
    }

    @Override
    protected Client createEntity(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("username");
        String parola = resultSet.getString("parola");
        String nume = resultSet.getString("nume");
        String oras = resultSet.getString("oras");


        Client client = new Client(username,parola,nume,oras);
        return client;




    }

    @Override
    public Client findOne(String integer) {
        return null;
    }
}



