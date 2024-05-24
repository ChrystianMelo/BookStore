/*
 * Supplier.java
 */
package com.mycompany.bookstore;

import java.util.HashMap;

/**
 * Classe que representa um fornecedor na livraria, que também é um usuário.
 */
public class Supplier extends User {

    /**
     * Lista de livros em estoque e suas respectivas quantidades.
     */
    private final HashMap<Book, Integer> estoque;

    /**
     * Construtor que inicializa um fornecedor com nome de usuário, nome e
     * endereço, e inicializa o estoque como uma lista vazia.
     *
     * @param username Nome de usuário do fornecedor.
     * @param name Nome do fornecedor.
     * @param adress Endereço do fornecedor.
     */
    public Supplier(String username, String name, Address adress) {
        super(username, name, adress);
        estoque = new HashMap<>();
    }

    /**
     * Construtor que inicializa um fornecedor com nome de usuário, nome,
     * endereço e um estoque inicial.
     *
     * @param username Nome de usuário do fornecedor.
     * @param name Nome do fornecedor.
     * @param adress Endereço do fornecedor.
     * @param estoque Estoque inicial do fornecedor.
     */
    public Supplier(String username, String name, Address adress, HashMap<Book, Integer> estoque) {
        super(username, name, adress);
        this.estoque = estoque;
    }

    /**
     * Obtém a lista de livros em estoque e suas respectivas quantidades.
     *
     * @return Lista de livros em estoque.
     */
    public HashMap<Book, Integer> getEstoque() {
        return estoque;
    }

    /**
     * Registra um novo livro no estoque com a quantidade especificada.
     *
     * @param book O livro a ser adicionado ao estoque.
     * @param quantity A quantidade do livro a ser adicionada.
     */
    public void registerBook(Book book, int quantity) {
        estoque.put(book, quantity);
    }

    /**
     * Remove um livro do estoque com a quantidade especificada.
     *
     * @param book O livro a ser removido do estoque.
     */
    public void deleteBook(Book book) {
        estoque.remove(book);
    }

}
