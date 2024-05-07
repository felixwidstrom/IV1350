package se.kth.IV1350.dto;

import java.util.*;

/**
 * A class responsible for storing/transporting items and their information from a sale.
 */
public class SaleDTO {
    /**
     * Variable declarations for internal storage.
     */
    private Map<ItemDTO, Integer> itemMap = new HashMap<>();

    /**
     * Constructor for SaleDTO.
     * @param itemMap a map containing item dto's and the count of them.
     */
    public SaleDTO(Map<ItemDTO, Integer> itemMap) {
        this.itemMap = itemMap;
    }

    /**
     * Getter for the item map.
     * @return an item map containing item dto's and the count of them.
     */
    public Map<ItemDTO, Integer> getItems() {
        return itemMap;
    }
}