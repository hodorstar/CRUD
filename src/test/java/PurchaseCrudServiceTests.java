
import crud.TestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import crud.actions.PurchaseCrudRepository;
import crud.actions.PurchaseCrudService;
import crud.models.Purchase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;


import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(PurchaseCrudService.class)
@ContextConfiguration(classes = TestApplication.class)
@ActiveProfiles("test")
 class PurchaseCrudServiceTests {
    @Autowired
    private PurchaseCrudService purchaseCrudService;

    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;

    @Test
     void testAllReadPurchase() {
        List<Purchase> purchases = purchaseCrudService.getAllPurchase();
        long iter = 1;
        for (Purchase p : purchases) {
            assertEquals(iter, p.getId());

            iter++;
        }
    }

    @Test
     void testReadPurchase() {
        Purchase purchaseNull = purchaseCrudService.getPurchaseById(50L);
        assertNull(purchaseNull);
        Purchase purchase = purchaseCrudService.getPurchaseById(5L);
        assertEquals(5, purchase.getId());
        assertEquals(5, purchase.getBuyer());
        assertEquals(105, purchase.getSeller());
        assertEquals(205, purchase.getType());
        assertEquals("Headphones", purchase.getName());
        assertEquals("2024-05-24 14:00:00.0", purchase.getDate().toString());
    }

    @Test
     void testCreatePurchase() {
        Purchase newPurchase = new Purchase(null, 1L, 2L, 3L, "Product", new Timestamp(System.currentTimeMillis()));
        purchaseCrudService.createPurchase(newPurchase);
        assertNotNull(newPurchase.getId());
    }

    @Test
     void testUpdatePurchase() {
        Purchase purchaseNull = purchaseCrudService.updatePurchase(50L, "Mouse", Timestamp.valueOf("2023-05-24 00:00:00.0"));
        assertNull(purchaseNull);
        Purchase purchase = purchaseCrudService.updatePurchase(9L, "Mouse", Timestamp.valueOf("2023-11-11 10:00:00.0"));
        assertEquals("Mouse", purchase.getName());
        assertEquals("2023-11-11 10:00:00.0", purchase.getDate().toString());
    }

    @Test
     void testDeletePurchase() {
        Purchase purchase = purchaseCrudService.getPurchaseById(10L) ;
        assertEquals(10, purchase.getId());
        purchaseCrudService.deletePurchase(purchase);
        Purchase purchaseNull = purchaseCrudService.getPurchaseById(10L) ;
        assertNull(purchaseNull);
    }

}
