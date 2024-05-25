
import com.mycompany.bookstore.Address;
import com.mycompany.bookstore.Book;
import com.mycompany.bookstore.InsufficientStockException;
import com.mycompany.bookstore.Supplier;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SupplierTest {

    private Supplier supplier;

    @BeforeEach
    public void setUp() {
        Address address = new Address("Street", 123, "Neighborhood", "City", "State", "Country", "Complement");
        supplier = new Supplier("username", "Supplier Name", address);
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");

        supplier.registerBook(book, 10);
        supplier.deleteBook(book);

        assertTrue(supplier.getEstoque().isEmpty());
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
    public void testDeleteBookNotInStock() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");

        assertThrows(InsufficientStockException.class, () -> {
            supplier.deleteBook(book,1);
        });
    }

    

}
