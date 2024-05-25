
import com.mycompany.bookstore.Book;
import com.mycompany.bookstore.BookStore;
import com.mycompany.bookstore.Customer;
import com.mycompany.bookstore.Supplier;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
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
        try {
            bookStore.addCostumer(customer);
        } catch (Exception ex) {
            fail();
        }
        assertTrue(bookStore.getCostumers().contains(customer));
    }

    @Test
    public void testAddCustomerWithSameUsername() {
        Customer customer = new Customer("test_customer", "Test Customer", null);
        try {
            bookStore.addCostumer(customer);
        } catch (Exception ex) {
            fail();
        }
        Customer customer2 = new Customer("test_customer", "Test Customer", null);

        assertThrows(Exception.class, () -> {
            bookStore.addCostumer(customer2);
        });
    }

    @Test
    public void testAddSameCustomer() {
        Customer customer = new Customer("test_customer", "Test Customer", null);
        try {
            bookStore.addCostumer(customer);
        } catch (Exception ex) {
            fail();
        }
        assertThrows(Exception.class, () -> {
            bookStore.addCostumer(customer);
        });
    }

    @Test
    public void testAddSupplier() {
        Supplier supplier = new Supplier("test_supplier", "Test Supplier", null);
        try {
            bookStore.addSupplier(supplier);
        } catch (Exception ex) {
            fail();
        }
        assertTrue(bookStore.getSuppliers().contains(supplier));
    }

    @Test
    public void testAddSupplierWithSameUsername() {
        Supplier customer = new Supplier("test_customer", "Test Customer", null);
        try {
            bookStore.addSupplier(customer);
        } catch (Exception ex) {
            fail();
        }
        Supplier customer2 = new Supplier("test_customer", "Test Customer", null);

        assertThrows(Exception.class, () -> {
            bookStore.addSupplier(customer2);
        });
    }

    @Test
    public void testAddSameSupplier() {
        Supplier customer = new Supplier("test_customer", "Test Customer", null);
        try {
            bookStore.addSupplier(customer);
        } catch (Exception ex) {
            fail();
        }
        assertThrows(Exception.class, () -> {
            bookStore.addSupplier(customer);
        });
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

        try {
            supplier1.registerBook(new Book(1, "Book 1", 10.0f, "Details"), 5);
            supplier1.registerBook(new Book(2, "Book 2", 15.0f, "Details"), 3);
            supplier2.registerBook(new Book(3, "Book 3", 20.0f, "Details"), 7);

            bookStore.addSupplier(supplier1);
            bookStore.addSupplier(supplier2);
        } catch (Exception ex) {
            fail();
        }

        HashMap<Book, Integer> expectedAvailableBooks = new HashMap<>();
        expectedAvailableBooks.put(new Book(1, "Book 1", 10.0f, "Details"), 5);
        expectedAvailableBooks.put(new Book(2, "Book 2", 15.0f, "Details"), 3);
        expectedAvailableBooks.put(new Book(3, "Book 3", 20.0f, "Details"), 7);

        assertTrue(bookStore.getAvailableBooks().keySet().containsAll(expectedAvailableBooks.keySet()));
    }

    @Test
    public void testRemoveCustomer() {
        Customer customer = new Customer("test_customer", "Test Customer", null);

        try {
            bookStore.addCostumer(customer);
            bookStore.removeCustomer(customer);
        } catch (Exception ex) {
            fail();
        }
        assertTrue(!bookStore.getCostumers().contains(customer));
    }

    @Test
    public void testRemoveSupplier() {
        Supplier supplier = new Supplier("test_supplier", "Test Supplier", null);
        try {
            bookStore.addSupplier(supplier);
            bookStore.removeSupplier(supplier);
        } catch (Exception ex) {
            fail();
        }
        assertTrue(!bookStore.getSuppliers().contains(supplier));
    }

    @Test
    public void testUpdateBookStock() {
        Supplier supplier = new Supplier("test_supplier", "Test Supplier", null);
        Book book = new Book(1, "Book 1", 10.0f, "Details");
        try {
            supplier.registerBook(book, 5);
            bookStore.addSupplier(supplier);
            supplier.registerBook(book, 5);  // Update stock
        } catch (Exception ex) {
            fail();
        }

        assertEquals(10, bookStore.getAvailableBooks().get(book).intValue());
    }

    @Test
    public void testExceptionForNonExistentCustomerRemoval() {
        Customer customer = new Customer("nonexistent_customer", "Nonexistent Customer", null);
        assertThrows(Exception.class, () -> {
            bookStore.removeCustomer(customer);
        });
    }

    @Test
    public void testExceptionForNonExistentSupplierRemoval() {
        Supplier supplier = new Supplier("nonexistent_supplier", "Nonexistent Supplier", null);
        assertThrows(Exception.class, () -> {
            bookStore.removeSupplier(supplier);
        });
    }
}
