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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        WarehouseDAOImp warehouseDAOImp = new WarehouseDAOImp();
        //Warehouse warehouse = new Warehouse(1,"fff", "ffdfd","eee", "ttt", "jjhjhj", " d ", 111);
        Warehouse warehouse = warehouseDAOImp.getWarehouse(1);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(warehouse);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        //resp.setCharacterEncoding("UTF-8");
        out.print(json);
    }
}
