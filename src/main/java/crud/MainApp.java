package crud;

import crud.actions.PurchaseCrudService;
import crud.app.App;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(PurchaseCrudService service) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            App menu = new App(scanner, service);
            menu.showMenu();

        };
    }
}
