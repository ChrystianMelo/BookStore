
import com.mycompany.bookstore.Book;
import com.mycompany.bookstore.BookStore;
import com.mycompany.bookstore.Customer;
import com.mycompany.bookstore.Supplier;
import com.mycompany.bookstore.db.BookStoreDatabaseUtils;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class BookStoreDBTest {

    @AfterEach
    public void tearDown() {
        try {
            BookStoreDatabaseUtils.clearCache();
        } catch (Exception ex) {
            System.out.println("ERROR");
        }
    }

    @Test
    public void testAddCustomer() {
        String address = "Rua A" + "Cidade" + "Estado" + "12345-678";
        Customer customer = new Customer("user1", "João", address);
        try {
            BookStore bookStore = new BookStore();
            bookStore.addCostumer(customer);

            BookStoreDatabaseUtils.writeBookStore(bookStore);
        } catch (Exception ex) {
            fail();
        }

        try {
            BookStore bookStore = BookStoreDatabaseUtils.readBookStore();
            ArrayList<Customer> loadedCustomers = bookStore.getCostumers();

            assertTrue(loadedCustomers.contains(customer));
            assertEquals(loadedCustomers.size(), 1);
        } catch (URISyntaxException ex) {
            fail();
        }
    }

    @Test
    public void testAddCustomerWithCart() {
        String address = "Rua A" + "Cidade" + "Estado" + "12345-678";
        Customer customer = new Customer("user1", "João", address);
        Book book = new Book(1, "Livro 1", 29.99f, "Detalhes do Livro 1");

        try {
            customer.addToCart(book);

            BookStore bookStore = new BookStore();
            bookStore.addCostumer(customer);

            BookStoreDatabaseUtils.writeBookStore(bookStore);
        } catch (Exception ex) {
            fail();
        }

        try {
            BookStore bookStore = BookStoreDatabaseUtils.readBookStore();
            ArrayList<Customer> loadedCustomers = bookStore.getCostumers();

            Customer loadedCustome = loadedCustomers.get(0);

            assertTrue(loadedCustome.getCart().getBooks().keySet().contains(book));
            assertEquals(loadedCustome.getCart().getBooks().keySet().size(), 1);
        } catch (URISyntaxException ex) {
            fail();
        }
    }

    @Test
    public void testAddCustomerWithFavorites() {
        String address = "Rua A" + "Cidade" + "Estado" + "12345-678";
        Customer customer = new Customer("user1", "João", address);
        Book book = new Book(1, "Livro 1", 29.99f, "Detalhes do Livro 1");

        try {
            customer.addFavorite(book);

            BookStore bookStore = new BookStore();
            bookStore.addCostumer(customer);

            BookStoreDatabaseUtils.writeBookStore(bookStore);
        } catch (Exception ex) {
            fail();
        }

        try {
            BookStore bookStore = BookStoreDatabaseUtils.readBookStore();
            ArrayList<Customer> loadedCustomers = bookStore.getCostumers();

            Customer loadedCustome = loadedCustomers.get(0);

            assertTrue(loadedCustome.getFavorites().contains(book));
            assertEquals(loadedCustome.getFavorites().size(), 1);
        } catch (URISyntaxException ex) {
            fail();
        }
    }

    @Test
    public void testAddSupplier() {
        String address = "Rua A" + "Cidade" + "Estado" + "12345-678";
        Supplier supplier = new Supplier("user1", "João", address);
        try {
            BookStore bookStore = new BookStore();
            bookStore.addSupplier(supplier);

            BookStoreDatabaseUtils.writeBookStore(bookStore);
        } catch (Exception ex) {
            fail();
        }

        try {
            BookStore bookStore = BookStoreDatabaseUtils.readBookStore();
            ArrayList<Supplier> loadedSuppliers = bookStore.getSuppliers();

            assertTrue(loadedSuppliers.contains(supplier));
            assertEquals(loadedSuppliers.size(), 1);
        } catch (URISyntaxException ex) {
            fail();
        }
    }

    @Test
    public void testAddSupplierWithStock() {
        String address = "Rua A" + "Cidade" + "Estado" + "12345-678";
        Supplier supplier = new Supplier("user1", "João", address);
        Book book = new Book(1, "Livro X", 39.99f, "Detalhes do Livro X");
        try {
            supplier.registerBook(new Book(1, "Livro X", 39.99f, "Detalhes do Livro X"), 10);

            BookStore bookStore = new BookStore();
            bookStore.addSupplier(supplier);

            BookStoreDatabaseUtils.writeBookStore(bookStore);
        } catch (Exception ex) {
            fail();
        }

        try {
            BookStore bookStore = BookStoreDatabaseUtils.readBookStore();
            ArrayList<Supplier> loadedSuppliers = bookStore.getSuppliers();

            Supplier loadedSupplier = loadedSuppliers.get(0);

            assertTrue(loadedSupplier.getEstoque().keySet().contains(book));
            assertEquals(loadedSupplier.getEstoque().size(), 1);

        } catch (URISyntaxException ex) {
            fail();
        }
    }
}
