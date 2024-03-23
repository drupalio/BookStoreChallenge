package co.ximple.challenge.repository;

import co.ximple.challenge.repository.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository  extends JpaRepository<Inventory,Long> { }
