/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore;

/**
 *
 */
public class Costumer extends User {

    /**
     *
     */
    private final Cart cart;

    /**
     *
     */
    public Cart getCart() {
        return cart;
    }

    /**
     *
     */
    public Costumer(String username, String name, Address adress) {
        super(username, name, adress);
        this.cart = new Cart();
    }

    /**
     *
     */
    public Costumer(String username, String name, Address adress, Cart card) {
        super(username, name, adress);
        this.cart = new Cart();
    }
}
