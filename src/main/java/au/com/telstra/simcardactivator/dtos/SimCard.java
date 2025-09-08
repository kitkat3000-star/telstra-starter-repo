package au.com.telstra.simcardactivator.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimCard {
    private String iccid;
    private String customerEmail;
    private Boolean active;
}
