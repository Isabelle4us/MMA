package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import cs631.MMA.entities.enumtype.Gender;
import cs631.MMA.models.PhysicianDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Physician extends Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer annualSalary;
    private String specialty;
    private Integer percentOwnership;

    @OneToMany(
            mappedBy = "physician",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Consultation> Consultations;

    @Builder
    public Physician(Integer id, String name, Gender gender, String tel, String address, String SSN,
                     Integer annualSalary, String specialty, Integer percentOwnership) {
        super(id, name, gender, tel, address, SSN);
        this.annualSalary = annualSalary;
        this.specialty = specialty;
        this.percentOwnership = percentOwnership;
    }

    public PhysicianDTO toDTO() {
        return PhysicianDTO.builder()
                .id(this.id)
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
