package cs631.MMA.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
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
    @JsonManagedReference(value="physician-consultation")
    private List<Consultation> Consultations;
}
