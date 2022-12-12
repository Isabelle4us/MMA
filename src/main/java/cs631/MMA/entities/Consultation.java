package cs631.MMA.entities;

import cs631.MMA.models.ConsultationDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Physician physician;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne
    private Illness illness;
    private Date date;
    private Date startDate;
    private Date endDate;
    private Boolean diagnosed;
    private Boolean active;

    public ConsultationDTO toDTO() {
        return ConsultationDTO.builder()
                .date(this.date)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .diagnosed(this.diagnosed)
                .active(this.active)
                .id(this.id)
                .illnessId(this.illness.getId())
                .patientId(this.patient.getId())
                .physicianId(this.physician.getId())
                .build();
    }
}
