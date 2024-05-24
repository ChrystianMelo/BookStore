/*
 * Address.java
 */
package com.mycompany.bookstore;

/**
 * A classe Address representa um endereço com informações detalhadas sobre a
 * rua, número, bairro, cidade, estado, país e complemento.
 */
public class Address {

    /**
     * A rua do endereço.
     */
    public String street;

    /**
     * O número do endereço.
     */
    public int number;

    /**
     * O bairro do endereço.
     */
    public String neightborhood;

    /**
     * A cidade do endereço.
     */
    public String city;

    /**
     * O estado do endereço.
     */
    public String state;

    /**
     * O país do endereço.
     */
    public String country;

    /**
     * Um complemento adicional para o endereço.
     */
    public String complement;

    /**
     * Construtor da classe Address que inicializa todos os campos.
     *
     * @param street A rua do endereço.
     * @param number O número do endereço.
     * @param neightborhood O bairro do endereço.
     * @param city A cidade do endereço.
     * @param state O estado do endereço.
     * @param country O país do endereço.
     * @param complement Um complemento adicional para o endereço.
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
