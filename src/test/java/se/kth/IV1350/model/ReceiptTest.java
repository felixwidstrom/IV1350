package test.java.se.kth.IV1350.model;

import org.junit.*;
import static org.junit.Assert.*;

import test.java.se.kth.IV1350.dto.ItemDTO;

public class ReceiptTest {
    Receipt receipt;

    @Before 
    public void setUp() {
        receipt = new Receipt();
    }

    @After
    public void tearDown() {
        receipt = null;
    }

    @Test
    public void testReceiptContainsAllInfo() {
        Sale sale = new Sale();
        sale.addItem(new ItemDTO("test", "test", "test", 100, 2), 3);
        sale.setDiscount(10);
        sale.setPaymentAmount(300);
        String r = receipt.getReceipt(sale);
        assertTrue("Receipt incomplete", 
            r.equals(
                "\nReceipt:\nTime of sale: " + sale.getSaleTime().toLocalDate() + " " + sale.getSaleTime().toLocalTime() + "\n\n" +
                "test 3 x 100.0 300.0\n" + "\nTotal: 290.0\n" + "Discount: 10.0\n" + "VAT: 600.0\n\n" + "Payment: 300.0\n" + "Change: 10.0"
            )
        );
    }

    @Test
    public void testNullObject() {
        String r = receipt.getReceipt(null);
        assertEquals("Null reference incorrectly handled", "", r);
    }
}
