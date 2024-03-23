package co.ximple.challenge.mappers;

import co.ximple.challenge.models.InventoryRecord;
import co.ximple.challenge.repository.entities.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryMapper {


    @Mapping(target = "id", expression = "java(Optional.empty())")
    Inventory recordToEntity(InventoryRecord inventoryRecord);

    InventoryRecord entityToRecord(Inventory inventory);
}
