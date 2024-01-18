package com.example.testtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get")
public class GetWarehouseServlet extends HttpServlet {
    static WarehouseDAOImp warehouseDAOImp;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Warehouse warehouse = warehouseDAOImp.getWarehouse(id);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(warehouse);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.print(json);
    }

}
