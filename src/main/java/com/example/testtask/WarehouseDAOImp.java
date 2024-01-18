package com.example.testtask;

import jakarta.servlet.ServletException;

import java.sql.*;

public class WarehouseDAOImp implements WarehouseDAO {
    private final Connection connection;
    private final ConnectionFactory factory;

    public WarehouseDAOImp(Connection connection, ConnectionFactory factory) {
        this.connection = connection;
        this.factory = factory;
    }

    @Override
    public void createTable() {
        try(Connection connection = ConnectionFactory.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("DROP TABLE IF EXISTS warehouse");
                statement.execute("CREATE TABLE warehouse (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50) NOT NULL, address_line_1 VARCHAR(100) NOT NULL, address_line_2 VARCHAR(100), city VARCHAR(50) NOT NULL, state VARCHAR(50) NOT NULL, country VARCHAR(50) NOT NULL, inventory_quantity INT NOT NULL)");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void addWarehouse(Warehouse warehouse) {
        try (Connection connection = ConnectionFactory.getConnection()){
            try (PreparedStatement pr = connection.prepareStatement("INSERT INTO warehouse(name, address_line_1, address_line_2, city, state, country, inventory_quantity) VALUES (?,?,?,?,?,?,?)")) {
                pr.setString(1, warehouse.getName());
                pr.setString(2, warehouse.getAddress_line_1());
                pr.setString(3, warehouse.getAddress_line_2());
                pr.setString(4, warehouse.getCity());
                pr.setString(5, warehouse.getState());
                pr.setString(6, warehouse.getCountry());
                pr.setInt(7, warehouse.getInventory_quantity());
                pr.executeUpdate();
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void updateWarehouse(Warehouse warehouse) {
        try (Connection connection = ConnectionFactory.getConnection()){
            try (PreparedStatement pr = connection.prepareStatement("UPDATE warehouse SET (name, address_line_1, address_line_2, city, state, country, inventory_quantity) VALUES (?,?,?,?,?,?,?) WHERE id = ?")) {
                pr.setString(1, warehouse.getName());
                pr.setString(2, warehouse.getAddress_line_1());
                pr.setString(3, warehouse.getAddress_line_2());
                pr.setString(4, warehouse.getCity());
                pr.setString(5, warehouse.getState());
                pr.setString(6, warehouse.getCountry());
                pr.setInt(7, warehouse.getInventory_quantity());
                pr.setInt(8, warehouse.getId());
                pr.executeUpdate();
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deleteWarehouse(int id) {
        try (Connection connection = ConnectionFactory.getConnection()){
            try (PreparedStatement pr = connection.prepareStatement("DELETE warehouse WHERE id = ?")) {
                pr.setInt(1, id);
                pr.executeUpdate();
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Warehouse getWarehouse(int id) {
        Warehouse warehouse = new Warehouse();
        try (Connection connection = ConnectionFactory.getConnection()){
            try (PreparedStatement pr = connection.prepareStatement("SELECT warehouse WHERE id = ?")) {
                pr.setInt(1, id);
                ResultSet resultSet = pr.executeQuery();
                for (; resultSet.next(); ) {
                    warehouse.setId(resultSet.getInt("id"));
                    warehouse.setName(resultSet.getString("name"));
                    warehouse.setAddress_line_1(resultSet.getString("address_line_1"));
                    warehouse.setAddress_line_2(resultSet.getString("address_line_2"));
                    warehouse.setCity(resultSet.getString("city"));
                    warehouse.setState(resultSet.getString("state"));
                    warehouse.setCountry(resultSet.getString("country"));
                    warehouse.setInventory_quantity(resultSet.getInt("inventory_quantity"));
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return warehouse;
    }
}