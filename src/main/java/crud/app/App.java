package crud.app;

import crud.actions.PurchaseCrudService;
import crud.models.Purchase;

import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner scanner;
    private PurchaseCrudService service;

    public App(Scanner scanner, PurchaseCrudService service) {
        this.scanner = scanner;
        this.service = service;
    }

    void showMenu(){
        boolean running = true;
        while (running) {
            System.out.println("Choose operation: [1] Create, [2] Read, [3] Update, [4] Delete, [5] Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
//                    create();
                    break;
                case 2:
                    read();
                    break;
                case 3:
//                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

//    private  void create(){
//        System.out.println("Введите Id");
//        service.createPurchase();
//    }
    private  void read(){
        System.out.println("[1] find all");
        System.out.println("[2]find by id");
        int chose = scanner.nextInt();
        if (chose == 1) {
            List<Purchase> list = service.getAllPurchase();
            for (Purchase p : list) {
                System.out.println(p);
            }
        } else if (chose == 2) {
            System.out.println("id");
            long id = scanner.nextLong();
            Purchase purchase = service.getPurchaseById(id);
            System.out.println(purchase);
        }

    }
//    private  void update(){}
    private  void delete(){
        System.out.println("id");
        long id = scanner.nextLong();
        Purchase purchase = service.getPurchaseById(id);

        if (purchase != null) {
            service.deletePurchase(purchase);
            System.out.println(purchase + " ',ewb");
        } else {
            System.out.println("not");
        }
    }

}
