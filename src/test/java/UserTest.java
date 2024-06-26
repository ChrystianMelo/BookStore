/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import com.mycompany.bookstore.Customer;
import com.mycompany.bookstore.Supplier;
import com.mycompany.bookstore.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 */
public class UserTest {

    private User user;
    private Customer costumer;
    private Supplier supplier;
    private String address;

    @BeforeEach
    public void setUp() {
        address = "Street" + "Neighborhood" + "City" + "State" + "Country" + "Complement";
        user = new User("user1", "User One", address);
        costumer = new Customer("costumer1", "Costumer One", address);
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

    @Test
    public void testSetName() {
        user.setName("New User Name");
        assertEquals("New User Name", user.getName());
    }

    @Test
    public void testSetAdress() {
        String newAddress = "Street2" + "Neighborhood" + "City" + "State" + "Country" + "Complement";
        user.setAdress(newAddress);
        assertEquals(newAddress, user.getAdress());
    }

    @Test
    public void testGetUsername() {
        assertEquals("user1", user.getUsername());
    }

    @Test
    public void testGetName() {
        assertEquals("User One", user.getName());
    }

    @Test
    public void testGetAdress() {
        assertEquals(address, user.getAdress());
    }
}
