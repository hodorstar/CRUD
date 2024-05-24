package crud.actions;

import crud.models.Purchase;

import java.sql.Timestamp;
import java.util.List;

public class PurchaseCrudOperationsImpl implements PurchaseCrudOperations{
    public void  createPurchase(Purchase purchase){}

    @Override
    public Purchase getPurchaseById(Long id) {

    }

    List<Purchase> getAllPurchase(){}

    void updatePurchase(Long id, Timestamp date, String name){}

    void deletePurchase(Purchase purchase){}

}
