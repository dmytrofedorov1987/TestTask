package com.example.testtask;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Warehouse {
    private int id;
    private String name;
    private String address_line_1;
    private String address_line_2;
    private String city;
    private String state;
    private String country;
    private int inventory_quantity;
/*
    @JsonCreator
    public Warehouse(//@JsonProperty int id,
                     @JsonProperty String name,
                     @JsonProperty String address_line_1,
                     @JsonProperty String address_line_2,
                     @JsonProperty String city,
                     @JsonProperty String state,
                     @JsonProperty String country,
                     @JsonProperty int inventory_quantity) {
        //this.id = id;
        this.name = name;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.inventory_quantity = inventory_quantity;
    }

 */

    public Warehouse(int id, String name, String address_line_1, String address_line_2, String city, String state, String country, int inventory_quantity) {
        this.id = id;
        this.name = name;
        this.address_line_1 = address_line_1;
        this.address_line_2 = address_line_2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.inventory_quantity = inventory_quantity;
    }

    public Warehouse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getInventory_quantity() {
        return inventory_quantity;
    }

    public void setInventory_quantity(int inventory_quantity) {
        this.inventory_quantity = inventory_quantity;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address_line_1='" + address_line_1 + '\'' +
                ", address_line_2='" + address_line_2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", inventory_quantity=" + inventory_quantity +
                '}';
    }
}
