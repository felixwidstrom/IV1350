package se.kth.IV1350.view;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import se.kth.IV1350.controller.Controller;
import se.kth.IV1350.dto.ItemDTO;

/**
 * A class responsible for displaying and reading information to/from the user.
 */
public class View {
    /**
     * Object and variable declarations.
     */
    private Scanner scanner = new Scanner(System.in);

    private Controller con;

    private String customerId;

    /**
     * Constructor for View.
     * @param con an instance of the Controller class.
     */
    public View(Controller con) {
        this.con = con;
    }

    /**
     * Start method for the sale process, used in main.
     */
    public void startSale() {
        con.startSale();
        System.out.println("Sale started: " + LocalDate.now() + " " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + "\n");
        scanItem();
        startDiscount();
        endSale();
    }

    /**
     * Method providing an interface for a user to enter/scan items.
     */
    void scanItem() {
        while (true) {
            System.out.print("Enter an item id (Add item) or done (Stop entering items): ");
            String input = scanner.nextLine().toLowerCase();
            if (!input.trim().equals("done")) {
                System.out.print("Enter amount of specified item: ");
                int count = scanner.nextInt();
                scanner.nextLine();
                ItemDTO item = con.scanItem(input, count);
                if (item != null) {
                    System.out.println("\nScanned item:\n");
                    System.out.println("Id: " + item.getItemId());
                    System.out.println("Name: " + item.getName());
                    System.out.println("Description: " + item.getDescription());
                    System.out.println("Price: " + item.getPrice());
                    System.out.println("Vat: " + item.getVat() + "\n");
                }
            } else {
                break;
            }
        }
        System.out.println();
    }

    /**
     * Method providing an interface for a user to fetch a discount and be presented with a new total amount.
     */
    void startDiscount() {
        System.out.print("Enter customer id to fetch discount: ");
        customerId = scanner.nextLine();
        double discount = con.startDiscount(customerId);
        System.out.println("\nDiscount: " + discount);
        System.out.println("\nTotal: " + con.getSaleTotal());
    }

    /**
     * Method providing an interface for a user to enter a payment amount and get a printed receipt.
     */
    void endSale() {
        System.out.print("\nEnter payment amount: ");
        double amount = scanner.nextDouble();
        System.out.println("\nExternal inventory/accounting updated and printer started...\n");
        System.out.println(con.endSale(amount));
        System.out.println("\n\nChange to give to customer: " + (amount - con.getSaleTotal()));
    }
}