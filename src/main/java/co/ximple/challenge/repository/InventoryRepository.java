package co.ximple.challenge.repository;

import co.ximple.challenge.models.InventoryRecord;
import co.ximple.challenge.repository.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository  extends JpaRepository<Inventory,Long> {
    Inventory findByBookId(Long idBook);
}
