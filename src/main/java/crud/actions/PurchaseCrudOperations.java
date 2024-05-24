package crud.actions;

import crud.models.Purchase;

import java.sql.Timestamp;
import java.util.List;

public interface PurchaseCrudOperations {
    void createPurchase(Purchase purchase);

    Purchase getPurchaseById(Long id);

    List<Purchase> getAllPurchase();

    void updatePurchase(Long id, Timestamp date, String name);

    void deletePurchase(Purchase purchase);

}
