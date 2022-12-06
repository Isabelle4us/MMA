package cs631.MMA.entities;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    private String admission;

    @OneToOne(fetch = FetchType.LAZY)
    private Bed bed;

    @ManyToOne(fetch = FetchType.LAZY)
    private Nurse nurse;
}
