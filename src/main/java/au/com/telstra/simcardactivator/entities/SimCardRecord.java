package au.com.telstra.simcardactivator.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class SimCardRecord {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String iccid;

    @Column(nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private Boolean active;

}
