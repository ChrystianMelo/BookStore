/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore;

import java.util.ArrayList;
import javax.swing.*;

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
    private JFrame frame;

    /**
     *
     */
    public BookStore() {
        frame = new JFrame("Sistema de Venda de Livros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
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

    /**
     *
     */
    public void show() {
        frame.setVisible(true);
    }

    public ArrayList<Product> getAvailableProducts() {
        return null;
    }

    public void viewAvailableProducts() {

    }
}
