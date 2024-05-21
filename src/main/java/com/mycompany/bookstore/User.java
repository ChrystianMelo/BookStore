/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore;

/**
 *
 */
public class User {

    /**
     *
     */
    private final String username;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Address adress;

    /**
     *
     */
    public User(String username, String name, Address adress) {
        this.username = username;
        this.name = name;
        this.adress = adress;
    }

    /**
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public void setAdress(Address adress) {
        this.adress = adress;
    }

    /**
     *
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     */
    public String getName() {
        return name;
    }

    /**
     *
     */
    public Address getAdress() {
        return adress;
    }

}
