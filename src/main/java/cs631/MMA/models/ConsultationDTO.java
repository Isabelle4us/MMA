package cs631.MMA.models;

import cs631.MMA.entities.Consultation;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultationDTO {
    private Integer id;
    private Integer physicianId;
    private Integer patientId;
    private Integer illnessId;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private Boolean diagnosed;
    private Boolean active;

    public Consultation toConsultation() {
        return Consultation.builder()
                .date(this.date)
                .start(this.start)
                .end(this.end)
                .diagnosed(this.diagnosed)
                .active(this.active)
                .build();
    }
}
