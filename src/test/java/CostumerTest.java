
import com.mycompany.bookstore.Address;
import com.mycompany.bookstore.Book;
import com.mycompany.bookstore.Customer;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CostumerTest {

    private Customer costumer;

    @BeforeEach
    public void setUp() {
        Address address = new Address("Street", 123, "Neighborhood", "City", "State", "Country", "Complement");
        costumer = new Customer("username", "Costumer Name", address);
    }

    @Test
    public void testRemoveBookFromCart() throws Exception {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        costumer.addBook(book, 2);
        costumer.removeBook(book, 2);

        assertTrue(costumer.getCart().isEmpty());
    }

    @Test
    public void testCheckOutCart() {
        Book book = new Book(1, "Test Book", 19.99f, "Test Details");
        costumer.addBook(book, 2);
        try {
            costumer.checkOutCart();
        } catch (Exception ex) {
            fail();
        }

        assertTrue(costumer.getCart().isEmpty());
    }
}
