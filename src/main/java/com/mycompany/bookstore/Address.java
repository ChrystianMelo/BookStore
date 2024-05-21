/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstore;

/**
 *
 */
public class Address {

    /**
     *
     */
    public String street;

    /**
     *
     */
    public int number;

    /**
     *
     */
    public String neightborhood;

    /**
     *
     */
    public String city;

    /**
     *
     */
    public String state;

    /**
     *
     */
    public String country;

    /**
     *
     */
    public String complement;

    /**
     *
     */
    public Address(
            String street,
            int number,
            String neightborhood,
            String city,
            String state,
            String country,
            String complement) {
        this.street = street;
        this.number = number;
        this.neightborhood = neightborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.complement = complement;
    }
}
