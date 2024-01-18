package com.example.testtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteWarehouseServlet extends HttpServlet {
    static WarehouseDAOImp warehouseDAOImp;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //int id = Integer.parseInt(req.getParameter("id"));
        //warehouseDAOImp.deleteWarehouse(id);

    }
}
