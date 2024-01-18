package com.example.testtask;

public interface WarehouseDAO {
    void createTable();

    void addWarehouse(Warehouse warehouse);

    void updateWarehouse(Warehouse warehouse);

    void deleteWarehouse(int id);

    Warehouse getWarehouse(int id);

}
