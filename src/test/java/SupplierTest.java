
import com.mycompany.bookstore.Book;
import com.mycompany.bookstore.InsufficientStockException;
import com.mycompany.bookstore.Supplier;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SupplierTest {

    private Supplier supplier;
    private String address;

    @BeforeEach
    public void setUp() {
        address = "Street" + "Neighborhood" + "City" + "State" + "Country" + "Complement";
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
        try {
            supplier.registerBook(book, 10);
        } catch (Exception ex) {
            fail();
        }
        assertEquals(10, (int) supplier.getEstoque().get(book));
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        try {
            supplier.registerBook(book, 10);
        } catch (Exception ex) {
            fail();
        }
        supplier.deleteBook(book);
        assertTrue(supplier.getEstoque().isEmpty());
    }

    @Test
    public void testDeleteBookWithQuantity() throws InsufficientStockException {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        try {
            supplier.registerBook(book, 10);
        } catch (Exception ex) {
            fail();
        }
        supplier.deleteBook(book, 5);
        assertEquals(5, (int) supplier.getEstoque().get(book));
    }

    @Test
    public void testDeleteBookWithInsufficientStock() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        try {
            supplier.registerBook(book, 5);
        } catch (Exception ex) {
            fail();
        }
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
        try {
            supplier.registerBook(book, 10);
        } catch (Exception ex) {
            fail();
        }

        assertTrue(supplier.getEstoque().containsKey(book));
        supplier.deleteBook(book);
        assertTrue(supplier.getEstoque().isEmpty());
    }

    @Test
    public void testGetEstoque() {
        Book book1 = new Book(1, "Test Book 1", 19.99f, "Test Details 1");
        Book book2 = new Book(2, "Test Book 2", 29.99f, "Test Details 2");

        try {
            supplier.registerBook(book1, 5);
            supplier.registerBook(book2, 10);

        } catch (Exception ex) {
            fail();
        }
        HashMap<Book, Integer> estoque = supplier.getEstoque();
        assertEquals(2, estoque.size());
        assertEquals(5, (int) estoque.get(book1));
        assertEquals(10, (int) estoque.get(book2));
    }

    @Test
    public void testUpdateBookQuantity() throws InsufficientStockException {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        try {
            supplier.registerBook(book, 5);
            supplier.registerBook(book, 5);

        } catch (Exception ex) {
            fail();
        }
        assertEquals(10, (int) supplier.getEstoque().get(book));
    }

    @Test
    public void testUpdateBookQuantityWithNegativeValue() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        try {
            supplier.registerBook(book, 5);

        } catch (Exception ex) {
            fail();
        }
        assertThrows(Exception.class, () -> {
            supplier.registerBook(book, -10);
        });
    }

    @Test
    public void test48() {
    }

    @Test
    public void test49() {
    }

    public void test50() {
    }
}
