package test.java.se.kth.IV1350.controller;

import test.java.se.kth.IV1350.dto.ItemDTO;
import test.java.se.kth.IV1350.integration.DiscountDB;
import test.java.se.kth.IV1350.integration.ExternalAccounting;
import test.java.se.kth.IV1350.integration.ExternalInventory;
import test.java.se.kth.IV1350.integration.Printer;
import test.java.se.kth.IV1350.model.Receipt;
import test.java.se.kth.IV1350.model.Sale;

/**
 * A class responsible for communication between the model, integration and view layers.
 */
public class Controller {
    /**
     * Object declarations.
     */
    ExternalInventory eis;
    ExternalAccounting eas;
    DiscountDB ddb;
    Printer printer;
    Receipt receipt;
    Sale sale;

    /**
     * Constructor for Controller.
     * @param eis an instance of the class responsible for calling the external inventory system.
     * @param eas an instance of the class responsible for calling the external accounting system.
     * @param ddb an instance of the class responsible for calling the discount database.
     * @param printer an instance of the class responsible for calling the external printer.
     */
    public Controller(ExternalInventory eis, ExternalAccounting eas, DiscountDB ddb, Printer printer) {
        this.eis = eis;
        this.eas = eas;
        this.ddb = ddb;
        this.printer = printer;
    }

    /**
     * Getter for sale total.
     * @return the total amount for the current sale. 
     */
    public double getSaleTotal() {
        return sale.getTotalAmount();
    }

    /**
     * Method for starting a sale by creating an instance of Sale and Receipt.
     */
    public void startSale() {
        sale = new Sale();
        receipt = new Receipt();
    }

    /**
     * Method for fetching an item DTO from the external inventory and adding it to the current sale.
     * @param itemId a string representing an item id.
     * @param count an integer representing the amount of identical items scanned at once.
     * @return an instance of ItemDTO containing the item information. 
     */
    public ItemDTO scanItem(String itemId, int count) {
        ItemDTO item = eis.getItem(itemId);
        if (item == null) {
            System.out.println("\nInvalid item id...\n");
            return null;
        }
        sale.addItem(item, count);
        return item;
    }

    /**
     * Method for fetching a discount from the discount db and adding it to the current sale.
     * @param customerId a string representing a customer id.
     * @return a double representing the discount amount. 
     */
    public double startDiscount(String customerId) {
        double discount = ddb.getDiscount(customerId, sale.getItems());
        sale.setDiscount(discount);
        return discount;
    }

    /**
     * Method for ending a sale by setting a payment amount in the sale, getting a receipt, printing the receipt and updating the external systems. 
     * @param amount a double representing the payment amount.
     * @param customerId a string representing a customer id.
     * @return a string representing a receipt containing all of the sale information.
     */
    public String endSale(double amount) {
        sale.setPaymentAmount(amount);
        String r = receipt.getReceipt(sale);
        printer.print(r);
        eis.update(sale.getItems());
        eas.update(sale.getTotalAmount());
        return r;
    }
}
