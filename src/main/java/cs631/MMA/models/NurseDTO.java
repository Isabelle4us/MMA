package cs631.MMA.models;

import cs631.MMA.entities.Nurse;
import cs631.MMA.entities.enumtype.Gender;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NurseDTO {
    private Integer id;
    private String name;
    private Gender gender;
    private String tel;
    private String address;
    private String SSN;
    private Integer annualSalary;
    private Integer yearOfExp;
    private String grade;

    public Nurse toNurse() {
        return Nurse.builder()
                .name(this.name)
                .gender(this.gender)
                .tel(this.tel)
                .address(this.address)
                .SSN(this.SSN)
                .annualSalary(this.annualSalary)
                .yearOfExp(this.yearOfExp)
                .grade(this.grade)
                .build();
    }
}
