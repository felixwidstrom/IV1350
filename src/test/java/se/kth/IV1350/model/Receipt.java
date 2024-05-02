package test.java.se.kth.IV1350.model;

import java.util.Map;

import test.java.se.kth.IV1350.dto.ItemDTO;

/**
 * A class responsible for creating a receipt.
 */
public class Receipt {
    /** 
     * Method for getting the information from a sale and converting it to a string representing a receipt.
     * @param sale an instance of the Sale class.
     * @return a string representing a receipt or an empty string if sale is null or not an instance of Sale.
     */
    public String getReceipt(Sale sale) {
        if (sale == null || !sale.equals(new Sale())) {
            return "";
        }
        
        String receipt = "\nReceipt:\nTime of sale: " + sale.getSaleTime().toLocalDate() + " " + sale.getSaleTime().toLocalTime() + "\n\n";
        for (Map.Entry<ItemDTO, Integer> entry : sale.getItems().entrySet()) {
            ItemDTO item = entry.getKey();
            int count = entry.getValue();
            receipt += item.getName() + " " + count + " x " + item.getPrice() + " " + (item.getPrice() * count) + "\n";
        }
        receipt += "\nTotal: " + sale.getTotalAmount() + "\n";
        receipt += "Discount: " + sale.getDiscount() + "\n";
        receipt += "VAT: " + sale.getVat() + "\n\n";
        receipt += "Payment: " + sale.getPaymentAmount() + "\n";
        receipt += "Change: " + sale.getChange();
        return receipt;
    }
}
