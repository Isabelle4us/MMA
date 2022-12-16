package cs631.MMA.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import cs631.MMA.entities.Patient;
import cs631.MMA.entities.enumtype.BloodType;
import cs631.MMA.entities.enumtype.Gender;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {
    private Integer id;
    private Long patientNo;
    private String name;
    private String tel;
    private Gender gender;
    private Date birthday;
    private BloodType bloodType;
    private Double bloodSugar;
    private Double HDL;
    private Double LDL;
    private Double triglyceride;
    private String SSN;

    private Boolean chol;

    public Patient toPatient() {
        return Patient.builder()
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
