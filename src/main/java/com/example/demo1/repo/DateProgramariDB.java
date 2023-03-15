package com.example.demo1.repo;

import com.example.demo1.domain.Client;
import com.example.demo1.domain.DateProgramari;
import com.example.demo1.domain.Programare;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateProgramariDB extends AbstractDBRepository<String, DateProgramari>{
    @Override
    protected PreparedStatement getSaveStatement(Connection connection, DateProgramari entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO programari (id,username1,username2,locatie,data_programare,timp_programare,pret) VALUES (?,?,?,?,?,?,?)");
        return statement;
    }

    @Override
    protected PreparedStatement getRemoveStatement(Connection connection, String id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM programari WHERE id=?");
        return statement;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection connection,  DateProgramari entity,  DateProgramari newEntity) throws SQLException {
        return null;
    }


    @Override
    protected String getTable() {
        return "date_programari";
    }

    @Override
    protected DateProgramari createEntity(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("username");
        String locatie = resultSet.getString("locatie");
        Integer pret = Integer.valueOf(resultSet.getString("pret"));


        DateProgramari programare = new DateProgramari(username,locatie,pret);
        return programare;




    }

    @Override
    public DateProgramari findOne(String integer) {
        return null;
    }
}
