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
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        cart.addItem(book, 1);
        assertEquals(1, cart.getBooks().get(book));
    }

    @Test
    public void testAddMultipleQuantitiesOfSameItem() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        cart.addItem(book, 1);
        cart.addItem(book, 2);
        assertEquals(3, cart.getBooks().get(book));
    }

    @Test
    public void testCartIsEmptyAfterInitialization() {
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testCheckOutEmptiesCart() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        cart.addItem(book, 2);
        cart.checkOut();
        assertTrue(cart.isEmpty());
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
        cart.addItem(book, 2);

        Book book2 = new Book(2, "Test Book2", 19.99f, "Test Details2");

        assertThrows(Exception.class, () -> {
            cart.removeBook(book2, 2);
        });

        assertFalse(cart.isEmpty());
    }

    @Test
    public void testEmptyCart() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        cart.addItem(book, 2);

        Book book2 = new Book(2, "Test Book2", 19.99f, "Test Details2");
        cart.addItem(book2, 3);

        cart.emptyCart();

        assertTrue(cart.isEmpty());
    }
}