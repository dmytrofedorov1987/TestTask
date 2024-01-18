package com.example.testtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")

public class UpdateWarehouseServlet extends HttpServlet {
    static WarehouseDAOImp warehouseDAOImp;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonWarehouse = req.getParameter("Warehouse");
        ObjectMapper objectMapper = new ObjectMapper();
        Warehouse warehouse = objectMapper.readValue(jsonWarehouse, Warehouse.class);
        warehouseDAOImp.updateWarehouse(warehouse);
    }

}
