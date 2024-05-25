package crud.actions;

import crud.models.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseCrudRepository extends JpaRepository<Purchase, Long>  {
}
