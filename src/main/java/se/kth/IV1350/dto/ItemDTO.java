package se.kth.IV1350.dto;

/**
 * A class for conviniently storing item information.
 */
public class ItemDTO {
    /**
     * Variable declarations for storing item information.
     */
    private String itemId;
    private String name;
    private String description;
    private double price;
    private double vat;

    /**
     * Constructor for ItemDTO.
     * @param itemId a string representing an item's id.
     * @param name a string representing an item's name.
     * @param description a string representing an item's description.
     * @param price a double representing an item's price.
     * @param vat a double representing an item's vat.
     */
    public ItemDTO(String itemId, String name, String description, double price, double vat) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.vat = vat;
    }

    /**
     * Getter for item id.
     * @return an item's id.
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Getter for name.
     * @return an item's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for description.
     * @return an item's description.
     */
    public String getDescription() {
        return description;
    }

    /** 
     * Getter for price.
     * @return an item's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter for vat.
     * @return an item's vat.
     */
    public double getVat() {
        return vat;
    }
}
