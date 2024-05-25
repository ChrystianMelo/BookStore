
import com.mycompany.bookstore.Book;
import com.mycompany.bookstore.BookStore;
import com.mycompany.bookstore.Customer;
import com.mycompany.bookstore.Supplier;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookStoreTest {

    BookStore bookStore;

    @BeforeEach
    public void setUp() {
        bookStore = new BookStore();
    }

    @Test
    public void testEmptyAvailableBooks() {
        assertTrue(bookStore.getAvailableBooks().isEmpty());
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer("test_customer", "Test Customer", null);
        bookStore.addCostumer(customer);
        assertTrue(bookStore.getCostumers().contains(customer));
    }

    @Test
    public void testAddSupplier() {
        Supplier supplier = new Supplier("test_supplier", "Test Supplier", null);
        bookStore.addSupplier(supplier);
        assertTrue(bookStore.getSuppliers().contains(supplier));
    }

    @Test
    public void testSetCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("customer1", "Customer 1", null));
        customers.add(new Customer("customer2", "Customer 2", null));
        bookStore.setCostumers(customers);
        assertEquals(customers, bookStore.getCostumers());
    }

    @Test
    public void testSetSuppliers() {
        ArrayList<Supplier> suppliers = new ArrayList<>();
        suppliers.add(new Supplier("supplier1", "Supplier 1", null));
        suppliers.add(new Supplier("supplier2", "Supplier 2", null));
        bookStore.setSuppliers(suppliers);
        assertEquals(suppliers, bookStore.getSuppliers());
    }

    @Test
    public void testGetAvailableBooks() {
        Supplier supplier1 = new Supplier("supplier1", "Supplier 1", null);
        Supplier supplier2 = new Supplier("supplier2", "Supplier 2", null);

        supplier1.registerBook(new Book(1, "Book 1", 10.0f, "Details"), 5);
        supplier1.registerBook(new Book(2, "Book 2", 15.0f, "Details"), 3);
        supplier2.registerBook(new Book(3, "Book 3", 20.0f, "Details"), 7);

        bookStore.addSupplier(supplier1);
        bookStore.addSupplier(supplier2);

        HashMap<Book, Integer> expectedAvailableBooks = new HashMap<>();
        expectedAvailableBooks.put(new Book(1, "Book 1", 10.0f, "Details"), 5);
        expectedAvailableBooks.put(new Book(2, "Book 2", 15.0f, "Details"), 3);
        expectedAvailableBooks.put(new Book(3, "Book 3", 20.0f, "Details"), 7);

        assertTrue(bookStore.getAvailableBooks().keySet().containsAll(expectedAvailableBooks.keySet()));
    }
}
