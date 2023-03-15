package com.example.demo1.repo;

import com.example.demo1.domain.Doctor;
import com.example.demo1.domain.Programare;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class ProgramareDB extends AbstractDBRepository<Integer, Programare> {

    @Override
    protected PreparedStatement getSaveStatement(Connection connection, Programare entity) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO programari (id,username1,username2,locatie,data_programare,timp_programare,pret) VALUES (?,?,?,?,?,?,?)");
        statement.setInt(1, entity.getId());
        statement.setString(2, entity.getUsername1());
        statement.setString(3, entity.getUsername2());
        statement.setString(4, entity.getLocatie());
        statement.setDate(5, Date.valueOf(entity.getDataProgramare()));
        statement.setTime(6, Time.valueOf(entity.getTimpProgramare()));
        statement.setInt(7, entity.getPret());
        return statement;
    }

    @Override
    protected PreparedStatement getRemoveStatement(Connection connection, Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM programari WHERE id=?");
        statement.setInt(1, Math.toIntExact(id));
        return statement;
    }

    @Override
    protected PreparedStatement getUpdateStatement(Connection connection,  Programare entity,  Programare newEntity) throws SQLException {
        return null;
    }


    @Override
    protected String getTable() {
        return "programari";
    }

    @Override
    protected Programare createEntity(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String username1 = resultSet.getString("username1");
        String username2 = resultSet.getString("username2");
        String locatie = resultSet.getString("locatie");
        LocalDate dataProgramare  = resultSet.getDate("data_programare").toLocalDate();
        LocalTime timpProgramare = resultSet.getTime("timp_programare").toLocalTime();
        Integer pret = Integer.valueOf(resultSet.getString("pret"));


        Programare programare = new Programare(id,username1,username2,locatie,dataProgramare,timpProgramare,pret);
        return programare;




    }

    @Override
    public Programare findOne(Integer integer) {
        return null;
    }
}
