package crud.actions;

import crud.models.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для операций с сущностью {@link Purchase}.
 */
public interface PurchaseCrudRepository extends JpaRepository<Purchase, Long>  {
}
