package main.java.se.kth.IV1350;
import main.java.se.kth.IV1350.controller.Controller;
import main.java.se.kth.IV1350.integration.DiscountDB;
import main.java.se.kth.IV1350.integration.ExternalAccounting;
import main.java.se.kth.IV1350.integration.ExternalInventory;
import main.java.se.kth.IV1350.integration.Printer;
import main.java.se.kth.IV1350.view.View;

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
