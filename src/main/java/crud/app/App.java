package crud.app;

import crud.actions.PurchaseCrudService;
import crud.models.Purchase;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;


/**
 * Класс представляет собой консольное приложение для управления записями покупок.
 */
public class App {
    private Scanner scanner;
    private PurchaseCrudService service;

    /**
     * Конструктор, создающий экземпляр класса App.
     *
     @param scanner Сканнер для чтения ввода пользователя.
     @param service Сервис для выполнения операций CRUD над объектами Purchase.
     */
    public App(Scanner scanner, PurchaseCrudService service) {
        this.scanner = scanner;
        this.service = service;
    }

    /**
     * Запускает основной цикл пользовательского интерфейса, позволяющий выбирать CRUD операции.
     */
    public void showMenu() {
        boolean running = true;
        while (running) {
            System.out.println("Choose CRUD operations: [1] Create, [2] Read, [3] Update, [4] Delete, [5] Exit");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        create();
                        break;
                    case 2:
                        read();
                        break;
                    case 3:
                        update();
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
            } else {
                System.out.println("Invalid choice");
                scanner.next();
            }
        }

    }

    /**
     * Обрабатывает создание новой записи покупки.
     */
    private void create() {
        Long buyerId = safeNextLong("Enter buyer id:");
        Long sellerId = safeNextLong("Enter seller id:");
        Long typeId = safeNextLong("Enter type id:");

        System.out.println("Enter purchase name:");
        String name = scanner.next();

        Timestamp date = safeNextDate("Enter date: (format YYYY-MM-DD):");
        Purchase purchase = new Purchase(null, buyerId, sellerId, typeId, name, date);
        service.createPurchase(purchase);

    }


    /**
     * Обрабатывает чтение данных о покупках.
     */
    private void read() {
        Long chose = safeNextLong("Choose operations:\n[1] Select all purchases \n[2] Select purchase by id");
        if (chose == 1) {
            List<Purchase> list = service.getAllPurchase();
            for (Purchase p : list) {
                System.out.println(p);
            }
        } else if (chose == 2) {
            Long id = safeNextLong("Enter purchase id:");
            Purchase purchase = service.getPurchaseById(id);
            if (purchase != null) {
                System.out.println(purchase);
            } else {
                System.out.println("Purchase with id = " + id + " is not found");
            }
        } else {
            System.out.println("Invalid choice");
        }
    }

    /**
     * Обрабатывает обновление данных о покупке.
     */
    private void update() {
        Long id = safeNextLong("Enter purchase id to update:");

        System.out.println("Enter purchase name:");
        String name = scanner.next();
        Timestamp date = safeNextDate("Enter date: (format YYYY-MM-DD):");

        Purchase purchase = service.updatePurchase(id, name, date);
        if (purchase == null) {
            System.out.println("Purchase is not updated");
        } else {
            System.out.println("Purchase is updated successfully");
        }
    }

    /**
     * Обрабатывает удаление данных о покупке.
     */
    private void delete() {
        Long id = safeNextLong("Enter purchase id to delete:");
        Purchase purchase = service.getPurchaseById(id);
        if (purchase != null) {
            service.deletePurchase(purchase);
            System.out.println(purchase + " is deleted successfully");
        } else {
            System.out.println("Purchase is not deleted");
        }
    }

    /**
     * Считывает целое число от пользователя, проверяя его на корректность.
     *
     @param text Текст, который выводится перед вводом.
     @return Возвращает валидное целое число.
     */
    private Long safeNextLong(String text) {
        System.out.println(text);
        Long inputNumber = null;
        while (inputNumber == null) {
            if (scanner.hasNextLong()) {
                inputNumber = scanner.nextLong();
                if (inputNumber < 0) {
                    System.out.println("Please enter a number greater than zero");
                    inputNumber = null;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number");
                scanner.next();
            }
        }
        return inputNumber;
    }


    /**
     * Считывает дату от пользователя, проверяя ее на соответствие формату.
     *
     @param text Текст, который выводится перед вводом.
     @return Возвращает объект Timestamp, представляющий дату.
     */
    private Timestamp safeNextDate(String text) {
        System.out.println(text);
        Timestamp date = null;
        while (date == null) {
            String dateString = scanner.next();
            try {
                date = Timestamp.valueOf(dateString + " 00:00:00");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid enter. Please enter date (format YYYY-MM-DD):");
            }
        }
        return date;
    }

}
