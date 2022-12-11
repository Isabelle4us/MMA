package cs631.MMA.models;

import cs631.MMA.entities.*;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InpatientDTO {
    private Integer id;
    private String admission;
    private Integer patientId;
    private Integer physicianId;
    private Integer bedId;
    private Integer nurseId;

    public Inpatient toInpatient() {
        return Inpatient.builder()
                .admission(this.admission)
                .build();
    }
}
