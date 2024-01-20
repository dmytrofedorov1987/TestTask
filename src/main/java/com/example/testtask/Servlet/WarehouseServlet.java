package com.example.testtask.Servlet;

import com.example.testtask.jdbcDAO.WarehouseDAOImp;
import com.example.testtask.model.Warehouse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet("/warehouse")
public class WarehouseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WarehouseDAOImp warehouseDAOImp = new WarehouseDAOImp();
        String jsonWarehouse = req.getReader().lines().collect(Collectors.joining("\n"));
        ObjectMapper objectMapper = new ObjectMapper();
        Warehouse warehouse = objectMapper.readValue(jsonWarehouse, Warehouse.class);
        warehouseDAOImp.addWarehouse(warehouse);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WarehouseDAOImp warehouseDAOImp = new WarehouseDAOImp();
        int id = Integer.parseInt(req.getParameter("id"));
        warehouseDAOImp.deleteWarehouse(id);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WarehouseDAOImp warehouseDAOImp = new WarehouseDAOImp();
        int id = Integer.parseInt(req.getParameter("id"));
        Warehouse warehouse = warehouseDAOImp.getWarehouse(id);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(warehouse);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.print(json);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WarehouseDAOImp warehouseDAOImp = new WarehouseDAOImp();
        int id = Integer.parseInt(req.getParameter("id"));
        String jsonWarehouse = req.getReader().lines().collect(Collectors.joining("\n"));
        ObjectMapper objectMapper = new ObjectMapper();
        Warehouse warehouse = objectMapper.readValue(jsonWarehouse, Warehouse.class);
        warehouseDAOImp.updateWarehouse(warehouse, id);
    }

}
