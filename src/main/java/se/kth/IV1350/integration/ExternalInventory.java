package se.kth.IV1350.integration;

import java.util.*;
import java.util.Map.Entry;

import se.kth.IV1350.dto.ItemDTO;
import se.kth.IV1350.dto.SaleDTO;

/**
 * A class responsible for simulating the external inventory system.
 */
public class ExternalInventory {
    /**
     * An ItemDTO, Integer map with dummy data for simulation purposes.
     */
    private Map<ItemDTO, Integer> items = new HashMap<>();

    /**
     * Constructor for ExternalInventory.
     */
    public ExternalInventory() {
        items.put(new ItemDTO("1", "Milk", "Low-fat organic pasteurized whole milk", 25.90, 0.06), 10);
        items.put(new ItemDTO("2", "Flour", "Organic all purpose flour", 36.50, 0.06), 10);
        items.put(new ItemDTO("3", "Eggs", "Free-range large brown eggs", 48.90, 0.06), 10);
        items.put(new ItemDTO("4", "Potatoes", "Fresh Idaho potatoes", 12.39, 0.06), 10);
        items.put(new ItemDTO("5", "Carrots", "Fresh whole carrots", 21.90, 0.06), 10);
        items.put(new ItemDTO("6", "Chicken", "Locally produced boneless chicken breasts", 44.50, 0.06), 10);
        items.put(new ItemDTO("7", "Salmon", "Wild frozen atlantic salmon", 79.90, 0.06), 10);
        items.put(new ItemDTO("8", "Olive Oil", "Extra virgin olive oil", 61.50, 0.06), 10);
    }

    /**
     * Method for fetching an item's information.
     * @param itemId a string representing an item's id.
     * @return an instance of ItemDTO containing the item information or null if the item id does not exist.
     */
    public ItemDTO getItem(String itemId) {
        for (Entry<ItemDTO, Integer> item : items.entrySet()) {
            if (item.getKey().getItemId().equals(itemId)) {
                return item.getKey();
            }
        }
        return null;
    }

    /**
     * Method for updating the external inventory.
     * @param itemMap a hash map containing item information and item count.
     */
    public void update(SaleDTO saleItems) {
        for (Entry<ItemDTO, Integer> item : saleItems.getItems().entrySet()) {
            items.replace(item.getKey(), items.get(item.getKey()) - item.getValue());
        }
    }
}