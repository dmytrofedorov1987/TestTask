package com.example.testtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 * Need connection and create database from checking.
 */
@WebServlet("/add")
public class AddWarehouseServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // resp.setContentType("application/json");
        WarehouseDAOImp warehouseDAOImp = new WarehouseDAOImp();
        warehouseDAOImp.createTable();
        String jsonWarehouse = req.getParameter("Warehouse");
        ObjectMapper objectMapper = new ObjectMapper();
        Warehouse warehouse = objectMapper.readValue(jsonWarehouse, Warehouse.class);
        warehouseDAOImp.addWarehouse(warehouse);


        //resp.setContentType("text/html");
        //PrintWriter printWriter = resp.getWriter();
        //printWriter.write("add!");
        //printWriter.close();
    }
}
