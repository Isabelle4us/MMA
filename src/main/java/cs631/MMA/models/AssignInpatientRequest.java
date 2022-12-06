package cs631.MMA.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignInpatientRequest {
    private Integer bedId;
    private Integer patientId;
    private Integer nurseId;
}
