package cs631.MMA.models;

import cs631.MMA.entities.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationDTO {
    private Integer id;
    private Integer surgeonId;
    private Integer patientId;
    private Integer surgeryId;
    private String location;
    private Date date;
    private Date startDate;
    private Date endDate;
    private Boolean finished;

    public Operation toOperation() {
        return Operation.builder()
                .location(this.location)
                .date(this.date)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .finished(this.finished)
                .build();
    }
}
