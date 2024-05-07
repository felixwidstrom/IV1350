package se.kth.IV1350.integration;

import java.util.*;

import se.kth.IV1350.dto.SaleDTO;

/**
 * A class responsible for simulating a discount database.
 */
public class DiscountDB {
    /**
     * Hash map for storing customer id's and discount amounts.
     */
    private Map<String, Double> customers = new HashMap<String, Double>();

    /**
     * Constructor for DiscountDB.
     */
    public DiscountDB() {
        customers.put("felix", 34.72);
    }

    /**
     * Method for fetching a discount.
     * @param customerId a string representing a customer id used to fetch a discount.
     * @param itemMap a hash map containing items and their information. (Currently not in use).
     * @return a double representing a discount amount.
     */
    public double getDiscount(String customerId, SaleDTO saleItems) {
        return customers.get(customerId) != null ? customers.get(customerId) : 0;
    }
}