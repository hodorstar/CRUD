package crud.actions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crud.models.Purchase;

import java.sql.Timestamp;
import java.util.List;
import org.slf4j.Logger;

@Service
public class PurchaseCrudService  {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseCrudService.class);
    @Autowired
    private PurchaseCrudRepository repository;

    public void  createPurchase(Purchase purchase){
        repository.save(purchase);
        logger.info("Created purchase: {}", purchase);
    }


    public Purchase getPurchaseById(Long id) {
        Purchase purchase = repository.findById(id).orElse(null);
        if (purchase == null) {
            logger.warn("No purchase found with ID: {}", id);
        } else {
            logger.info("Retrieved purchase with ID: {}", id);
        }
        return purchase;
    }

    public List<Purchase> getAllPurchase(){
        List<Purchase> purchases = repository.findAll();
        logger.info("Retrieved all purchases, total count: {}", purchases.size());
        return purchases;
    }

    public Purchase updatePurchase(Long id, String name, Timestamp date){
        Purchase purchase = repository.findById(id).orElse(null);
        if (purchase != null) {
            purchase.setName(name);
            purchase.setDate(date);
            purchase = repository.save(purchase);
            logger.info("Updated purchase with ID: {}", id);
        }else {
            logger.warn("Failed to update, no purchase found with ID: {}", id);
        }
        return purchase;
    }

    public void deletePurchase(Purchase purchase){
        repository.delete(purchase);
        logger.info("Deleted purchase: {}", purchase);
    }

}
