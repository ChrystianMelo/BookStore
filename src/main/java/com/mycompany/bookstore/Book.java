/*
 * Book.java
 */
package com.mycompany.bookstore;

import javax.swing.ImageIcon;

/**
 * Classe que representa um livro.
 */
public class Book {

    /**
     * Contador de ID.
     */
    private static int counter = 0;

    /**
     * Identificador único do livro.
     */
    private int id;

    /**
     * Nome do livro.
     */
    private String name;

    /**
     * Valor do livro.
     */
    private float value;

    /**
     * Detalhes adicionais sobre o livro.
     */
    private String details;

    /**
     * Iniciando vendedor
     */
    private Supplier supplier;

    /**
     *
     */
    private ImageIcon cover;

    /**
     * Construtor padrão que inicializa um livro com valores padrão.
     */
    public Book() {
        id = ++counter;
        details = "Empty";
        name = "Unknown";
        value = -1;
        cover = new javax.swing.ImageIcon(getClass().getResource("/icon50x50.png"));
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
        this.cover = new javax.swing.ImageIcon(getClass().getResource("/icon50x50.png"));;
    }

    /**
     * Construtor que inicializa um livro com valores especificados.
     *
     * @param id Identificador do livro.
     * @param name Nome do livro.
     * @param value Valor do livro.
     * @param details Detalhes do livro.
     * @param cover Capa do livro.
     */
    public Book(int id, String name, float value, String details, ImageIcon cover) {
        this.id = id;
        this.details = details;
        this.name = name;
        this.value = value;
        this.cover = cover;
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

    /**
     *
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     *
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     *
     */
    public ImageIcon getCover() {
        return cover;
    }

    /**
     *
     */
    public void setCover(ImageIcon cover) {
        this.cover = cover;
    }

}
