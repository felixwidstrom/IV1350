package test.java.se.kth.IV1350.integration;

import org.junit.*;
import static org.junit.Assert.*;

import test.java.se.kth.IV1350.dto.ItemDTO;

public class ExternalInventoryTest {
    ExternalInventory eis;

    @Before
    public void setUp() {
        eis = new ExternalInventory();
    }

    @After
    public void tearDown() {
        eis = null;
    }

    @Test
    public void testGetItem() {
        ItemDTO item = eis.getItem("1");
        assertTrue("Item was not retrieved", item != null);
    }

    @Test
    public void testGetInvalidItem() {
        ItemDTO item = eis.getItem("99");
        assertTrue("Item was retrieved but should not have been", item == null);
    }
}