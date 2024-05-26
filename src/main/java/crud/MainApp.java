package crud;

import crud.actions.PurchaseCrudService;
import crud.app.App;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

/**
 * Главный класс Spring Boot приложения.
 */
@SpringBootApplication
public class MainApp {

    /**
     * Основной метод, запускающий Spring Boot приложение.
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    /**
     * Метод конфигурирует bean CommandLineRunner для интерактивной работы с пользователем через консоль.
     * @param service сервис для управления данными покупок.
     * @return возвращает CommandLineRunner с конфигурацией интерфейса командной строки.
     */
    @Bean
    public CommandLineRunner demo(PurchaseCrudService service) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            App menu = new App(scanner, service);
            menu.showMenu();

        };
    }
}
