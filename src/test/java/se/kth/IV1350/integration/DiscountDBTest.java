package se.kth.IV1350.integration;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

import se.kth.IV1350.dto.ItemDTO;

public class DiscountDBTest {
    DiscountDB ddb;

    @Before
    public void setUp() {
        ddb = new DiscountDB();
    }

    @After
    public void tearDown() {
        ddb = null;
    }

    @Test
    public void testGetDiscount() {
        double discount = ddb.getDiscount("felix", new HashMap<ItemDTO, Integer>());
        assertTrue("Discount not retrieved", discount > 0);
    }

    @Test
    public void testInvalidCustomerIdGetDiscount() {
        double discount = ddb.getDiscount("test", new HashMap<ItemDTO, Integer>());
        assertTrue("Discount was retrieved but should not have been", discount == 0);
    }
}