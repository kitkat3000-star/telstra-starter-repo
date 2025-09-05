package au.com.telstra.simcardactivator.repositories;

import au.com.telstra.simcardactivator.entities.SimCardRecord;
import org.springframework.data.repository.CrudRepository;

public interface SimCardRecordRepository extends CrudRepository<SimCardRecord, Long> {

}
