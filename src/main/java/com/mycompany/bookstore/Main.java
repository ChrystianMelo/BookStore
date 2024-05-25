/*
 * Main.java
 */
package com.mycompany.bookstore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class Main {

    /**
     *
     */
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();

        boolean finish = false;
        while (!finish) {
            System.out.println("-------------------------------------------------");
            System.out.println("Você deseja rodar como Cliente ou Vendedor.\n \t1-Cliente 2-Vendedor");

            Scanner ler = new Scanner(System.in);
            int option = ler.nextInt();
            switch (option) {
                case 1:
                    runAsClient(bookStore);
                    break;
                case 2:
                    runAsSupplier(bookStore);
                    break;
                default:
                    System.out.println("ERROR");
                    finish = true;
                    break;
            }
        }
    }

    /**
     *
     */
    private static void runAsClient(BookStore bookStore) {
        System.out.println("---------------------Cadastro/Login----------------------------");
        System.out.println("Digite seu username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();

        Customer costumer = (Customer) retrieveUser(bookStore, username);
        if (costumer == null) {
            System.out.println("---------------------Cadastro----------------------------");
            Address address = new Address("Street", 123, "Neighborhood", "City", "State", "Country", "Complement");
            costumer = new Customer(username, "Costumer Name", address);
            try {
                bookStore.addCostumer(costumer);
            } catch (Exception ex) {
                System.out.println("ERROR");
            }
        }

        HashMap<Book, Integer> availableBooks = bookStore.getAvailableBooks();
        print(availableBooks);

        System.out.println("-------------------------------------------------");
        System.out.println("\t1-Adiciona libro ao carrinho \t2-Ver carrinho");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("-------------------------------------------------");
                System.out.println("Diga o indice do livro que vc quer comprar e a quantidade?");
                int bookID = scanner.nextInt();
                int quantity = scanner.nextInt();

                Book requested = (Book) availableBooks.keySet().toArray()[bookID - 1];

                try {
                    costumer.addBook(requested, quantity);
                } catch (Exception ex) {
                    System.out.println("ERROR");
                }

                break;

            case 2:
                print(costumer.getCart().getBooks());
                break;
            default:
                break;
        }
    }

    /**
     *
     */
    private static void runAsSupplier(BookStore bookStore) {
        System.out.println("---------------------Cadastro/Login----------------------------");
        System.out.println("Digite seu username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();

        Supplier supplier = (Supplier) retrieveUser(bookStore, username);
        if (supplier == null) {
            System.out.println("---------------------Cadastro----------------------------");
            Address address = new Address("Street", 123, "Neighborhood", "City", "State", "Country", "Complement");
            supplier = new Supplier(username, "Supplier Name", address);
            try {
                bookStore.addSupplier(supplier);
            } catch (Exception ex) {
                System.out.println("ERROR");
            }
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Vc quer adicionar ou remover um livro? \n\t1-Adicionar  2-Remover");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Qual o nome do livro?");
                String name = scanner.next();
                Book book = new Book(1, name, 19.99f, "Details");
                System.out.println("Qual a quantidade disponivel?");
                int quantity = scanner.nextInt();

                try {
                    supplier.registerBook(book, quantity);
                } catch (Exception ex) {
                    System.out.println("ERORR");
                }

                break;

            case 2:
                System.out.println("Qual o nome do livro?");
                name = scanner.next();

                book = null;
                for (Book b : supplier.getEstoque().keySet()) {
                    if (name.equals(b.getName())) {
                        book = b;
                    }
                }

                supplier.deleteBook(book);
                break;
            default:
                break;
        }
    }

    private static User retrieveUser(BookStore bookStore, String username) {
        User user = null;

        for (User u : bookStore.getCostumers()) {
            if (username.equals(u.getUsername())) {
                user = u;
                break;
            }
        }

        return user;
    }

    private static void print(HashMap<Book, Integer> books) {
        System.out.println("-------------------------------------------------");
        int count = 0;
        Iterator it = books.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Book book = (Book) entry.getKey();
            count++;
            System.out.println((count) + " : " + book.getName() + " (" + entry.getValue() + ") " + "\t R$" + book.getValue());
        }
    }
}
