package cs631.MMA.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class PrescriptionArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String physicianName;

    private String physicianId;

    private String patientName;

    private String patientId;

    private double dosage;

    private String frequency;

    private LocalDate date;
}
