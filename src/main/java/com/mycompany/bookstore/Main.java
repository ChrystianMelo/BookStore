/*
 * Main.java
 */
package com.mycompany.bookstore;

import com.mycompany.bookstore.db.BookStoreDatabaseUtils;
import com.mycompany.bookstore.gui.BookStoreGUI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 *
 */
public class Main {

    /**
     *
     */
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Supplier> suppliers = new ArrayList<>();

        try {
            customers = BookStoreDatabaseUtils.readCustomers();
            suppliers = BookStoreDatabaseUtils.readSuppliers();
        } catch (URISyntaxException ex) {
            System.out.println("ERROR");
        }

        BookStore bookStore = new BookStore(customers, suppliers);

        BookStoreGUI gui = new BookStoreGUI(bookStore);
        gui.setVisible(true);
    }
}
