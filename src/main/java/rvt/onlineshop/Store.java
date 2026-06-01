package rvt.onlineshop;

import java.util.Scanner;

public class Store {

    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    //the method that handles the customers visit to the store.
    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Sveicinats musu veikala! " + customer);
        System.out.println("Musu piedavajums:");

        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while (true) {
            System.out.print("Ko vēlaties ielikt grozā (nospiediet enter, lai dotuies pie reģistrācijas): ");
            String product = scanner.nextLine();

            if (product.isEmpty() || !warehouse.products().contains(product)) {
                break;
            }
            
            cart.add(product, warehouse.price(product));
        }

        System.out.println("Jūsu groza saturs:");
        cart.print();
        System.out.println("kopā: " + cart.price());
    }
}