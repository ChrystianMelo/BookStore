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
    public Product() {
        id = -1;
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
    public void show() {
        frame.setVisible(true);
    }
}
