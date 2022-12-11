package cs631.MMA.models;

import cs631.MMA.entities.Physician;
import cs631.MMA.entities.enumtype.Gender;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhysicianDTO {
    private Integer id;
    private String name;
    private Gender gender;
    private String tel;
    private String address;
    private String SSN;
    private Integer annualSalary;
    private String specialty;
    private Integer percentOwnership;

    public Physician toPhysician() {
        return Physician.builder()
                .name(this.name)
                .gender(this.gender)
                .tel(this.tel)
                .address(this.address)
                .SSN(this.SSN)
                .annualSalary(this.annualSalary)
                .specialty(this.specialty)
                .percentOwnership(this.percentOwnership)
                .build();
    }
}
