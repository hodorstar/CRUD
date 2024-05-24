package crud.actions;

import crud.models.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface PurchaseCrudRepository extends JpaRepository<Purchase, Long>  {
}
