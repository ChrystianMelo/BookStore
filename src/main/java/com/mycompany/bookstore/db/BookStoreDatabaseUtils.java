package com.mycompany.bookstore.db;

import com.mycompany.bookstore.Book;
import com.mycompany.bookstore.BookStore;
import com.mycompany.bookstore.Customer;
import com.mycompany.bookstore.Supplier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class BookStoreDatabaseUtils {

    private static final String CUSTOMER_FILE = "/costumer.txt";
    private static final String SUPPLIER_FILE = "/supplier.txt";

    public static void clearCache() throws URISyntaxException, IOException {
        File file = new File(BookStoreDatabaseUtils.class.getResource(CUSTOMER_FILE).toURI());
        file.delete();
        file.createNewFile();

        file = new File(BookStoreDatabaseUtils.class.getResource(SUPPLIER_FILE).toURI());
        file.delete();
        file.createNewFile();

    }

    public static BookStore readBookStore() throws URISyntaxException {
        return new BookStore(readCustomers(), readSuppliers());
    }

    public static void writeBookStore(BookStore bookStore) throws URISyntaxException {
        writeCustomers(bookStore.getCostumers());
        writeSuppliers(bookStore.getSuppliers());
    }

    public static ArrayList<Customer> readCustomers() throws URISyntaxException {
        ArrayList<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(BookStoreDatabaseUtils.class.getResource(CUSTOMER_FILE).toURI())))) {
            String line;
            Customer currentCustomer = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String username = data[0];
                    String name = data[1];
                    String address = data[2]; // Pode precisar de conversão para Address
                    currentCustomer = new Customer(username, name, address);
                    customers.add(currentCustomer);
                } else if (currentCustomer != null) {
                    String type = data[0];
                    int id = Integer.parseInt(data[1]);
                    String bookName = data[2];
                    float value = Float.parseFloat(data[3]);
                    String details = data[4];
                    Book book = new Book(id, bookName, value, details);
                    if (type.equals("FAV")) {
                        currentCustomer.addFavorite(book);
                    } else if (type.equals("CART")) {
                        try {
                            currentCustomer.addToCart(book);
                        } catch (Exception ex) {
                            System.out.println("ERROR");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static ArrayList<Supplier> readSuppliers() throws URISyntaxException {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(BookStoreDatabaseUtils.class.getResource(SUPPLIER_FILE).toURI())))) {
            String line;
            Supplier currentSupplier = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String username = data[0];
                    String name = data[1];
                    String address = data[2]; // Pode precisar de conversão para Address
                    currentSupplier = new Supplier(username, name, address);
                    suppliers.add(currentSupplier);
                } else if (currentSupplier != null) {
                    String type = data[0];
                    int id = Integer.parseInt(data[1]);
                    String bookName = data[2];
                    float value = Float.parseFloat(data[3]);
                    String details = data[4];
                    int quantity = Integer.parseInt(data[5]);
                    Book book = new Book(id, bookName, value, details);
                    if (type.equals("STOCK")) {
                        try {
                            currentSupplier.registerBook(book, quantity);
                        } catch (Exception ex) {
                            System.out.println("ERROR");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    public static void writeCustomers(ArrayList<Customer> customers) throws URISyntaxException {
        for (Customer customer : customers) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(BookStoreDatabaseUtils.class.getResource(CUSTOMER_FILE).toURI()), true))) {
                writer.write(customer.getUsername() + "," + customer.getName() + "," + customer.getAdress() + "\n");

                // Salvar favoritos
                for (Book book
                        : customer.getFavorites()) {
                    writer.write("FAV," + book.getId() + "," + book.getName() + "," + book.getValue() + "," + book.getDetails() + "\n");
                }

                // Salvar livros no carrinho
                for (Book book
                        : customer.getCart()
                                .getBooks().keySet()) {
                    writer.write("CART," + book.getId() + "," + book.getName() + "," + book.getValue() + "," + book.getDetails() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeSuppliers(ArrayList<Supplier> suppliers) throws URISyntaxException {
        for (Supplier supplier : suppliers) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(BookStoreDatabaseUtils.class.getResource(SUPPLIER_FILE).toURI()), true))) {
                writer.write(supplier.getUsername() + "," + supplier.getName() + "," + supplier.getAdress() + "\n");

                // Salvar estoque
                for (HashMap.Entry<Book, Integer> entry : supplier.getEstoque().entrySet()) {
                    Book book = entry.getKey();
                    int quantity = entry.getValue();
                    writer.write("STOCK," + book.getId() + "," + book.getName() + "," + book.getValue() + "," + book.getDetails() + "," + quantity + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
