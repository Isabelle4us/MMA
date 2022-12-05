package cs631.MMA.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Inpatient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    private String admission;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bed bed;

    @ManyToOne(fetch = FetchType.LAZY)
    private Nurse nurse;
}
