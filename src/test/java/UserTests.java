/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import com.mycompany.bookstore.Address;
import com.mycompany.bookstore.Costumer;
import com.mycompany.bookstore.Supplier;
import com.mycompany.bookstore.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 */
public class UserTests {

    private User user;
    private Costumer costumer;
    private Supplier supplier;
    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address("Street", 1, "Neightborhood", "City", "State", "Coountry", "12345");
        user = new User("user1", "User One", address);
        costumer = new Costumer("costumer1", "Costumer One", address);
        supplier = new Supplier("supplier1", "Supplier One", address);
    }

    @Test
    public void testUserCreation() {
        assertEquals("user1", user.getUsername());
        assertEquals("User One", user.getName());
        assertEquals(address, user.getAdress());
    }

    @Test
    public void testCostumerCreation() {
        assertEquals("costumer1", costumer.getUsername());
        assertEquals("Costumer One", costumer.getName());
        assertEquals(address, costumer.getAdress());
        assertNotNull(costumer.getCart());
    }

    @Test
    public void testSupplierCreation() {
        assertEquals("supplier1", supplier.getUsername());
        assertEquals("Supplier One", supplier.getName());
        assertEquals(address, supplier.getAdress());
        assertNotNull(supplier.getEstoque());
    }
}
