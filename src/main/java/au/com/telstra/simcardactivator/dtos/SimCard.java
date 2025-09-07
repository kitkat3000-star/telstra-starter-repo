package au.com.telstra.simcardactivator.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimCard {
    private String iccid;
    private String customerEmail;
    private Boolean active;

    public SimCard() {

    }
}
