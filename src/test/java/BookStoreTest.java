/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.bookstore.BookStore;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Chrystian Melo
 */
public class BookStoreTest {

    BookStore bookStore;

    public BookStoreTest() {
        bookStore = new BookStore();
    }

    @Test
    public void testSuppliersCount() {
        assert (bookStore.getAvailableProducts() == null);
    }
}
