/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore;

import java.util.ArrayList;

/**
 *
 */
class Product {

    /**
     *
     */
    int id;

    /**
     *
     */
    String details;

    /**
     *
     */
    public Product() {
        id = -1;
        details = "Vazia!";
    }

    /**
     *
     */
    public String getDetails() {
        return details;
    }

    /**
     *
     */
    public void setDetails(String details) {
        this.details = details;
    }
}

/**
 *
 */
class Cart {

    /**
     *
     */
    ArrayList<Product> itens;

    /**
     *
     */
    public Cart() {
        itens = new ArrayList<>();
    }
}

/**
 *
 */
public class BookStore {

    /**
     *
     */
    private ArrayList<Costumer> costumers;

    /**
     *
     */
    private ArrayList<Supplier> suppliers;

    /**
     *
     */
    public BookStore() {
        costumers = new ArrayList<>();
        suppliers = new ArrayList<>();
    }

    /**
     *
     */
    public BookStore(ArrayList<Costumer> costumers, ArrayList<Supplier> suppliers) {
        this.costumers = costumers;
        this.suppliers = suppliers;
    }

    /**
     *
     */
    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    /**
     *
     */
    public void setCostumers(ArrayList<Costumer> costumers) {
        this.costumers = costumers;
    }

    /**
     *
     */
    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    /**
     *
     */
    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public ArrayList<Product> getAvailableProducts() {
        return null;
    }

    public void viewAvailableProducts() {

    }
}
