package se.kth.IV1350.integration;

import java.util.Map;

import se.kth.IV1350.dto.ItemDTO;

/**
 * A class responsible for simulating the external inventory system.
 */
public class ExternalInventory {
    /**
     * An ItemDTO array with dummy data for simulation purposes.
     */
    private ItemDTO[] items = new ItemDTO[] {
        new ItemDTO("1", "Milk", "Low-fat organic pasteurized whole milk", 25.90, 0.06), new ItemDTO("2", "Flour", "Organic all purpose flour", 36.50, 0.06),
        new ItemDTO("3", "Eggs", "Free-range large brown eggs", 48.90, 0.06), new ItemDTO("4", "Potatoes", "Fresh Idaho potatoes", 12.39, 0.06),
        new ItemDTO("5", "Carrots", "Fresh whole carrots", 21.90, 0.06), new ItemDTO("6", "Chicken", "Locally produced boneless chicken breasts", 44.50, 0.06),
        new ItemDTO("7", "Salmon", "Wild frozen atlantic salmon", 79.90, 0.06), new ItemDTO("8", "Olive Oil", "Extra virgin olive oil", 61.50, 0.06)
    };

    /**
     * Method for fetching an item's information.
     * @param itemId a string representing an item's id.
     * @return an instance of ItemDTO containing the item information or null if the item id does not exist.
     */
    public ItemDTO getItem(String itemId) {
        for (ItemDTO item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Method for updating the external inventory. (Currently does nothing).
     * @param itemMap a hash map containing item information and item count.
     */
    public void update(Map<ItemDTO, Integer> itemMap) {
        //Update inventory to account for sold items.
    }
}