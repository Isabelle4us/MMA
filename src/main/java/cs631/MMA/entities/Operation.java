package cs631.MMA.entities;

import cs631.MMA.models.OperationDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

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
    private Date date;
    private Date startDate;
    private Date endDate;
    private Boolean finished;

    public OperationDTO toDTO() {
        return OperationDTO.builder()
                .id(this.id)
                .surgeonId(this.surgeon.getId())
                .patientId(this.patient.getId())
                .surgeryId(this.surgery.getId())
                .location(this.location)
                .date(this.date)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .finished(this.finished)
                .build();
    }
}
