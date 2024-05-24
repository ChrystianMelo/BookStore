
import com.mycompany.bookstore.BookStore;
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
    public void testSuppliersCount() {
        assertTrue(bookStore.getAvailableBooks().isEmpty());
    }
}
