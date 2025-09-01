package au.com.telstra.simcardactivator.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimActivationRequest {
    private String iccid;
    private String customerEmail;

}
