package com.example.testtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/add")
public class AddWarehouseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WarehouseDAOImp warehouseDAOImp = new WarehouseDAOImp();
        String jsonWarehouse = req.getReader().lines().collect(Collectors.joining("\n"));
        ObjectMapper objectMapper = new ObjectMapper();
        Warehouse warehouse = objectMapper.readValue(jsonWarehouse, Warehouse.class);
        warehouseDAOImp.addWarehouse(warehouse);
    }

}
