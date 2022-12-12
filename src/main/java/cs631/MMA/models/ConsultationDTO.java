package cs631.MMA.models;

import cs631.MMA.entities.Consultation;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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
    private Date date;
    private Date startDate;
    private Date endDate;
    private Boolean diagnosed;
    private Boolean active;

    public Consultation toConsultation() {
        return Consultation.builder()
                .date(this.date)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .diagnosed(this.diagnosed)
                .active(this.active)
                .build();
    }
}
