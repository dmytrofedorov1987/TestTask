package com.example.testtask;


import java.sql.*;

public class WarehouseDAOImp implements WarehouseDAO {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/testtask?enabledTLSProtocols=TLSv1.2";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        return connection;
    }

    @Override
    public void createTable() {
        try {
            Connection connection = WarehouseDAOImp.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS warehouse");
            statement.execute("CREATE TABLE warehouse (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50) NOT NULL, address_line_1 VARCHAR(100) NOT NULL, address_line_2 VARCHAR(100), city VARCHAR(50) NOT NULL, state VARCHAR(50) NOT NULL, country VARCHAR(50) NOT NULL, inventory_quantity INT NOT NULL)");
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addWarehouse(Warehouse warehouse) {
        try {
            Connection connection = WarehouseDAOImp.getConnection();
            PreparedStatement pr = connection.prepareStatement("INSERT INTO warehouse(name, address_line_1, address_line_2, city, state, country, inventory_quantity) VALUES (?,?,?,?,?,?,?)");
            pr.setString(1, warehouse.getName());
            pr.setString(2, warehouse.getAddress_line_1());
            pr.setString(3, warehouse.getAddress_line_2());
            pr.setString(4, warehouse.getCity());
            pr.setString(5, warehouse.getState());
            pr.setString(6, warehouse.getCountry());
            pr.setInt(7, warehouse.getInventory_quantity());
            pr.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateWarehouse(Warehouse warehouse, int id) {
        try {
            Connection connection = WarehouseDAOImp.getConnection();
            PreparedStatement pr = connection.prepareStatement("UPDATE warehouse SET name=?, address_line_1=?, address_line_2=?, city=?, state=?, country=?, inventory_quantity=? WHERE id = ?");
            pr.setString(1, warehouse.getName());
            pr.setString(2, warehouse.getAddress_line_1());
            pr.setString(3, warehouse.getAddress_line_2());
            pr.setString(4, warehouse.getCity());
            pr.setString(5, warehouse.getState());
            pr.setString(6, warehouse.getCountry());
            pr.setInt(7, warehouse.getInventory_quantity());
            pr.setInt(8, id);
            pr.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteWarehouse(int id) {
        try {
            Connection connection = WarehouseDAOImp.getConnection();
            PreparedStatement pr = connection.prepareStatement("DELETE FROM warehouse WHERE id = ?");
            pr.setInt(1, id);
            pr.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Warehouse getWarehouse(int id) {
        Warehouse warehouse = new Warehouse();
        try {
            Connection connection = WarehouseDAOImp.getConnection();
            PreparedStatement pr = connection.prepareStatement("SELECT * FROM warehouse WHERE id = ?");
            pr.setInt(1, id);
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next()) {
                warehouse.setId(resultSet.getInt("id"));
                warehouse.setName(resultSet.getString("name"));
                warehouse.setAddress_line_1(resultSet.getString("address_line_1"));
                warehouse.setAddress_line_2(resultSet.getString("address_line_2"));
                warehouse.setCity(resultSet.getString("city"));
                warehouse.setState(resultSet.getString("state"));
                warehouse.setCountry(resultSet.getString("country"));
                warehouse.setInventory_quantity(resultSet.getInt("inventory_quantity"));
                connection.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return warehouse;
    }
}
