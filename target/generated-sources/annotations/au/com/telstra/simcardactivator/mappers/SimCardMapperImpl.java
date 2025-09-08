package au.com.telstra.simcardactivator.mappers;

import au.com.telstra.simcardactivator.dtos.SimCard;
import au.com.telstra.simcardactivator.entities.SimCardRecord;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-08T18:57:31+1000",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class SimCardMapperImpl implements SimCardMapper {

    @Override
    public SimCard toDto(SimCardRecord simCardRecord) {
        if ( simCardRecord == null ) {
            return null;
        }

        SimCard simCard = new SimCard();

        simCard.setIccid( simCardRecord.getIccid() );
        simCard.setCustomerEmail( simCardRecord.getCustomerEmail() );
        simCard.setActive( simCardRecord.getActive() );

        return simCard;
    }

    @Override
    public SimCardRecord toEntity(SimCard simCard) {
        if ( simCard == null ) {
            return null;
        }

        SimCardRecord simCardRecord = new SimCardRecord();

        simCardRecord.setIccid( simCard.getIccid() );
        simCardRecord.setCustomerEmail( simCard.getCustomerEmail() );
        simCardRecord.setActive( simCard.getActive() );

        return simCardRecord;
    }
}
