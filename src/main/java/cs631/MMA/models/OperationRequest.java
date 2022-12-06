package cs631.MMA.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class OperationRequest {
    private Integer surgeonId;
    private Integer patientId;
    private Integer surgeryId;
    private String location;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private Boolean finished;
}
