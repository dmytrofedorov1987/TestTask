package com.example.testtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Need connection and create database from checking.
 */
@WebServlet("/add")
public class AddWarehouseServlet extends HttpServlet {

    private final WarehouseDAOImp warehouseDAOImp;

    public AddWarehouseServlet(WarehouseDAOImp warehouseDAOImp) {
        this.warehouseDAOImp = warehouseDAOImp;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setContentType("application/json");
        try (Connection connection = ConnectionFactory.getConnection()) {
            warehouseDAOImp.createTable();
            String jsonWarehouse = req.getParameter("warehouse");
            ObjectMapper objectMapper = new ObjectMapper();
            Warehouse warehouse = objectMapper.readValue(jsonWarehouse, Warehouse.class);
            warehouseDAOImp.addWarehouse(warehouse);
            PrintWriter printWriter = resp.getWriter();
            printWriter.write("Success");
            printWriter.close();
        } catch (SQLException ex) {

        }
    }
}
