package rvt.onlineshop;

import java.util.Scanner;

public class MainShop {
    public static void main(String[] args) {
    Warehouse warehouse = new Warehouse(); 

    
    warehouse.addProduct("cipsi", 10, 25);
    warehouse.addProduct("cepumi", 3, 10);
    warehouse.addProduct("sprite", 1, 20);
    warehouse.addProduct("kola", 2, 7);

    Scanner scanner = new Scanner(System.in);

    Store store = new Store(warehouse, scanner);
    store.shop("Vairis");
    }
}