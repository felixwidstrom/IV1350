package se.kth.IV1350.model;

import java.util.Map;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import se.kth.IV1350.dto.ItemDTO;

/**
 * A class responsible for handling a sale by storing and operating on sale information.
 */
public class Sale {
    /**
     * Object and variable declarations for internal storage of sale information.
     */
    private Map<ItemDTO, Integer> itemMap = new HashMap<>();
    private double totalAmount;
    private double vat;
    private double discount;
    private double paymentAmount;
    private double change;
    private LocalDateTime saleTime;

    /**
     * Constuctor for Sale.
     */
    public Sale() {
        saleTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    /**
     * Getter for item map.
     * @return a hash map containing items and their information.
     */
    public Map<ItemDTO, Integer> getItems() {
        return itemMap;
    }

    /**
     * Getter for total amount.
     * @return a double representing the total amount of the sale.
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Getter for vat.
     * @return a double representing the vat of the sale.
     */
    public double getVat() {
        return vat;
    }

    /**
     * Getter for discount.
     * @return a double representing the discount of the sale.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Getter for payment amount.
     * @return a double representing the payment amount for the sale.
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Getter for change.
     * @return a double representing the change amount for the sale.
     */
    public double getChange() {
        return change;
    }

    /**
     * Getter for sale time.
     * @return a LocalDateTime representing the time of the sale.
     */
    public LocalDateTime getSaleTime() {
        return saleTime;
    }
    
    /**
     * Method for adding/updating an item to/in the list of items.
     * @param item an instance of ItemDTO containing item information.
     * @param count an integer representing the count of the given item.
     */
    public void addItem(ItemDTO item, int count) {
        for (Map.Entry<ItemDTO, Integer> entry : itemMap.entrySet()) {
            if (entry.getKey().getItemId().equals(item.getItemId())) {
                entry.setValue(entry.getValue() + count);
                totalAmount += (item.getPrice() * count);
                vat += (item.getPrice() * item.getVat() * count);
                return;
            }
        }

        itemMap.put(item, count);
        totalAmount += (item.getPrice() * count);
        vat += (item.getPrice() * item.getVat() * count);
    }

    /**
     * Method for setting a discount amount and deducting it from the total amount.
     * @param discount a double representing a discount amount.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
        totalAmount -= discount;
    }

    /**
     * Method for setting a payment amount and calculating the change.
     * @param amount a double representing a payment amount.
     */
    public void setPaymentAmount(double amount) {
        paymentAmount = amount;
        change = paymentAmount - totalAmount;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Sale)) {
            return false;
        }
        return true;
    }
}
