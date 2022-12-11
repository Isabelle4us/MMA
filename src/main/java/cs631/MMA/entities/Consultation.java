package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import cs631.MMA.models.ConsultationDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private Boolean diagnosed;
    private Boolean active;

    public ConsultationDTO toDTO() {
        return ConsultationDTO.builder()
                .date(this.date)
                .start(this.start)
                .end(this.end)
                .diagnosed(this.diagnosed)
                .active(this.active)
                .id(this.id)
                .illnessId(this.illness.getId())
                .patientId(this.patient.getId())
                .physicianId(this.physician.getId())
                .build();
    }
}
