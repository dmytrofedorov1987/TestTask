package com.example.testtask.DAO;

import com.example.testtask.model.Warehouse;

public interface WarehouseDAO {
    void createTable();

    void addWarehouse(Warehouse warehouse);

    void updateWarehouse(Warehouse warehouse, int id);

    void deleteWarehouse(int id);

    Warehouse getWarehouse(int id);

}
