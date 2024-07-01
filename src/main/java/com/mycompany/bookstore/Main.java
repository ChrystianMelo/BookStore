/*
 * Main.java
 */
package com.mycompany.bookstore;

import com.mycompany.bookstore.db.BookStoreDatabaseUtils;
import com.mycompany.bookstore.gui.BookStoreGUI;

/**
 *
 */
public class Main {

    /**
     *
     */
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();

        BookStoreGUI gui = new BookStoreGUI(bookStore);
        gui.setVisible(true);
    }
}
