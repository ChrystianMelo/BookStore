
import com.mycompany.bookstore.Book;
import com.mycompany.bookstore.Cart;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTest {

    private Cart cart;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testAddItem() {
        try {
            Book book = new Book(1, "Test Book", 19.99f, "Test Details");
            cart.addItem(book, 1);
            assertEquals(1, cart.getBooks().get(book));

        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void testAddMultipleQuantitiesOfSameItem() {
        try {
            Book book = new Book(1, "Test Book", 19.99f, "Test Details");
            cart.addItem(book, 1);
            cart.addItem(book, 2);
            assertEquals(3, cart.getBooks().get(book));

        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void testCartIsEmptyAfterInitialization() {
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testCheckOutEmptiesCart() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        try {
            cart.addItem(book, 2);

        } catch (Exception ex) {
            fail();
        }

        try {
            cart.checkOut();
        } catch (Exception e) {
            fail("Method threw an exception: " + e.getMessage());
        }

        assertTrue(cart.isEmpty());
    }

    @Test
    public void testRemovePartialQuantityOfItem() throws Exception {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        cart.addItem(book, 5);
        cart.removeBook(book, 3);

        assertEquals(2, cart.getBooks().get(book));
    }

    @Test
    public void testRemoveMoreThanExisantQuantityOfItem() throws Exception {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        cart.addItem(book, 5);

        assertThrows(Exception.class, () -> {
            cart.removeBook(book, 8);
        });
    }

    @Test
    public void testRemoveItem() throws Exception {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        cart.addItem(book, 2);
        cart.removeBook(book, 2);
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testRemoveItemNotInCart() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        try {
            cart.addItem(book, 2);
        } catch (Exception ex) {
            fail();
        }

        Book book2 = new Book(2, "Test Book2", 19.99f, "Test Details2");

        assertThrows(Exception.class, () -> {
            cart.removeBook(book2, 2);
        });

        assertFalse(cart.isEmpty());
    }

    @Test
    public void testEmptyCart() {
        try {
            Book book = new Book(1, "Test Book", 19.99f, "Test Details");
            cart.addItem(book, 2);

            Book book2 = new Book(2, "Test Book2", 19.99f, "Test Details2");
            cart.addItem(book2, 3);

            cart.emptyCart();

            assertTrue(cart.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    public void testGetTotalValue() {
        Book book1 = new Book(1, "Test Book", 19f, "Test Details");
        Book book2 = new Book(2, "Another Book", 9f, "Other Details");

        try {
            cart.addItem(book1, 2); // Total = 2 * 19
            cart.addItem(book2, 3); // Total = 3 * 9
        } catch (Exception ex) {
            fail();
        }

        float expectedTotal = (2 * 19f) + (3 * 9f);
        assertEquals(expectedTotal, cart.getTotal(), 0.01);
    }

    @Test
    public void testAddNegativeQuantity() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");

        assertThrows(Exception.class, () -> {
            cart.addItem(book, -1);
        });
    }

    @Test
    public void testRemoveAllItemsAtOnce() throws Exception {
        Book book1 = new Book(1, "Test Book", 19.99f, "Test Details");
        Book book2 = new Book(2, "Another Book", 9.99f, "Other Details");

        cart.addItem(book1, 2);
        cart.addItem(book2, 3);

        cart.removeBook(book1, 2);
        cart.removeBook(book2, 3);

        assertTrue(cart.isEmpty());
    }

}
