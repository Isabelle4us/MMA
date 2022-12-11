package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import cs631.MMA.entities.enumtype.Gender;
import cs631.MMA.models.PhysicianDTO;
import cs631.MMA.models.SurgeonDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Surgeon extends Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contractType;
    private Integer contractLength;
    private String specialty;

    @OneToMany(
            mappedBy = "surgeon",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Operation> operations;

    @Builder
    public Surgeon(Integer id, String name, Gender gender, String tel, String address, String SSN,
                   String contractType, Integer contractLength, String specialty) {
        super(id, name, gender, tel, address, SSN);
        this.contractType = contractType;
        this.specialty = specialty;
        this.contractLength = contractLength;
    }

    public SurgeonDTO toDTO() {
        return SurgeonDTO.builder()
                .id(this.id)
                .name(this.name)
                .gender(this.gender)
                .tel(this.tel)
                .address(this.address)
                .SSN(this.SSN)
                .contractType(this.contractType)
                .specialty(this.specialty)
                .contractLength(this.contractLength)
                .build();
    }
}
