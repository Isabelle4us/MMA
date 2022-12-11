package cs631.MMA.entities;

import cs631.MMA.models.InpatientDTO;
import cs631.MMA.models.PatientDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inpatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String admission;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Physician physician;

    @OneToOne(fetch = FetchType.LAZY)
    private Bed bed;

    @ManyToOne(fetch = FetchType.LAZY)
    private Nurse nurse;

    public InpatientDTO toDTO() {
        return InpatientDTO.builder()
                .id(this.id)
                .patientId(this.patient.getId())
                .physicianId(this.physician.getId())
                .bedId(this.bed.getId())
                .nurseId(this.nurse.getId())
                .admission(this.admission)
                .build();
    }
}
