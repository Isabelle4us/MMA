package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import cs631.MMA.entities.enumtype.BloodType;
import cs631.MMA.entities.enumtype.Gender;
import cs631.MMA.models.PatientDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Long patientNo;
    private String name;
    private String tel;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;
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
    private List<Consultation> consultations;

    @OneToMany(
            mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Operation> operations;


    public PatientDTO toDTO() {
        return PatientDTO.builder()
                .id(this.getId())
                .HDL(this.getHDL())
                .LDL(this.getLDL())
                .patientNo(this.getPatientNo())
                .birthday(this.getBirthday())
                .bloodSugar(this.getBloodSugar())
                .SSN(this.getSSN())
                .tel(this.getTel())
                .name(this.getName())
                .bloodType(this.getBloodType())
                .gender(this.getGender())
                .triglyceride(this.getTriglyceride())
                .build();
    }
}
