package se.kth.IV1350.model;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Map;

import se.kth.IV1350.dto.ItemDTO;

public class SaleTest {
    Sale sale;

    @Before
    public void setUp() {
        sale = new Sale();
    }

    @After
    public void tearDown() {
        sale = null;
    }

    @Test
    public void testNotEqualsNull() {
        Object object = null;
        boolean expected = false;
        boolean result = sale.equals(object);
        assertEquals("Sale instance equals null", expected, result);
    }

    @Test
    public void testNotEquals() {
        Object object = new Object();
        boolean expected = false;
        boolean result = sale.equals(object);
        assertEquals("Sale instance is equal to other object", expected, result);
    }

    @Test
    public void testEquals() {
        Sale object = new Sale();
        boolean expected = true;
        boolean result = sale.equals(object);
        assertEquals("Sale instance is not equal to Sale", expected, result);
    }

    @Test
    public void testAddItemToEmptyList() {
        sale.addItem(new ItemDTO("test", "test", "test", 1, 0.5), 2);
        Map.Entry<ItemDTO, Integer> entry = sale.getItems().entrySet().iterator().next();
        assertTrue("Item not added",  
            entry.getKey().getItemId() == "test" && 
            entry.getKey().getName() == "test" && 
            entry.getKey().getDescription() == "test" &&
            entry.getKey().getPrice() == 1 && 
            entry.getKey().getVat() == 0.5 &&
            entry.getValue() == 2
        );
    }

    @Test
    public void testAddEqualItem() {
        sale.addItem(new ItemDTO("test", "test", "test", 1, 0.5), 2);
        sale.addItem(new ItemDTO("test", "test", "test", 1, 0.5), 1);
        Map.Entry<ItemDTO, Integer> entry = sale.getItems().entrySet().iterator().next();
        assertTrue("Item not updated",  
            entry.getKey().getItemId() == "test" && 
            entry.getKey().getName() == "test" && 
            entry.getKey().getDescription() == "test" &&
            entry.getKey().getPrice() == 1 && 
            entry.getKey().getVat() == 0.5 &&
            entry.getValue() == 3
        );
    }

    @Test
    public void testTotalAmountUpdatesOnItemAdd() {
        sale.addItem(new ItemDTO("test", "test", "test", 1, 0.5), 2);
        assertTrue("Amount not updated", sale.getTotalAmount() == 2);
    }

    @Test
    public void testVatUpdatesOnItemAdd() {
        sale.addItem(new ItemDTO("test", "test", "test", 1, 0.5), 2);
        assertTrue("Vat not updated", sale.getVat() == 1);
    }

    @Test
    public void testDiscountSet() {
        sale.setDiscount(20);
        assertTrue("Discount not set", sale.getDiscount() == 20);
    }

    @Test
    public void testDiscountAffectsTotalAmount() {
        sale.addItem(new ItemDTO("test", "test", "test", 120, 0.5), 1);
        sale.setDiscount(20);
        assertTrue("Amount not updated", sale.getTotalAmount() == 100);
    }

    @Test
    public void testSetPaymentAmount() {
        sale.setPaymentAmount(120);
        assertTrue("Amount not set", sale.getPaymentAmount() == 120);
    }

    @Test
    public void testChangeCalculated() {
        sale.addItem(new ItemDTO("test", "test", "test", 120, 0.5), 1);
        sale.setPaymentAmount(140);
        assertTrue("Change not calculated", sale.getChange() == 20);
    }
}
