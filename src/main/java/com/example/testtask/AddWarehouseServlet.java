package com.example.testtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 */
@WebServlet("/add")
public class AddWarehouseServlet extends HttpServlet {
    static final Connection conn;

    static {
        try {
            conn = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WarehouseDAOImp warehouseDAOImp = new WarehouseDAOImp(conn);
        warehouseDAOImp.createTable();
        String jsonWarehouse = req.getParameter("Warehouse");
        ObjectMapper objectMapper = new ObjectMapper();
        Warehouse warehouse = objectMapper.readValue(jsonWarehouse, Warehouse.class);
        warehouseDAOImp.addWarehouse(warehouse);
    }
}
