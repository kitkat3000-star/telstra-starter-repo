package au.com.telstra.simcardactivator.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimCard {
    private String iccid;
    private String customerEmail;
    private Boolean active;
}
