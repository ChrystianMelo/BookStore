/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.bookstore.BookStore;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Chrystian Melo
 */
public class BookStoreTest {

    BookStore bookStore;

    @BeforeEach
    public void setUp() {
        bookStore = new BookStore();
    }

    @Test
    public void testSuppliersCount() {
        assertTrue(bookStore.getAvailableBooks().isEmpty());
    }
}
