package se.kth.IV1350;
import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.integration.DiscountDB;
import se.kth.IV1350.integration.ExternalAccounting;
import se.kth.IV1350.integration.ExternalInventory;
import se.kth.IV1350.integration.Printer;
import se.kth.IV1350.view.View;

/** 
 * Main class resonsible for starting the program. Entry point for the program. 
 */
public class Main {
    /** 
     * Main method, entry point for the program. 
     */
    public static void main(String[] args) {
        ExternalInventory eis = new ExternalInventory();
        ExternalAccounting eas = new ExternalAccounting();
        DiscountDB ddb = new DiscountDB();
        Printer printer = new Printer();
        Controller con = new Controller(eis, eas, ddb, printer);
        View view = new View(con);

        view.startSale();
    }
}
