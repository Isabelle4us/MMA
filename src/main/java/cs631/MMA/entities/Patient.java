package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import cs631.MMA.entities.enumtype.BloodType;
import cs631.MMA.entities.enumtype.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private Long patientNo;
    private String name;
    private String tel;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    private Double bloodSugar;
    private Double HDL;
    private Double LDL;
    private Double triglyceride;
    private String SSN;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference(value="patient-consultation")
    private List<Consultation> consultations;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference(value="patient-operation")
    private List<Operation> operations;
}
