package au.com.telstra.simcardactivator.mappers;

import au.com.telstra.simcardactivator.dtos.SimCard;
import au.com.telstra.simcardactivator.entities.SimCardRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimCardMapper {
    SimCard toDto(SimCardRecord simCardRecord);

    SimCardRecord toEntity(SimCard simCard);
}
