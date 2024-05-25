/*
 * Cart.java
 */
package com.mycompany.bookstore;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa um carrinho de compras.
 */
public class Cart {

    /**
     * Lista de livros no carrinho e suas respectivas quantidades.
     */
    HashMap<Book, Integer> books;

    /**
     * Construtor padrão que inicializa o carrinho como vazio.
     */
    public Cart() {
        books = new HashMap<>();
    }

    /**
     * Retorn a lista de livros no carrinho e suas respectivas quantidades.
     */
    public HashMap<Book, Integer> getBooks() {
        return books;
    }

    /**
     * Adiciona um livro ao carrinho com a quantidade especificada.
     *
     * @param book O livro a ser adicionado.
     * @param quantity A quantidade do livro a ser adicionada.
     */
    public void addItem(Book book, int quantity) throws Exception {
        if (quantity <= 0) {
            throw new Exception("Negative or null quantity.");
        }

        int finalQuantity = quantity;

        if (books.containsKey(book)) {
            finalQuantity += books.get(book);
        }

        books.put(book, finalQuantity);
    }

    /**
     * Remove um livro do carrinho com a quantidade especificada.
     *
     * @param book O livro a ser removido.
     * @param quantity A quantidade do livro a ser removida.
     * @throws Exception Se o livro não estiver no carrinho.
     */
    public void removeBook(Book book, int quantity) throws Exception {
        if (!books.containsKey(book)) {
            throw new Exception("This book is not in the cart");
        }

        int quantityInStock = books.get(book);
        if (quantityInStock < quantity) {
            throw new Exception("The existant quantity is lower than that.");
        } else if (quantityInStock == quantity) {
            books.remove(book);
        } else {
            books.remove(book);
            books.put(book, quantityInStock - quantity);
        }
    }

    /**
     * Permite finalizar a compra dos livros presentes no carrinho.
     */
    public void checkOut() throws Exception {
        // (pendente) Efetivar a compra.
        if (isEmpty()) {
            throw new Exception("Carrinho vazio.");
        }

        emptyCart();
    }

    public int getTotal() {
        int total = 0;

        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            total += entry.getKey().getValue() * entry.getValue();
        }

        return total;
    }

    /**
     * Esvazia o carrinho de compras.
     */
    public void emptyCart() {
        books = new HashMap<>();
    }

    /**
     * Esvazia o carrinho de compras.
     */
    public boolean isEmpty() {
        return books.isEmpty();
    }
}
