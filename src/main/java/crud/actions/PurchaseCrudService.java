package crud.actions;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crud.models.Purchase;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;

/**
 * Сервис для управления операциями над сущностями {@link Purchase}.
 */
@Service
public class PurchaseCrudService {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseCrudService.class);
    @Autowired
    private PurchaseCrudRepository repository;

    /**
     * Создает новую покупку в базе данных.
     *
     * @param purchase объект покупки для сохранения
     */
    public void createPurchase(Purchase purchase) {
        repository.save(purchase);
        logger.info("Created purchase: {}", purchase);
    }

    /**
     * Возвращает покупку по ее идентификатору.
     *
     * @param id идентификатор покупки
     * @return объект покупки или {@code null}, если покупка не найдена
     */
    public Purchase getPurchaseById(Long id) {
        Purchase purchase = repository.findById(id).orElse(null);
        if (purchase == null) {
            logger.warn("No purchase found with ID: {}", id);
        } else {
            logger.info("Retrieved purchase with ID: {}", id);
        }
        return purchase;
    }

    /**
     * Возвращает список всех покупок в базе данных.
     *
     * @return список покупок
     */
    public List<Purchase> getAllPurchase() {
        List<Purchase> purchases = repository.findAll();
        logger.info("Retrieved all purchases, total count: {}", purchases.size());
        return purchases;
    }

    /**
     * Обновляет информацию о покупке в базе данных.
     *
     * @param id идентификатор покупки, которую нужно обновить
     * @param name новое имя товара
     * @param date новая дата покупки
     * @return обновленная покупка или {@code null}, если покупка с таким идентификатором не найдена
     */
    public Purchase updatePurchase(Long id, String name, Timestamp date) {
        Purchase purchase = repository.findById(id).orElse(null);
        if (purchase != null) {
            purchase.setName(name);
            purchase.setDate(date);
            purchase = repository.save(purchase);
            logger.info("Updated purchase with ID: {}", id);
        } else {
            logger.warn("Failed to update, no purchase found with ID: {}", id);
        }
        return purchase;
    }

    /**
     * Удаляет покупку из базы данных.
     *
     * @param purchase объект покупки для удаления
     */
    public void deletePurchase(Purchase purchase) {
        repository.delete(purchase);
        logger.info("Deleted purchase: {}", purchase);
    }

}
