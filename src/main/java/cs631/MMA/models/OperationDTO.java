package cs631.MMA.models;

import cs631.MMA.entities.*;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private Boolean finished;

    public Operation toOperation() {
        return Operation.builder()
                .location(this.location)
                .date(this.date)
                .start(this.start)
                .end(this.end)
                .finished(this.finished)
                .build();
    }
}
