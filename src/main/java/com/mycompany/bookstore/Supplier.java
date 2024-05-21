/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

/**
 *
 */
public class Supplier extends User {

    /**
     *
     */
    private final ArrayList<SimpleEntry<Product, Integer>> estoque;

    /**
     *
     */
    public ArrayList<SimpleEntry<Product, Integer>> getEstoque() {
        return estoque;
    }

    /**
     *
     */
    public Supplier(String username, String name, Address adress) {
        super(username, name, adress);
        estoque = new ArrayList<>();
    }

    /**
     *
     */
    public Supplier(String username, String name, Address adress, ArrayList<SimpleEntry<Product, Integer>> estoque) {
        super(username, name, adress);
        this.estoque = estoque;
    }

    /**
     *
     */
    public void registerProduct(Product product, int quantity) {

    }

    /**
     *
     */
    public void deleteProduct(Product book, int quantity) {

    }

}
