package cs631.MMA.entities;

import cs631.MMA.entities.enumtype.Gender;
import cs631.MMA.models.NurseDTO;
import cs631.MMA.models.PhysicianDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Nurse extends Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer annualSalary;
    private Integer yearOfExp;
    private String grade;

    @Builder
    public Nurse(Integer id, String name, Gender gender, String tel, String address, String SSN,
                     Integer annualSalary, Integer yearOfExp, String grade) {
        super(id, name, gender, tel, address, SSN);
        this.annualSalary = annualSalary;
        this.yearOfExp = yearOfExp;
        this.grade = grade;
    }

    public NurseDTO toDTO() {
        return NurseDTO.builder()
                .id(this.id)
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
