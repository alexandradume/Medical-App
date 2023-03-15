package com.example.demo1.repo;

import com.example.demo1.domain.Entity;


import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractDBRepository<ID, E extends Entity<ID>> implements Repository<ID, E> {
    protected String username = "postgres";
    protected String password = "picolino123";
    private String url = "jdbc:postgresql://localhost:5432/postgres";

    protected abstract PreparedStatement getSaveStatement(Connection connection, E entity) throws SQLException;

    protected abstract PreparedStatement getRemoveStatement(Connection connection, ID id) throws SQLException;

    protected abstract PreparedStatement getUpdateStatement(Connection connection, E entity, E newEntity) throws SQLException;

    protected abstract String getTable();

    protected abstract E createEntity(ResultSet resultSet) throws SQLException;


    @Override
    public Iterable<E> findAll() {
        Set<E> entities = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from " + getTable());
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                E entity = createEntity(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E save(E entity) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = getSaveStatement(connection, entity)) {
            statement.executeUpdate();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ID remove(ID id) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = getRemoveStatement(connection, id)) {
            statement.executeUpdate();
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E update(E entity, E newEntity) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = getUpdateStatement(connection, entity, newEntity)) {
            statement.executeUpdate();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


