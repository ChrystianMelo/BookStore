/*
 * Book.java
 */
package com.mycompany.bookstore;

/**
 * Classe que representa um livro.
 */
public class Book {

    /**
     * Identificador único do livro.
     */
    int id;

    /**
     * Nome do livro.
     */
    String name;

    /**
     * Valor do livro.
     */
    float value;

    /**
     * Detalhes adicionais sobre o livro.
     */
    String details;

    /**
     * Construtor padrão que inicializa um livro com valores padrão.
     */
    public Book() {
        id = -1;
        details = "Empty";
        name = "Unknown";
        value = -1;
    }

    /**
     * Construtor que inicializa um livro com valores especificados.
     *
     * @param id Identificador do livro.
     * @param name Nome do livro.
     * @param value Valor do livro.
     * @param details Detalhes do livro.
     */
    public Book(int id, String name, float value, String details) {
        this.id = id;
        this.details = details;
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        return id == ((Book) obj).id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Obtém o identificador do livro.
     *
     * @return Identificador do livro.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o nome do livro.
     *
     * @return Nome do livro.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do livro.
     *
     * @param name Nome do livro.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o valor do livro.
     *
     * @return Valor do livro.
     */
    public float getValue() {
        return value;
    }

    /**
     * Define o valor do livro.
     *
     * @param value Valor do livro.
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * Obtém os detalhes do livro.
     *
     * @return Detalhes do livro.
     */
    public String getDetails() {
        return details;
    }

    /**
     * Define os detalhes do livro.
     *
     * @param details Detalhes do livro.
     */
    public void setDetails(String details) {
        this.details = details;
    }
}
