package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import cs631.MMA.models.OperationDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Surgeon surgeon;
    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;
    @ManyToOne
    private Surgery surgery;
    private String location;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private Boolean finished;

    public OperationDTO toDTO() {
        return OperationDTO.builder()
                .id(this.id)
                .surgeonId(this.surgeon.getId())
                .patientId(this.patient.getId())
                .surgeryId(this.surgery.getId())
                .location(this.location)
                .date(this.date)
                .start(this.start)
                .end(this.end)
                .finished(this.finished)
                .build();
    }
}
