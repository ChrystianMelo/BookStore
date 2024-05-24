/*
 * Customer.java
 */
package com.mycompany.bookstore;

import java.util.ArrayList;

/**
 * Classe que representa um cliente na livraria, que também é um usuário.
 */
public class Customer extends User {

    /**
     * Carrinho de compras do cliente.
     */
    private final Cart cart;

    /**
     * Lista de livros favoritos do cliente.
     */
    private final ArrayList<Book> favorites;

    /**
     * Construtor que inicializa um cliente com nome de usuário, nome e
     * endereço, e inicializa o carrinho e a lista de favoritos como vazios.
     *
     * @param username Nome de usuário do cliente.
     * @param name Nome do cliente.
     * @param adress Endereço do cliente.
     */
    public Customer(String username, String name, Address adress) {
        super(username, name, adress);
        this.cart = new Cart();
        this.favorites = new ArrayList<>();
    }

    /**
     * Construtor que inicializa um cliente com nome de usuário, nome, endereço,
     * carrinho e lista de favoritos especificados.
     *
     * @param username Nome de usuário do cliente.
     * @param name Nome do cliente.
     * @param adress Endereço do cliente.
     * @param cart Carrinho do cliente.
     * @param favorites Lista de livros favoritos do cliente.
     */
    public Customer(String username, String name, Address adress, Cart cart, ArrayList<Book> favorites) {
        super(username, name, adress);
        this.cart = cart;
        this.favorites = favorites;
    }

    /**
     * Obtém o carrinho de compras do cliente.
     *
     * @return Carrinho de compras do cliente.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Obtém a lista de livros favoritos do cliente.
     *
     * @return Lista de livros favoritos do cliente.
     */
    public ArrayList<Book> getFavorites() {
        return favorites;
    }

    /**
     * Adiciona um livro ao carrinho do cliente com a quantidade especificada.
     *
     * @param book O livro a ser adicionado ao carrinho.
     * @param quantity A quantidade do livro a ser adicionada.
     */
    public void addBook(Book book, int quantity) {
        cart.addItem(book, quantity);
    }

    /**
     * Remove um livro do carrinho do cliente com a quantidade especificada.
     *
     * @param book O livro a ser removido do carrinho.
     * @param quantity A quantidade do livro a ser removida.
     * @throws Exception Se o livro não estiver no carrinho.
     */
    public void removeBook(Book book, int quantity) throws Exception {
        cart.removeBook(book, quantity);
    }

    /**
     * Finaliza a compra dos livros no carrinho do cliente.
     */
    public void checkOutCart() {
        cart.checkOut();
    }
}
