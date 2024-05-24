package crud.actions;

import crud.models.Purchase;

import java.sql.Timestamp;
import java.util.List;

public class PurchaseCrudService implements PurchaseCrudRepository {
    private PurchaseCrudRepository repository;

    public void  createPurchase(Purchase purchase){
        repository.save();
    }


    public Purchase getPurchaseById(Long id) {
        return repository.findById(id).orElse(null);

    }

    public List<Purchase> getAllPurchase(){
        return repository.findAll();
    }

    public Purchase updatePurchase(Long id, Timestamp date, String name){
        Purchase purchase = repository.findById(id).orElse(null);
        if (purchase != null) {
            purchase.setBuyerId(buyerId);
            purchase.setSeller2Id(sellerId);
            purchase.setName(name);
            purchase.setDate(date);
            return repository.save(purchase);
        }
        return null;
    }

    public void deletePurchase(Purchase purchase){
        repository.delete(purchase);
    }

}
