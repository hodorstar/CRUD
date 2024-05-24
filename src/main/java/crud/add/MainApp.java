package crud.add;

import crud.actions.PurchaseCrudService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.Scanner;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(PurchaseCrudService service) {
        return (args) -> {
            Scanner scanner = new Scanner(System.in);

            boolean running = true;
            while (running) {
                System.out.println("Choose operation: [1] Create, [2] Read, [3] Update, [4] Delete, [5] Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        // Добавление новой покупки
                        break;
                    case 2:
                        // Чтение покупки
                        break;
                    case 3:
                        // Обновление покупки
                        break;
                    case 4:
                        // Удаление покупки
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        };
    }
}
