/*
 * User.java
 */
package com.mycompany.bookstore;

/**
 * Classe que representa um usuário na livraria.
 */
public class User {

    /**
     * Nome de usuário do usuário.
     */
    private final String username;

    /**
     * Nome real do usuário.
     */
    private String name;

    /**
     * Endereço do usuário.
     */
    private String adress;

    /**
     * Construtor que inicializa um usuário com nome de usuário, nome real e
     * endereço.
     *
     * @param username Nome de usuário do usuário.
     * @param name Nome real do usuário.
     * @param adress Endereço do usuário.
     */
    public User(String username, String name, String adress) {
        this.username = username;
        this.name = name;
        this.adress = adress;
    }

    /**
     * Define o nome real do usuário.
     *
     * @param name Nome real do usuário.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Define o endereço do usuário.
     *
     * @param adress Endereço do usuário.
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Obtém o nome de usuário do usuário.
     *
     * @return Nome de usuário do usuário.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Obtém o nome real do usuário.
     *
     * @return Nome real do usuário.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtém o endereço do usuário.
     *
     * @return Endereço do usuário.
     */
    public String getAdress() {
        return adress;
    }
}
