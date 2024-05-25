import com.mycompany.bookstore.Address;
import com.mycompany.bookstore.Book;
import com.mycompany.bookstore.InsufficientStockException;
import com.mycompany.bookstore.Supplier;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class SupplierTest {

    private Supplier supplier;
    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address("Street", 123, "Neighborhood", "City", "State", "Country", "Complement");
        supplier = new Supplier("username", "Supplier Name", address);
    }

    @Test
    public void testSupplierCreation() {
        assertEquals("username", supplier.getUsername());
        assertEquals("Supplier Name", supplier.getName());
        assertEquals(address, supplier.getAdress());
        assertTrue(supplier.getEstoque().isEmpty());
    }

    @Test
    public void testRegisterBook() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        supplier.registerBook(book, 10);
        assertEquals(10, (int) supplier.getEstoque().get(book));
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        supplier.registerBook(book, 10);
        supplier.deleteBook(book);
        assertTrue(supplier.getEstoque().isEmpty());
    }

    @Test
    public void testDeleteBookWithQuantity() throws InsufficientStockException {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        supplier.registerBook(book, 10);
        supplier.deleteBook(book, 5);
        assertEquals(5, (int) supplier.getEstoque().get(book));
    }

    @Test
    public void testDeleteBookWithInsufficientStock() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        supplier.registerBook(book, 5);
        assertThrows(InsufficientStockException.class, () -> {
            supplier.deleteBook(book, 10);
        });
    }

    @Test
    public void testDeleteBookNotInStock() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        assertThrows(InsufficientStockException.class, () -> {
            supplier.deleteBook(book, 1);
        });
    }

    @Test
    public void testContainsBook() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        supplier.registerBook(book, 10);
        assertTrue(supplier.getEstoque().containsKey(book));
        supplier.deleteBook(book);
        assertTrue(supplier.getEstoque().isEmpty());
    }

    @Test
    public void testGetEstoque() {
        Book book1 = new Book(1, "Test Book 1", 19.99f, "Test Details 1");
        Book book2 = new Book(2, "Test Book 2", 29.99f, "Test Details 2");
        supplier.registerBook(book1, 5);
        supplier.registerBook(book2, 10);
        HashMap<Book, Integer> estoque = supplier.getEstoque();
        assertEquals(2, estoque.size());
        assertEquals(5, (int) estoque.get(book1));
        assertEquals(10, (int) estoque.get(book2));
    }
}
