package cs631.MMA.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ConsultationRequest {
    private Integer patientId;
    private Integer physicianId;
    private Integer illnessId;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
}
