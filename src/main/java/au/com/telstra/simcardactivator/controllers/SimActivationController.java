package au.com.telstra.simcardactivator.controllers;

import au.com.telstra.simcardactivator.dtos.SimCard;
import au.com.telstra.simcardactivator.mappers.SimCardMapper;
import au.com.telstra.simcardactivator.repositories.SimCardRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/sim")
public class SimActivationController {

    private final SimActuatorHandler simActuatorHandler;
    private final SimCardRecordRepository simCardRecordRepository;
    private final SimCardMapper simCardMapper;

    @PostMapping("/activate")
    public ResponseEntity<String> ActivateSim(@RequestBody SimCard simCard) {
        var response = simActuatorHandler.actuate(simCard);
        System.out.println(response);

        var simCardRecord = simCardMapper.toEntity(simCard);
        simCardRecord.setActive(response.isSuccess());

        simCardRecordRepository.save(simCardRecord);

        return ResponseEntity.ok("Activation Result " + response.isSuccess());
    }

    @GetMapping("/query")
    public ResponseEntity<SimCard> querySim(@RequestParam Long id){
        var simCardRecord = simCardRecordRepository.findById(id).orElse(null);
        if (simCardRecord == null) {
            return ResponseEntity.notFound().build();
        }

        var simcard = simCardMapper.toDto(simCardRecord);
        if (simcard == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(simcard);
    }


}

