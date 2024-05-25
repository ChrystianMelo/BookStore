/*
 * BookStore.java
 */
package com.mycompany.bookstore;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que representa uma livraria.
 */
public class BookStore {

    /**
     * Lista de clientes da livraria.
     */
    private ArrayList<Customer> costumers;

    /**
     * Lista de fornecedores da livraria.
     */
    private ArrayList<Supplier> suppliers;

    /**
     * Construtor padrão que inicializa as listas de clientes e fornecedores
     * como vazias.
     */
    public BookStore() {
        costumers = new ArrayList<>();
        suppliers = new ArrayList<>();
    }

    /**
     * Construtor que inicializa a livraria com listas de clientes e
     * fornecedores especificadas.
     *
     * @param costumers Lista de clientes.
     * @param suppliers Lista de fornecedores.
     */
    public BookStore(ArrayList<Customer> costumers, ArrayList<Supplier> suppliers) {
        this.costumers = costumers;
        this.suppliers = suppliers;
    }

    /**
     * Obtém a lista de clientes da livraria.
     *
     * @return Lista de clientes.
     */
    public ArrayList<Customer> getCostumers() {
        return costumers;
    }

    /**
     * Adicione clientes a livraria.
     */
    public void addCostumer(Customer costumer) throws Exception {
        if (costumers.contains(costumer)) {
            throw new Exception("Already exists.");
        }

        for (Customer c : costumers) {
            if (c.getUsername().equals(costumer.getUsername())) {
                throw new Exception("Invalid username.");
            }
        }
        costumers.add(costumer);
    }

    /**
     * Define a lista de clientes da livraria.
     *
     * @param costumers Lista de clientes.
     */
    public void setCostumers(ArrayList<Customer> costumers) {
        this.costumers = costumers;
    }

    /**
     * Obtém a lista de fornecedores da livraria.
     *
     * @return Lista de fornecedores.
     */
    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    /**
     * Adicione vendedor a livraria.
     */
    public void addSupplier(Supplier c) {
        suppliers.add(c);
    }

    /**
     * Define a lista de fornecedores da livraria.
     *
     * @param suppliers Lista de fornecedores.
     */
    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    /**
     * Obtém a lista de livros disponíveis na livraria, combinando os estoques
     * de todos os fornecedores.
     *
     * @return Relação de livros disponíveis e suas respectivas quantidades.
     */
    public HashMap<Book, Integer> getAvailableBooks() {
        HashMap<Book, Integer> availableBooks = new HashMap<>();

        suppliers.forEach((Supplier s) -> {
            availableBooks.putAll(s.getEstoque());
        });

        return availableBooks;
    }
}
